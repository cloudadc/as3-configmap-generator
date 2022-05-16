package io.github.cloudadc.kubernetes.loader.controller;

import static io.github.cloudadc.kubernetes.loader.utils.Utils.generate;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

//@RestController
//@RequestMapping(produces = {"text/plain"})
//@Tag(name = "CIS AS3 Configmap - Canary Releasing", description = "F5 CIS AS3 Configmap Generator API")
public class CISAS3CanaryGeneratorController {
	
	@RequestMapping(path = {"/generate/httpCanaryURL"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS HTTP Service Configmap", description = "Returns F5 CIS HTTP Service Configmap")
	public String generateHTTPCanaryURL(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort,
			@Parameter(description = "HTTP Health Monitor Path", required = true, allowEmptyValue = true)String path,
			@Parameter(description = "HTTP Health Monitor expected result", required = true, allowEmptyValue = true)String expected,
			@Parameter(description = "The new service name of K8S/OpenShift cluster", required = true) String v2_svc_cluster, 
			@Parameter(description = "The new service name of K8S/OpenShift namespace", required = true) String v2_svc_namespace, 
			@Parameter(description = "The new service name of K8S/OpenShift service", required = true)String v2_svc_service, 
			@Parameter(description = "The new service port number of K8S/OpenShift service", required = true)int v2_svc_port,
			@Parameter(description = "Canary URL", required = true) String canaryPath) throws IOException {
		
		String tml_full = "http-canary-url.tml";
		
		if(expected != null && expected.length() > 0 && path != null && path.length() > 0) {
			tml_full = "http-canary-url-with-custom-monitor.tml";
		}
	
		return generate(cluster, namespace, service, port, ip, vsPort, path, expected, v2_svc_cluster, v2_svc_namespace, v2_svc_service, v2_svc_port, canaryPath, null, null, null, null, null, null, -1, "header.tml", tml_full, "footer.tml");
	}
	
	@RequestMapping(path = {"/generate/httpCanaryHeader"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS HTTP Service Configmap", description = "Returns F5 CIS HTTP Service Configmap")
	public String generateHTTPCanaryHeader(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort,
			@Parameter(description = "HTTP Health Monitor Path", required = true, allowEmptyValue = true)String path,
			@Parameter(description = "HTTP Health Monitor expected result", required = true, allowEmptyValue = true)String expected,
			@Parameter(description = "The new service name of K8S/OpenShift cluster", required = true) String v2_svc_cluster, 
			@Parameter(description = "The new service name of K8S/OpenShift namespace", required = true) String v2_svc_namespace, 
			@Parameter(description = "The new service name of K8S/OpenShift service", required = true)String v2_svc_service, 
			@Parameter(description = "The new service port number of K8S/OpenShift service", required = true)int v2_svc_port,
			@Parameter(description = "Canary Http Header", required = true) String header,
			@Parameter(description = "Canary Http Header Value", required = true) String value) throws IOException {
		
		String tml_full = "http-canary-header.tml";
		
		if(expected != null && expected.length() > 0 && path != null && path.length() > 0) {
			tml_full = "http-canary-header-with-custom-monitor.tml";
		}
	
		return generate(cluster, namespace, service, port, ip, vsPort, path, expected, v2_svc_cluster, v2_svc_namespace, v2_svc_service, v2_svc_port, null, header, value, null, null, null, null, -1, "header.tml", tml_full, "footer.tml");
	}
	
	@RequestMapping(path = {"/generate/httpCanaryCookie"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS HTTP Service Configmap", description = "Returns F5 CIS HTTP Service Configmap")
	public String generateHTTPCanaryCookie (
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort,
			@Parameter(description = "HTTP Health Monitor Path", required = true, allowEmptyValue = true)String path,
			@Parameter(description = "HTTP Health Monitor expected result", required = true, allowEmptyValue = true)String expected,
			@Parameter(description = "The new service name of K8S/OpenShift cluster", required = true) String v2_svc_cluster, 
			@Parameter(description = "The new service name of K8S/OpenShift namespace", required = true) String v2_svc_namespace, 
			@Parameter(description = "The new service name of K8S/OpenShift service", required = true)String v2_svc_service, 
			@Parameter(description = "The new service port number of K8S/OpenShift service", required = true)int v2_svc_port,
			@Parameter(description = "Canary Cookie key", required = true) String key,
			@Parameter(description = "Canary Cookie value", required = true) String c_value) throws IOException {
		
		String tml_full = "http-canary-cookie.tml";
		
		if(expected != null && expected.length() > 0 && path != null && path.length() > 0) {
			tml_full = "http-canary-cookie-with-custom-monitor.tml";
		}
	
		return generate(cluster, namespace, service, port, ip, vsPort, path, expected, v2_svc_cluster, v2_svc_namespace, v2_svc_service, v2_svc_port, null, null, null, key, c_value, null, null, -1, "header.tml", tml_full, "footer.tml");
	}
	
	@RequestMapping(path = {"/generate/httpCanarySourceAddr"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS HTTP Service Configmap", description = "Returns F5 CIS HTTP Service Configmap")
	public String generateHTTPCanarySourceAddr(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort,
			@Parameter(description = "HTTP Health Monitor Path", required = true, allowEmptyValue = true)String path,
			@Parameter(description = "HTTP Health Monitor expected result", required = true, allowEmptyValue = true)String expected,
			@Parameter(description = "The new service name of K8S/OpenShift cluster", required = true) String v2_svc_cluster, 
			@Parameter(description = "The new service name of K8S/OpenShift namespace", required = true) String v2_svc_namespace, 
			@Parameter(description = "The new service name of K8S/OpenShift service", required = true)String v2_svc_service, 
			@Parameter(description = "The new service port number of K8S/OpenShift service", required = true)int v2_svc_port,
			@Parameter(description = "Canary Source Address", required = true) String sourceAddr,
			@Parameter(description = "Canary Source Address Network", required = true) String network) throws IOException {
		
		String tml_full = "http-canary-sourceaddr.tml";
		
		if(expected != null && expected.length() > 0 && path != null && path.length() > 0) {
			tml_full = "http-canary-sourceaddr-with-custom-monitor.tml";
		}
	
		return generate(cluster, namespace, service, port, ip, vsPort, path, expected, v2_svc_cluster, v2_svc_namespace, v2_svc_service, v2_svc_port, null, null, null, null, null, sourceAddr, network, -1, "header.tml", tml_full, "footer.tml");
	}
	
	@RequestMapping(path = {"/generate/httpCanaryRatio"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS HTTP Service Configmap", description = "Returns F5 CIS HTTP Service Configmap")
	public String generateHTTPCanaryRatio(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort,
			@Parameter(description = "HTTP Health Monitor Path", required = true, allowEmptyValue = true)String path,
			@Parameter(description = "HTTP Health Monitor expected result", required = true, allowEmptyValue = true)String expected,
			@Parameter(description = "The new service name of K8S/OpenShift cluster", required = true) String v2_svc_cluster, 
			@Parameter(description = "The new service name of K8S/OpenShift namespace", required = true) String v2_svc_namespace, 
			@Parameter(description = "The new service name of K8S/OpenShift service", required = true)String v2_svc_service, 
			@Parameter(description = "The new service port number of K8S/OpenShift service", required = true)int v2_svc_port,
			@Parameter(description = "Canary Ratio", required = true) int ratio) throws IOException {
		
		String tml_full = "http-canary-ratio.tml";
		
		if(expected != null && expected.length() > 0 && path != null && path.length() > 0) {
			tml_full = "http-canary-ratio-with-custom-monitor.tml";
		}
	
		return generate(cluster, namespace, service, port, ip, vsPort, path, expected, v2_svc_cluster, v2_svc_namespace, v2_svc_service, v2_svc_port, null, null, null, null, null, null, null, ratio, "header.tml", tml_full, "footer.tml");
	}
	
	@RequestMapping(path = {"/generate/tcpCanarySourceAddr"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS TCP Service Configmap", description = "Returns F5 CIS TCP Service Configmap")
	public String generateTCPCanarySourceAddr(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort,
			@Parameter(description = "The new service name of K8S/OpenShift cluster", required = true) String v2_svc_cluster, 
			@Parameter(description = "The new service name of K8S/OpenShift namespace", required = true) String v2_svc_namespace, 
			@Parameter(description = "The new service name of K8S/OpenShift service", required = true)String v2_svc_service, 
			@Parameter(description = "The new service port number of K8S/OpenShift service", required = true)int v2_svc_port,
			@Parameter(description = "Canary Source Address", required = true) String sourceAddr,
			@Parameter(description = "Canary Source Address Network", required = true) String network) throws IOException {

		return generate(cluster, namespace, service, port, ip, vsPort, null, null, v2_svc_cluster, v2_svc_namespace, v2_svc_service, v2_svc_port, null, null, null, null, null, sourceAddr, network, -1, "header.tml", "tcp-canary-sourceaddr.tml", "footer.tml");
	}
	
	@RequestMapping(path = {"/generate/tcpCanaryRatio"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS TCP Service Configmap", description = "Returns F5 CIS TCP Service Configmap")
	public String generateTCPCanaryRatio(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort,
			@Parameter(description = "The new service name of K8S/OpenShift cluster", required = true) String v2_svc_cluster, 
			@Parameter(description = "The new service name of K8S/OpenShift namespace", required = true) String v2_svc_namespace, 
			@Parameter(description = "The new service name of K8S/OpenShift service", required = true)String v2_svc_service, 
			@Parameter(description = "The new service port number of K8S/OpenShift service", required = true)int v2_svc_port,
			@Parameter(description = "Canary Ratio", required = true) int ratio) throws IOException {

		return generate(cluster, namespace, service, port, ip, vsPort, null, null, v2_svc_cluster, v2_svc_namespace, v2_svc_service, v2_svc_port, null, null, null, null, null, null, null, ratio, "header.tml", "tcp-canary-ratio.tml", "footer.tml");
	}

}
