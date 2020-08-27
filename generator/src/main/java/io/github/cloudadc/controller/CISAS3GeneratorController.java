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

@RestController
@RequestMapping(produces = {"application/json", "application/xml", "text/plain"})
@Tag(name = "CIS AS3 Configmap", description = "F5 CIS AS3 Configmap Generator API")
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

	@RequestMapping(path = {"/generate/http"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS HTTP Service Configmap", description = "Returns F5 CIS HTTP Service Configmap")
	public String generateHTTP(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort,
			@Parameter(description = "Whether the service is canary service", required = false)boolean isCanary) throws IOException {

		if(isCanary) {
			return generate(cluster, namespace, service, port, ip, vsPort, null, null, isCanary, "header.tml", "canary-http.tml", "footer.tml");
		}
		
		return generate(cluster, namespace, service, port, ip, vsPort, null, null, isCanary, "header.tml", "http.tml", "footer.tml");
	}
	
	@RequestMapping(path = {"/generate/httpCustomMonitor"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS HTTP Service Configmap with custom health check", description = "Returns F5 CIS HTTP Service Configmap")
	public String generateHTTPCustomMonitor(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort,
			@Parameter(description = "HTTP Health Monitor Path", required = true)String path,
			@Parameter(description = "HTTP Health Monitor expected result", required = true)String expected,
			@Parameter(description = "Whether the service is canary service", required = false)boolean isCanary) throws IOException {
		
		if(isCanary) {
			return generate(cluster, namespace, service, port, ip, vsPort, path, expected, isCanary, "header.tml", "canary-http-with-custom-monitor.tml", "footer.tml");
		}
		
		return generate(cluster, namespace, service, port, ip, vsPort, path, expected, isCanary, "header.tml", "http-with-custom-monitor.tml", "footer.tml");
	}
	
	@RequestMapping(path = {"/generate/tcp"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS TCP Service Configmap", description = "Returns F5 CIS TCP Service Configmap")
	public String generateTCP(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "The F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort,
			@Parameter(description = "Whether the service is canary service", required = false)boolean isCanary) throws IOException {
		
		if(isCanary) {
			return generate(cluster, namespace, service, port, ip, vsPort, null, null, isCanary, "header.tml", "canary-tcp.tml", "footer.tml");
		} 
		
		return generate(cluster, namespace, service, port, ip, vsPort, null, null, isCanary, "header.tml", "tcp.tml", "footer.tml");
	}
	
}
