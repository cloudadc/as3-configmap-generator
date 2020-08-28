package io.github.cloudadc.controller;

import static io.github.cloudadc.controller.Utils.generateCCCL;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(produces = {"application/json", "application/xml", "text/plain"})
@Tag(name = "CIS CCCL Configmap", description = "F5 CIS CCCL Configmap Generator API")
public class CISCCCLGeneratorController {
	
	@RequestMapping(path = {"/generate/cccl/confgimap"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS CCCL Configmap", description = "Returns F5 CIS CCCL Configmap")
	public String generateConfigmap(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort) throws IOException {

		
		return generateCCCL(cluster, namespace, service, port, ip, vsPort, "cccl.tml");
	}

}
