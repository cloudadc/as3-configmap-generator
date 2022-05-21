package io.github.cloudadc.kubernetes.loader.model;

import java.io.Serializable;

public class ServiceAttribute implements Serializable {

	private static final long serialVersionUID = -3755155991679355470L;

	private String cluster;
	
	private String namespace;
	
	private String service;
	
	private Integer port;

	public ServiceAttribute() {
		super();
	}

	public ServiceAttribute(String cluster, String namespace, String service, Integer port) {
		super();
		this.cluster = cluster;
		this.namespace = namespace;
		this.service = service;
		this.port = port;
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "LabelAttribute [cluster=" + cluster + ", namespace=" + namespace + ", service=" + service + ", port="
		        + port + "]";
	}

}
