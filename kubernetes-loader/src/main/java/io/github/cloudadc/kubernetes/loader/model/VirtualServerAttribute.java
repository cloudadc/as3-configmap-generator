package io.github.cloudadc.kubernetes.loader.model;

public class VirtualServerAttribute extends ServiceAttribute {

	private static final long serialVersionUID = -8564226765002567248L;
	
	private String ip;
	
	private Integer vsPort;
	
	private Boolean isHubMode;
	
	private String hubNamespace;
	
	private String hubConfigmap;

	public VirtualServerAttribute() {
		super();
	}

	public VirtualServerAttribute(String cluster, String namespace, String service, Integer port, String ip, Integer vsPort, Boolean isHubMode, String hubNamespace, String hubConfigmap) {
		super(cluster, namespace, service, port);
		this.ip = ip;
		this.vsPort = vsPort; 
		this.isHubMode = isHubMode;
		this.hubNamespace = hubNamespace;
		this.hubConfigmap = hubConfigmap;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getVsPort() {
		return vsPort;
	}

	public void setVsPort(Integer vsPort) {
		this.vsPort = vsPort;
	}

	public Boolean getIsHubMode() {
		return isHubMode;
	}

	public void setIsHubMode(Boolean isHubMode) {
		this.isHubMode = isHubMode;
	}

	public String getHubNamespace() {
		return hubNamespace;
	}

	public void setHubNamespace(String hubNamespace) {
		this.hubNamespace = hubNamespace;
	}

	public String getHubConfigmap() {
		return hubConfigmap;
	}

	public void setHubConfigmap(String hubConfigmap) {
		this.hubConfigmap = hubConfigmap;
	}

}
