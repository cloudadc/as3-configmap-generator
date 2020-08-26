package io.github.cloudadc.controller;

import static io.github.cloudadc.controller.Utils.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(produces = {"application/json", "application/xml"})
@Tag(name = "CIS AS3 Configmap", description = "F5 CIS AS3 Configmap Generator API API")
public class GeneratorController {
	
	@RequestMapping(path = {"/version"}, method = {RequestMethod.GET})
	@Operation(summary = "Get version", description = "Return version")
	public GeneratorVersion version() {
		return new GeneratorVersion("1.0");
	}
	
	@RequestMapping(path = {"/generate/serviceLables"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate Service Labels", description = "Returns all 3 cis.f5.com lables")
	public Map<String, String> generateSvcLables(@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, @Parameter(description = "The name of K8S/OpenShift service", required = true)String service, @Parameter(description = "The port number of K8S/OpenShift service", required = true)int port) {
		
		Map<String, String> map = new HashMap<>();
		
		map.put("cis.f5.com/as3-tenant", tenant(namespace));
		map.put("cis.f5.com/as3-app", app(namespace, service));
		map.put("cis.f5.com/as3-pool", pool(namespace, service, port));
		
		return map;
	}

	@RequestMapping(path = {"/generate/http"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS HTTP Service Configmap", description = "Returns F5 CIS HTTP Service Configmap")
	public String generateHTTP(
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "The F5 Virtual Server IP", required = true)String ip) throws IOException {
		
		return generate(namespace, service, port, ip, null, null, "header.tml", "http.tml", "footer.tml");
	}
	
	@RequestMapping(path = {"/generate/httpCustomMonitor"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS HTTP Service Configmap", description = "Returns F5 CIS HTTP Service Configmap")
	public String generateHTTPCustomMonitor(
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "HTTP Health Monitor Path", required = true)String path,
			@Parameter(description = "HTTP Health Monitor expected result", required = true)String expected) throws IOException {
		
		return generate(namespace, service, port, ip, path, expected, "header.tml", "http-with-custom-monitor.tml", "footer.tml");
	}
	
	@RequestMapping(path = {"/generate/tcp"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS TCP Service Configmap", description = "Returns F5 CIS TCP Service Configmap")
	public String generateTCP(
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "The F5 Virtual Server IP", required = true)String ip) throws IOException {
		
		return generate(namespace, service, port, ip, null, null, "header.tml", "tcp.tml", "footer.tml");
	}

	

}
