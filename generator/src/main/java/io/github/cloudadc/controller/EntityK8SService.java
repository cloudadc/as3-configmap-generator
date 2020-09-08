package io.github.cloudadc.controller;

public class EntityK8SService {
	
	private String clusterName;
	
	private String namespaceName;
	
	private String serviceName;
	
	private int servicePort;

	public EntityK8SService(String clusterName, String namespaceName, String serviceName, int servicePort) {
		super();
		this.clusterName = clusterName;
		this.namespaceName = namespaceName;
		this.serviceName = serviceName;
		this.servicePort = servicePort;
	}

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public String getNamespaceName() {
		return namespaceName;
	}

	public void setNamespaceName(String namespaceName) {
		this.namespaceName = namespaceName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getServicePort() {
		return servicePort;
	}

	public void setServicePort(int servicePort) {
		this.servicePort = servicePort;
	}

}
