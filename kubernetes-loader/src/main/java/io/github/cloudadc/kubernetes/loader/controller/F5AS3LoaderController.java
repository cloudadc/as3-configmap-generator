package io.github.cloudadc.kubernetes.loader.controller;

import static io.github.cloudadc.kubernetes.loader.utils.Utils.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.cloudadc.kubernetes.loader.K8SConfigmapLoader;
import io.github.cloudadc.kubernetes.loader.model.ServiceAttribute;
import io.github.cloudadc.kubernetes.loader.model.VirtualServerAttribute;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @author Kylin Soong
 *
 */
@RestController
@RequestMapping(
		produces = {"application/json"}, 
		consumes = {"application/json"}
		)
@Tag(name = "Kubernetes AS3 Loader", description = "Load F5 BIG-IP AS3 template to Kubernetes Configmap")
public class F5AS3LoaderController {
	
	@RequestMapping(path = {"/list"}, method = {RequestMethod.GET})
	@Operation(summary = "List all Virtual Servers from all partitions", description = "Returns  all Virtual Servers from all partitions")
	public Map<String, Object> listAllVirtualServers() throws Exception{
				
		return K8SConfigmapLoader.create().listAllVirtualServers();
	}
	
	@RequestMapping(path = {"/list/{tenant}"}, method = {RequestMethod.GET})
	@Operation(summary = "List all Virtual Servers from all partitions", description = "Returns  all Virtual Servers from all partitions")
	public Map<String, Object> listAllVirtualServers(@Parameter(description = "F5 BIG-IP partition name", required = true) String tenant) throws Exception{
				
		return K8SConfigmapLoader.create().listAllVirtualServers(tenant);
	}
	
	@RequestMapping(path = {"/add/service/labels"}, method = {RequestMethod.POST})
	@Operation(summary = "Add Service lables to s K8S Services", description = "Returns as3 labels")
	public Map<String, String> addSvcLables(
			@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The service position, name, targetport", required = true)  @RequestBody ServiceAttribute attribute
			) throws IOException {
		
		Map<String, String> map = new HashMap<>();
		
		map.put("cis.f5.com/as3-tenant", attribute.getNamespace());
		map.put("cis.f5.com/as3-app", attribute.getService() + "-app");
		map.put("cis.f5.com/as3-pool", attribute.getService() + "-app-pool");
		
		return map;
	}
	
	@RequestMapping(path = {"/add/l4/tcp"}, method = {RequestMethod.POST})
	@Operation(summary = "Add L4 APP Declaration", description = "Add L4 APP Declaration")
	public VirtualServerAttribute generateTCP(
			@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The Virtual Server IP/Port, if hubmode enable, hub namespace, configmap name", required = true)  @RequestBody VirtualServerAttribute attribute) throws Exception {
		
		return K8SConfigmapLoader.create().appendConfigmap(attribute);
	}
	
	
	
	

	@RequestMapping(path = {"/generate/http"}, method = {RequestMethod.GET})
	@Operation(summary = "HTTP {cookie persistence, least-connections-member, custom health monitor}", description = "Returns F5 CIS HTTP Service Configmap")
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
	
	
	
}