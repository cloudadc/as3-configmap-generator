package io.github.cloudadc.controller;

import static io.github.cloudadc.controller.Utils.generate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

public class Utils {
	
	static final String VERSION = "0.0.1";
	static final String AS3_VERSION = "3.19.0";
	static final String CIS_VERSION = "2.1.0";
	
	static final String UNDERSCORE = "_";
	static final String COMMA = ",";
	static final String NEWLINE = "\n";
	static final String POOL = "pool";
	static final String VS = "vs";
	static final String APP = "app";
	
	static final String REPLACEMENT_NAMESPACE = "REPLACEMENT_NAMESPACE";
	
	static final String REPLACEMENT_CONFIGMAP_NAME = "REPLACEMENT_CONFIGMAP_NAME";
	
	static final String REPLACEMENT_AS3_SCHEMA_VERSION = "REPLACEMENT_AS3_SCHEMA_VERSION";
	
	static final String REPLACEMENT_TENANT_NAME = "REPLACEMENT_TENANT_NAME";
	
	static final String REPLACEMENT_APP_NAME = "REPLACEMENT_APP_NAME";
	
	static final String REPLACEMENT_POOL_NAME = "REPLACEMENT_POOL_NAME";
	
	static final String REPLACEMENT_VS_NAME = "REPLACEMENT_VS_NAME";
	
	static final String REPLACEMENT_VS_IPADDR = "REPLACEMENT_VS_IPADDR";
	
	static final String REPLACEMENT_VS_PORT = "REPLACEMENT_VS_PORT";
	
	static final String REPLACEMENT_SERVICE_PORT = "REPLACEMENT_SERVICE_PORT";
	
	static final String REPLACEMENT_HEALTHCHECK_PATH = "REPLACEMENT_HEALTHCHECK_PATH";
	
	static final String REPLACEMENT_HEALTHCHECK_EXPECTED = "REPLACEMENT_HEALTHCHECK_EXPECTED";
	
	static Map<String, ArrayList<GeneratorApp>> cmMap = new HashMap<>();
	
	public static String generate(String cluster, String namespace, String service, int port, String vsIP, int vsPort, String path, String expected, boolean isCanary, String header, String app, String footer) throws IOException {
		
		String start = load(header);
		start = start.replaceAll(REPLACEMENT_CONFIGMAP_NAME, cm_name(namespace));
		start = start.replaceAll(REPLACEMENT_NAMESPACE, namespace);
		start = start.replaceAll(REPLACEMENT_AS3_SCHEMA_VERSION, AS3_VERSION);
		start = start.replaceAll(REPLACEMENT_TENANT_NAME, tenant(cluster, namespace));
		
		String content = load(app);
		content = content.replaceAll(REPLACEMENT_APP_NAME, app(namespace, service));
		content = content.replaceAll(REPLACEMENT_VS_NAME, vs(service, vsPort));
		content = content.replaceAll(REPLACEMENT_VS_IPADDR, vsIP);
		content = content.replaceAll(REPLACEMENT_VS_PORT, String.valueOf(vsPort));
		content = content.replaceAll(REPLACEMENT_SERVICE_PORT, String.valueOf(port));
		content = content.replaceAll(REPLACEMENT_POOL_NAME, pool(namespace, service, port));		
		if(expected != null && path != null) {
			content = content.replaceAll(REPLACEMENT_HEALTHCHECK_PATH, path);
			content = content.replaceAll(REPLACEMENT_HEALTHCHECK_EXPECTED, expected);
		}
				
		ArrayList<GeneratorApp> apps = cmMap.get(tenant(cluster, namespace));
		
		if(apps == null || apps.size() == 0) {
			apps = new ArrayList<GeneratorApp>();
			cmMap.put(tenant(cluster, namespace), apps);
			apps.add(new GeneratorApp(app(namespace, service), content));
		} else {
			if(!updateIfExist(apps,app(namespace, service), content)) {
				apps.add(new GeneratorApp(app(namespace, service), content));
			}
		}
		
		String end = load(footer);
		
		boolean firstAPP = true;
		String results = start + NEWLINE;
		
		for (int i = 0 ; i < apps.size() ; i++) {
			if(firstAPP) {
				firstAPP = false;
				results = results + apps.get(i).getContent();
			} else {
				results = results + COMMA + NEWLINE + apps.get(i).getContent();
			}
		}
		results = results + NEWLINE + end;
		
		return results;
	}
	
	private static boolean updateIfExist(ArrayList<GeneratorApp> apps, String appName, String content) {
		for (int i = 0 ; i < apps.size() ; i++) {
			if(apps.get(i).getAppName().equals(appName)) {
				apps.get(i).setContent(content);
				return true;
			}
		}
		return false;
	}

	public static String vs(String service, int port) {
		return service + UNDERSCORE + port + UNDERSCORE + VS;
	}

	public static String cm_name(String namespace) {
		return "f5-cis-configmap-" + namespace;
	}

	public static String pool(String namespace, String service, int port) {
		return namespace + UNDERSCORE + service + UNDERSCORE + port + UNDERSCORE + POOL;
	}

	public static String app(String namespace, String service) {
		return namespace + UNDERSCORE + service + UNDERSCORE + APP;
	}

	public static String tenant(String cluster, String namespace) {
		return cluster + UNDERSCORE + namespace;
	}

	public static String load(String name) throws IOException  {
		
		Resource resource = new ClassPathResource("classpath:" + name);
		if (resource.exists()) {
			try (InputStream inputStream = resource.getInputStream()){
				byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
				return new String(bdata, StandardCharsets.UTF_8);
			} catch (IOException e) {
				throw e;
			}
		} else {
			try (InputStream inputStream = new FileInputStream(new File("src/main/resources/" + name))){
				byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
				return new String(bdata, StandardCharsets.UTF_8);
			} catch (IOException e) {
				
				throw e;
			}
		}
		
		
		
	}
	
	public static void main(String[] arvs) throws IOException {
		generate("cluster01", "test001", "app-v1-svc", 80, "192.168.5.40", 80, null, null, false, "header.tml", "http.tml", "footer.tml");
		generate("cluster01", "test001", "app-v2-svc", 80, "192.168.5.40", 80, null, null, false, "header.tml", "http.tml", "footer.tml");
	}
}
