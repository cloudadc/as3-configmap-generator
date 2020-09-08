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
@RequestMapping(produces = {"text/plain", "application/json"})
@Tag(name = "CIS AS3 Configmap - Deployment", description = "F5 CIS AS3 Configmap Generator API")
public class CISAS3GeneratorController {
	
	@RequestMapping(path = {"/generate/deployments"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate K8S/OpenShift Deployment YAML", description = "Returns Deployment YAML")
	public String generateSvcLables(
			@Parameter(description = "K8S/OpenShift cluster name", required = true, allowEmptyValue = true) String cluster, 
			@Parameter(description = "K8S/OpenShift namespace name", required = true) String namespace, 
			@Parameter(description = "K8S/OpenShift service name", required = true)String service, 
			@Parameter(description = "K8S/OpenShift service port", required = true)int port,
			@Parameter(description = "Docker Image", required = true)EntityK8SImage k8sImage) throws IOException {
		
		Map<String, String> map = new HashMap<>();
		
		map.put("cis.f5.com/as3-tenant", tenant(cluster, namespace));
		map.put("cis.f5.com/as3-app", app(namespace, service));
		map.put("cis.f5.com/as3-pool", pool(namespace, service, port));
		
		return generate(cluster, namespace, service, port, k8sImage);
	}

	@RequestMapping(path = {"/generate/http_advanced"}, method = {RequestMethod.GET})
	@Operation(summary = "HTTP {X-Forwarded-For, cookie persistence with encryption, least-connections-member, custom health monitor}", description = "Returns F5 CIS HTTP Service Configmap")
	public String generateHTTP(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true, allowEmptyValue = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort,
			@Parameter(description = "HTTP Health Monitor Path", required = true, allowEmptyValue = true)String path,
			@Parameter(description = "HTTP Health Monitor expected result", required = true, allowEmptyValue = true)String expected,
			@Parameter(description = "Whether to use tcp health monitor", required = true)Boolean isTCPMonitor) throws IOException {
		
		String tml_full = "http.tml";
		
		if(isTCPMonitor) {
			tml_full = "http-tcp.tml";
		} else if(expected != null && expected.length() > 0 && path != null && path.length() > 0) {
			tml_full = "http-with-custom-monitor.tml";
		}
		
		return generate(cluster, namespace, service, port, ip, vsPort, path, expected, tml_full);
	}
	
	@RequestMapping(path = {"/generate/tcp"}, method = {RequestMethod.GET})
	@Operation(summary = "TCP {fastL4}", description = "Returns F5 CIS TCP Service Configmap")
	public String generateTCP(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true, allowEmptyValue = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "The F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort) throws IOException {
		
//		if(!isCreateVS) {
//			return generate(cluster, namespace, service, port, ip, vsPort, null, null, "no-vs-tcp.tml");
//		} 
		
		return generate(cluster, namespace, service, port, ip, vsPort, null, null, "tcp.tml");
	}
	
}