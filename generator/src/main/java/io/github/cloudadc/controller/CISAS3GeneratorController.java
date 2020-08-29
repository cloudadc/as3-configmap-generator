package io.github.cloudadc.controller;

import static io.github.cloudadc.controller.Utils.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @author Kylin Soong
 *
 */
@RestController
@RequestMapping(produces = {"application/json", "text/plain"})
@Tag(name = "CIS AS3 Configmap - Deployment", description = "F5 CIS AS3 Configmap Generator API")
public class CISAS3GeneratorController {
	
	@RequestMapping(path = {"/generate/serviceLables"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate Service Labels", description = "Returns all 3 cis.f5.com lables")
	public Map<String, String> generateSvcLables(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port) {
		
		Map<String, String> map = new HashMap<>();
		
		map.put("cis.f5.com/as3-tenant", tenant(cluster, namespace));
		map.put("cis.f5.com/as3-app", app(namespace, service));
		map.put("cis.f5.com/as3-pool", pool(namespace, service, port));
		
		return map;
	}
	
	@RequestMapping(path = {"/generate/http_cookie"}, method = {RequestMethod.GET})
	@Operation(summary = "HTTP {X-Forwarded-For, cookie persistence with encryption, least-connections-member, http monitor}", description = "Returns F5 CIS HTTP Service Configmap")
	public String generateHTTP(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort,
			@Parameter(description = "HTTP Health Monitor Path", required = true, allowEmptyValue = true)String path,
			@Parameter(description = "HTTP Health Monitor expected result", required = true, allowEmptyValue = true)String expected,
			@Parameter(description = "Create Virtual Server IP", required = true)boolean isCreateVS) throws IOException {
		
		String tml_full = "http.tml";
		String tml_pool_only = "no-vs-http.tml";
		
		if(expected != null && expected.length() > 0 && path != null && path.length() > 0) {
			tml_full = "http-with-custom-monitor.tml";
			tml_pool_only = "no-vs-http-with-custom-monitor.tml";
		}
		
		if(!isCreateVS) {
			return generate(cluster, namespace, service, port, ip, vsPort, path, expected, tml_pool_only);
		}
		
		return generate(cluster, namespace, service, port, ip, vsPort, path, expected, tml_full);
	}
	
	@RequestMapping(path = {"/generate/http_cookie_tcp_monitor"}, method = {RequestMethod.GET})
	@Operation(summary = "HTTP {X-Forwarded-For, cookie persistence with encryption, least-connections-member, tcp monitor}", description = "Returns F5 CIS HTTP Service Configmap")
	public String generateHTTP(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort,
			@Parameter(description = "Create Virtual Server IP", required = true)boolean isCreateVS) throws IOException {
		
		if(!isCreateVS) {
			return generate(cluster, namespace, service, port, ip, vsPort, null, null, "no-vs-http-tcp.tml");
		}
		
		return generate(cluster, namespace, service, port, ip, vsPort, null, null, "http-tcp.tml");
	}
	
	
	
	@RequestMapping(path = {"/generate/tcp"}, method = {RequestMethod.GET})
	@Operation(summary = "TCP {fastL4}", description = "Returns F5 CIS TCP Service Configmap")
	public String generateTCP(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "The F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort,
			@Parameter(description = "Create Virtual Server IP", required = true)boolean isCreateVS) throws IOException {
		
		if(!isCreateVS) {
			return generate(cluster, namespace, service, port, ip, vsPort, null, null, "no-vs-tcp.tml");
		} 
		
		return generate(cluster, namespace, service, port, ip, vsPort, null, null, "tcp.tml");
	}
	
}