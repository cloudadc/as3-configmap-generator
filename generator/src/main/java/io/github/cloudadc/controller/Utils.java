package io.github.cloudadc.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

public class Utils {
	
	static final String UNDERSCORE = "_";
	static final String NEWLINE = "\n";
	
	static final String REPLACEMENT_NAMESPACE = "REPLACEMENT_NAMESPACE";
	
	static final String REPLACEMENT_CONFIGMAP_NAME = "REPLACEMENT_CONFIGMAP_NAME";
	
	static final String REPLACEMENT_TENANT_NAME = "REPLACEMENT_TENANT_NAME";
	
	static final String REPLACEMENT_APP_NAME = "REPLACEMENT_APP_NAME";
	
	static final String REPLACEMENT_POOL_NAME = "REPLACEMENT_POOL_NAME";
	
	static final String REPLACEMENT_VS_NAME = "REPLACEMENT_VS_NAME";
	
	static final String REPLACEMENT_VS_IPADDR = "REPLACEMENT_VS_IPADDR";
	
	static final String REPLACEMENT_SERVICE_PORT = "REPLACEMENT_SERVICE_PORT";
	
	static final String REPLACEMENT_HEALTHCHECK_PATH = "REPLACEMENT_HEALTHCHECK_PATH";
	
	static final String REPLACEMENT_HEALTHCHECK_EXPECTED = "REPLACEMENT_HEALTHCHECK_EXPECTED";
	
	public static String generate(String namespace, String service, int port, String ip, String path, String expected, String header, String app, String footer) throws IOException {
		
		String start = load(header);
		start = start.replaceAll(REPLACEMENT_CONFIGMAP_NAME, name(namespace));
		start = start.replaceAll(REPLACEMENT_NAMESPACE, namespace);
		
		String content = load(app);
		content = content.replaceAll(REPLACEMENT_TENANT_NAME, tenant(namespace));
		content = content.replaceAll(REPLACEMENT_APP_NAME, app(namespace, service));
		content = content.replaceAll(REPLACEMENT_VS_NAME, vs(service, port));
		content = content.replaceAll(REPLACEMENT_VS_IPADDR, ip);
		content = content.replaceAll(REPLACEMENT_SERVICE_PORT, String.valueOf(port));
		content = content.replaceAll(REPLACEMENT_POOL_NAME, pool(namespace, service, port));		
		if(expected != null && path != null) {
			content = content.replaceAll(REPLACEMENT_HEALTHCHECK_PATH, path);
			content = content.replaceAll(REPLACEMENT_HEALTHCHECK_EXPECTED, expected);
		}
		
		String end = load(footer);
		
		
		return start + NEWLINE + content + NEWLINE + end;
	}
	
	public static String vs(String service, int port) {
		return service + UNDERSCORE + port + UNDERSCORE + "vs";
	}

	public static String name(String namespace) {
		return "f5-cis-configmap-" + namespace;
	}

	public static String pool(String namespace, String service, int port) {
		return namespace + UNDERSCORE + service + UNDERSCORE + port + UNDERSCORE +"pool";
	}

	public static String app(String namespace, String service) {
		return namespace + UNDERSCORE + service + UNDERSCORE + "svc";
	}

	public static String tenant(String namespace) {
		return namespace;
	}

	public static String load(String name) throws IOException  {
		
		Resource resource = new ClassPathResource("classpath:" + name);
		
		try (InputStream inputStream = resource.getInputStream()){
			byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
			return new String(bdata, StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw e;
		}
		
	}
}
