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
 * @author ksong
 *
 */
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
			@Parameter(description = "Skip Create F5 VS", required = true)boolean isPoolonly) throws IOException {

		if(isPoolonly) {
			return generate(cluster, namespace, service, port, ip, vsPort, null, null, null, null, null, -1, null, null, null, null, null, null, null, -1, "header.tml", "no-vs-http.tml", "footer.tml");
		}
		
		return generate(cluster, namespace, service, port, ip, vsPort, null, null, null, null, null, -1, null, null, null, null, null, null, null, -1, "header.tml", "http.tml", "footer.tml");
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
			@Parameter(description = "Skip Create F5 VS", required = true)boolean isPoolonly) throws IOException {
		
		if(isPoolonly) {
			return generate(cluster, namespace, service, port, ip, vsPort, path, expected, null, null, null, -1, null, null, null, null, null, null, null, -1, "header.tml", "no-vs-http-with-custom-monitor.tml", "footer.tml");
		}
		
		return generate(cluster, namespace, service, port, ip, vsPort, path, expected, null, null, null, -1, null, null, null, null, null, null, null, -1, "header.tml", "http-with-custom-monitor.tml", "footer.tml");
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
			@Parameter(description = "Skip Create F5 VS", required = true)boolean isPoolonly) throws IOException {
		
		if(isPoolonly) {
			return generate(cluster, namespace, service, port, ip, vsPort, null, null, null, null, null, -1, null, null, null, null, null, null, null, -1, "header.tml", "no-vs-tcp.tml", "footer.tml");
		} 
		
		return generate(cluster, namespace, service, port, ip, vsPort, null, null, null, null, null, -1, null, null, null, null, null, null, null, -1, "header.tml", "tcp.tml", "footer.tml");
	}
	
	@RequestMapping(path = {"/generate/httpCanaryURL"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS HTTP Service Configmap", description = "Returns F5 CIS HTTP Service Configmap")
	public String generateHTTPCanaryURL(
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
			@Parameter(description = "Canary URL", required = true) String canaryPath) throws IOException {

		return generate(cluster, namespace, service, port, ip, vsPort, null, null, v2_svc_cluster, v2_svc_namespace, v2_svc_service, v2_svc_port, canaryPath, null, null, null, null, null, null, -1, "header.tml", "http-canary-url.tml", "footer.tml");
	}
	
	@RequestMapping(path = {"/generate/httpCustomMonitorCanaryURL"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS HTTP Service Configmap with custom health check", description = "Returns F5 CIS HTTP Service Configmap")
	public String generateHTTPCustomMonitorCanaryURL(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort,
			@Parameter(description = "HTTP Health Monitor Path", required = true)String path,
			@Parameter(description = "HTTP Health Monitor expected result", required = true)String expected,
			@Parameter(description = "The new service name of K8S/OpenShift cluster", required = true) String v2_svc_cluster, 
			@Parameter(description = "The new service name of K8S/OpenShift namespace", required = true) String v2_svc_namespace, 
			@Parameter(description = "The new service name of K8S/OpenShift service", required = true)String v2_svc_service, 
			@Parameter(description = "The new service port number of K8S/OpenShift service", required = true)int v2_svc_port,
			@Parameter(description = "Canary URL", required = true) String canaryPath) throws IOException {
	
		return generate(cluster, namespace, service, port, ip, vsPort, path, expected, v2_svc_cluster, v2_svc_namespace, v2_svc_service, v2_svc_port, canaryPath, null, null, null, null, null, null, -1, "header.tml", "http-canary-url-with-custom-monitor.tml", "footer.tml");
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
			@Parameter(description = "The new service name of K8S/OpenShift cluster", required = true) String v2_svc_cluster, 
			@Parameter(description = "The new service name of K8S/OpenShift namespace", required = true) String v2_svc_namespace, 
			@Parameter(description = "The new service name of K8S/OpenShift service", required = true)String v2_svc_service, 
			@Parameter(description = "The new service port number of K8S/OpenShift service", required = true)int v2_svc_port,
			@Parameter(description = "Canary Http Header", required = true) String header,
			@Parameter(description = "Canary Http Header Value", required = true) String value) throws IOException {

		return generate(cluster, namespace, service, port, ip, vsPort, null, null, v2_svc_cluster, v2_svc_namespace, v2_svc_service, v2_svc_port, null, header, value, null, null, null, null, -1, "header.tml", "http-canary-header.tml", "footer.tml");
	}
	
	@RequestMapping(path = {"/generate/httpCustomMonitorCanaryHeader"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS HTTP Service Configmap with custom health check", description = "Returns F5 CIS HTTP Service Configmap")
	public String generateHTTPCustomMonitorCanaryHeader(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort,
			@Parameter(description = "HTTP Health Monitor Path", required = true)String path,
			@Parameter(description = "HTTP Health Monitor expected result", required = true)String expected,
			@Parameter(description = "The new service name of K8S/OpenShift cluster", required = true) String v2_svc_cluster, 
			@Parameter(description = "The new service name of K8S/OpenShift namespace", required = true) String v2_svc_namespace, 
			@Parameter(description = "The new service name of K8S/OpenShift service", required = true)String v2_svc_service, 
			@Parameter(description = "The new service port number of K8S/OpenShift service", required = true)int v2_svc_port,
			@Parameter(description = "Canary Http Header", required = true) String header,
			@Parameter(description = "Canary Http Header Value", required = true) String value) throws IOException {
	
		return generate(cluster, namespace, service, port, ip, vsPort, path, expected, v2_svc_cluster, v2_svc_namespace, v2_svc_service, v2_svc_port, null, header, value, null, null, null, null, -1, "header.tml", "http-canary-header-with-custom-monitor.tml", "footer.tml");
	}
	
	@RequestMapping(path = {"/generate/httpCanaryCookie"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS HTTP Service Configmap", description = "Returns F5 CIS HTTP Service Configmap")
	public String generateHTTPCanaryCookie(
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
			@Parameter(description = "Canary Cookie key", required = true) String key,
			@Parameter(description = "Canary Cookie value", required = true) String c_value) throws IOException {

		return generate(cluster, namespace, service, port, ip, vsPort, null, null, v2_svc_cluster, v2_svc_namespace, v2_svc_service, v2_svc_port, null, null, null, key, c_value, null, null, -1, "header.tml", "http-canary-cookie.tml", "footer.tml");
	}
	
	@RequestMapping(path = {"/generate/httpCustomMonitorCanaryCookie"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS HTTP Service Configmap with custom health check", description = "Returns F5 CIS HTTP Service Configmap")
	public String generateHTTPCustomMonitorCanaryCookie(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort,
			@Parameter(description = "HTTP Health Monitor Path", required = true)String path,
			@Parameter(description = "HTTP Health Monitor expected result", required = true)String expected,
			@Parameter(description = "The new service name of K8S/OpenShift cluster", required = true) String v2_svc_cluster, 
			@Parameter(description = "The new service name of K8S/OpenShift namespace", required = true) String v2_svc_namespace, 
			@Parameter(description = "The new service name of K8S/OpenShift service", required = true)String v2_svc_service, 
			@Parameter(description = "The new service port number of K8S/OpenShift service", required = true)int v2_svc_port,
			@Parameter(description = "Canary Cookie key", required = true) String key,
			@Parameter(description = "Canary Cookie value", required = true) String c_value) throws IOException {
	
		return generate(cluster, namespace, service, port, ip, vsPort, path, expected, v2_svc_cluster, v2_svc_namespace, v2_svc_service, v2_svc_port, null, null, null, key, c_value, null, null, -1, "header.tml", "http-canary-cookie-with-custom-monitor.tml", "footer.tml");
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
			@Parameter(description = "The new service name of K8S/OpenShift cluster", required = true) String v2_svc_cluster, 
			@Parameter(description = "The new service name of K8S/OpenShift namespace", required = true) String v2_svc_namespace, 
			@Parameter(description = "The new service name of K8S/OpenShift service", required = true)String v2_svc_service, 
			@Parameter(description = "The new service port number of K8S/OpenShift service", required = true)int v2_svc_port,
			@Parameter(description = "Canary Source Address", required = true) String sourceAddr,
			@Parameter(description = "Canary Source Address Network", required = true) String network) throws IOException {

		return generate(cluster, namespace, service, port, ip, vsPort, null, null, v2_svc_cluster, v2_svc_namespace, v2_svc_service, v2_svc_port, null, null, null, null, null, sourceAddr, network, -1, "header.tml", "http-canary-sourceaddr.tml", "footer.tml");
	}
	
	@RequestMapping(path = {"/generate/httpCustomMonitorCanarySourceAddr"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS HTTP Service Configmap with custom health check", description = "Returns F5 CIS HTTP Service Configmap")
	public String generateHTTPCustomMonitorCanarySourceAddr(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort,
			@Parameter(description = "HTTP Health Monitor Path", required = true)String path,
			@Parameter(description = "HTTP Health Monitor expected result", required = true)String expected,
			@Parameter(description = "The new service name of K8S/OpenShift cluster", required = true) String v2_svc_cluster, 
			@Parameter(description = "The new service name of K8S/OpenShift namespace", required = true) String v2_svc_namespace, 
			@Parameter(description = "The new service name of K8S/OpenShift service", required = true)String v2_svc_service, 
			@Parameter(description = "The new service port number of K8S/OpenShift service", required = true)int v2_svc_port,
			@Parameter(description = "Canary Source Address", required = true) String sourceAddr,
			@Parameter(description = "Canary Source Address Network", required = true) String network) throws IOException {
	
		return generate(cluster, namespace, service, port, ip, vsPort, path, expected, v2_svc_cluster, v2_svc_namespace, v2_svc_service, v2_svc_port, null, null, null, null, null, sourceAddr, network, -1, "header.tml", "http-canary-sourceaddr-with-custom-monitor.tml", "footer.tml");
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
	
	@RequestMapping(path = {"/generate/httpCanaryRatio"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS HTTP Service Configmap", description = "Returns F5 CIS HTTP Service Configmap")
	public String generateHTTPCanaryRatio(
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

		return generate(cluster, namespace, service, port, ip, vsPort, null, null, v2_svc_cluster, v2_svc_namespace, v2_svc_service, v2_svc_port, null, null, null, null, null, null, null, ratio, "header.tml", "http-canary-ratio.tml", "footer.tml");
	}
	
	@RequestMapping(path = {"/generate/httpCustomMonitorCanaryRatio"}, method = {RequestMethod.GET})
	@Operation(summary = "Generate F5 CIS HTTP Service Configmap with custom health check", description = "Returns F5 CIS HTTP Service Configmap")
	public String generateHTTPCustomMonitorCanaryRatio(
			@Parameter(description = "The name of K8S/OpenShift cluster", required = true) String cluster, 
			@Parameter(description = "The name of K8S/OpenShift namespace", required = true) String namespace, 
			@Parameter(description = "The name of K8S/OpenShift service", required = true)String service, 
			@Parameter(description = "The port number of K8S/OpenShift service", required = true)int port,
			@Parameter(description = "F5 Virtual Server IP", required = true)String ip,
			@Parameter(description = "F5 Virtual Server Port", required = true)int vsPort,
			@Parameter(description = "HTTP Health Monitor Path", required = true)String path,
			@Parameter(description = "HTTP Health Monitor expected result", required = true)String expected,
			@Parameter(description = "The new service name of K8S/OpenShift cluster", required = true) String v2_svc_cluster, 
			@Parameter(description = "The new service name of K8S/OpenShift namespace", required = true) String v2_svc_namespace, 
			@Parameter(description = "The new service name of K8S/OpenShift service", required = true)String v2_svc_service, 
			@Parameter(description = "The new service port number of K8S/OpenShift service", required = true)int v2_svc_port,
			@Parameter(description = "Canary Ratio", required = true) int ratio) throws IOException {
	
		return generate(cluster, namespace, service, port, ip, vsPort, path, expected, v2_svc_cluster, v2_svc_namespace, v2_svc_service, v2_svc_port, null, null, null, null, null, null, null, ratio, "header.tml", "http-canary-ratio-with-custom-monitor.tml", "footer.tml");
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