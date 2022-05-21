package io.github.cloudadc.kubernetes.loader;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.cloudadc.kubernetes.as3.model.AS3Class;
import io.github.cloudadc.kubernetes.as3.model.Template;



public class JSONWrapper {

	public static void main(String[] args) throws JsonParseException, IOException {

		URL source = JSONWrapper.class.getResource("/cm/cm.json");
		
		ObjectMapper mapper = new ObjectMapper();
		
		Template template = mapper.readValue(source.openStream(), Template.class);
	//	Map<String, Object> tenant_ = (Map<String, Object>) template.getDeclaration().get("cistest003");
	//	Map<String, Object> app_ = (Map<String, Object>) tenant_.get("app-1");
//		Map<String, Object> vs = (Map<String, Object>) app.get("app_svc_vs");
	//	Map<String, Object> pool_ = (Map<String, Object>) app_.get("app-1_app_svc_pool");
	//	ArrayList list = (ArrayList) pool_.get("members");
		
		template.getDeclaration().remove("cistest001");
		
		Map<String, Object> tenant = new LinkedHashMap<>();
		template.getDeclaration().put("cistest002", tenant);
		
		Map<String, Object> app =  new LinkedHashMap<>();
		tenant.put("class", AS3Class.Tenant);
		tenant.put("app-1", app);
		
		Map<String, Object> vs = new LinkedHashMap<>();
		Map<String, Object> pool = new LinkedHashMap<>();
		app.put("class", AS3Class.Application);
		app.put("template", "generic");
		app.put("app_svc_vs", vs);
		app.put("app-1_app_svc_pool", pool);
		
		ArrayList<String> persistenceMethods = new ArrayList<>();
		persistenceMethods.add("cookie");
		ArrayList<String> virtualAddresses = new ArrayList<>();
		virtualAddresses.add("10.10.10.2");
		vs.put("class", AS3Class.Service_HTTP);
		vs.put("persistenceMethods", persistenceMethods);
		vs.put("virtualAddresses", virtualAddresses);
		vs.put("snat", "self");
		vs.put("virtualPort", 80);
		vs.put("pool", "app-1_app_svc_pool");
		
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
		
		 
		String json = mapper.writer(new DefaultPrettyPrinter()).writeValueAsString(template);
		 
		System.out.println(json);
	}

}
