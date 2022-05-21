package io.github.cloudadc.kubernetes.loader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.cloudadc.kubernetes.as3.model.AS3Class;
import io.github.cloudadc.kubernetes.as3.model.Template;
import io.github.cloudadc.kubernetes.loader.model.VirtualServerAttribute;
import io.kubernetes.client.common.KubernetesObject;
import io.kubernetes.client.custom.V1Patch;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1ConfigMap;
import io.kubernetes.client.openapi.models.V1Service;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;

import static io.kubernetes.client.extended.kubectl.Kubectl.label;


public class K8SConfigmapLoader {
	
	static {
		System.setProperty("jdk.tls.client.protocols", "TLSv1.2");
	}
	
	final ApiClient client;
	final CoreV1Api api;
	
	protected K8SConfigmapLoader() throws  IOException {

		String kubeConfigPath = System.getenv("HOME") + "/.kube/config";
		client = ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(kubeConfigPath))).build();
		Configuration.setDefaultApiClient(client);
		api = new CoreV1Api();
	}
	
	protected CoreV1Api api() {
		return api;
	}
	
	protected ApiClient client() {
		return client;
	}

	protected Template loadConfigmap() throws ApiException, StreamReadException, DatabindException, IOException  {
		
		V1ConfigMap cm = api.readNamespacedConfigMap("cm-cistest", "f5-hub-1", null, null, null);
		String content = cm.getData().get("template");
		ObjectMapper mapper = new ObjectMapper();
		Template template = mapper.readValue(content.getBytes(), Template.class);
		return template;
	}
	

	protected V1ConfigMap currentConfigmap() throws ApiException  {
		
		V1ConfigMap cm = api.readNamespacedConfigMap("cm-cistest", "f5-hub-1", null, null, null);
		
		return cm;
	}
	
	
	
	public Map<String, Object> listAllVirtualServers() throws StreamReadException, DatabindException, ApiException, IOException {
		
		Map<String, Object> tenants = new HashMap<>();
		
		loadConfigmap().getDeclaration().forEach((key, value) -> {
			if(key.equals("class") || key.equals("schemaVersion") ||  key.equals("id")) {
				// do nothing
			} else {
				tenants.put(key, value);
			}
		});
		
		return tenants;
	}
	
    public Map<String, Object> listAllVirtualServers(String tenant) throws StreamReadException, DatabindException, ApiException, IOException {
		
		Map<String, Object> tenants = new HashMap<>();
		tenants.put(tenant, loadConfigmap().getDeclaration().get(tenant));
		
		return tenants;
	}
    
    public VirtualServerAttribute appendConfigmap(VirtualServerAttribute attr) throws StreamReadException, DatabindException, ApiException, IOException {
    	
    	Template template = loadConfigmap();
    	
		String tenantKey = attr.getNamespace();
		Map<String, Object> tenant = new LinkedHashMap<>();
		template.getDeclaration().put(tenantKey, tenant);
		tenant.put("class", AS3Class.Tenant);
		
		String appKey = attr.getService() + "-app";
		String vsKey = appKey + "-vs";
		String poolKey = appKey + "-pool";
		Map<String, Object> vs = new LinkedHashMap<>();
		Map<String, Object> pool = new LinkedHashMap<>();
		Map<String, Object> app =  new LinkedHashMap<>();
		tenant.put(appKey, app);
		app.put("class", AS3Class.Application);
		app.put("template", "generic");
		app.put(vsKey, vs);
		app.put(poolKey, pool);
		
		ArrayList<String> persistenceMethods = new ArrayList<>();
		persistenceMethods.add("cookie");
		ArrayList<String> virtualAddresses = new ArrayList<>();
		virtualAddresses.add(attr.getIp());
		vs.put("class", AS3Class.Service_HTTP);
		vs.put("persistenceMethods", persistenceMethods);
		vs.put("virtualAddresses", virtualAddresses);
		vs.put("snat", "self");
		vs.put("virtualPort", attr.getVsPort());
		vs.put("pool", poolKey);
		
		ArrayList<String> monitors = new ArrayList<>();
		monitors.add("tcp");
		ArrayList<Map<String, Object>> members = new ArrayList<>();
		Map<String, Object> poolMember = new LinkedHashMap<>();
		members.add(poolMember);
		pool.put("class", AS3Class.Pool);
		pool.put("monitors", monitors);
		pool.put("loadBalancingMode", "least-connections-member");
		pool.put("members", members);
		
		ArrayList<String> serverAddresses = new ArrayList<>();
		poolMember.put("servicePort", 8080);
		poolMember.put("serverAddresses", serverAddresses);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writer(new DefaultPrettyPrinter()).writeValueAsString(template);
		
		V1ConfigMap cm = currentConfigmap();
		cm.getData().put("template", json);
		
		api.patchNamespacedConfigMap("cm-cistest", "f5-hub-1", new V1Patch(cm.toString()), null, null, null, null);
    	
    	return attr;
    }
    
    public void addServiceLabel(String ns, String name, String labelKey, String labelValue) {
		
		Class<? extends KubernetesObject> clazz = V1Service.class;
		
		label(clazz).apiClient(client()).namespace(ns).name(name).addLabel(labelKey, labelValue);
	
    }
	
	public static K8SConfigmapLoader instance = null;
	
	public static K8SConfigmapLoader create() throws IOException {
		if(instance == null) {
			instance = new K8SConfigmapLoader();
		}
		return instance;
	}


	public static void main(String[] args) throws IOException, ApiException {

		K8SConfigmapLoader loader = K8SConfigmapLoader.create();
		
		VirtualServerAttribute attr = new VirtualServerAttribute("test", "cistest003", "app-svc-1", 8080, "10.1.10.3", 8080, true, "f5-hub-2", "cistest");
		
		
		loader.appendConfigmap(attr);
		
		System.out.println("DONE");
	}

}
