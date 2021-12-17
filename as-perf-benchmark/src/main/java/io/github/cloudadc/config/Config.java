package io.github.cloudadc.config;

public class Config {
	
	private String[] addresses;
	
	private Integer cursor = Integer.valueOf(0);
	
	private String subnet;
	
	private CISMode cisMode;
	
	private String as3Version;
	
	private Integer appCount;
	
	private Integer appPerNamespace;
	
	private String appImage;
	
	private Integer appImageContainerPort;
	
	private String namespacePrefix;
	
	public Config() {
		super();
	}

	public Config(String subnet, CISMode cisMode, String as3Version, Integer appCount, Integer appPerNamespace,
	        String appImage, Integer appImageContainerPort, String namespacePrefix) {
		super();
		this.subnet = subnet;
		this.cisMode = cisMode;
		this.as3Version = as3Version;
		this.appCount = appCount;
		this.appPerNamespace = appPerNamespace;
		this.appImage = appImage;
		this.appImageContainerPort = appImageContainerPort;
		this.namespacePrefix = namespacePrefix;
	}

	public String getSubnet() {
		return subnet;
	}

	public void setSubnet(String subnet) {
		this.subnet = subnet;
	}

	public CISMode getCisMode() {
		return cisMode;
	}

	public void setCisMode(CISMode cisMode) {
		this.cisMode = cisMode;
	}

	public String getAs3Version() {
		return as3Version;
	}

	public void setAs3Version(String as3Version) {
		this.as3Version = as3Version;
	}

	public Integer getAppCount() {
		return appCount;
	}

	public void setAppCount(Integer appCount) {
		this.appCount = appCount;
	}

	public String getAppImage() {
		return appImage;
	}

	public void setAppImage(String appImage) {
		this.appImage = appImage;
	}

	public Integer getAppImageContainerPort() {
		return appImageContainerPort;
	}

	public void setAppImageContainerPort(Integer appImageContainerPort) {
		this.appImageContainerPort = appImageContainerPort;
	}

	public Integer getAppPerNamespace() {
		return appPerNamespace;
	}

	public void setAppPerNamespace(Integer appPerNamespace) {
		this.appPerNamespace = appPerNamespace;
	}

	public String[] getAddresses() {
		return addresses;
	}

	public void setAddresses(String[] addresses) {
		this.addresses = addresses;
	}
	
	public String ip() {
		return addresses[cursor++];
	}
	
	public Integer cursor() {
		return this.cursor;
	}
	
	public void resetCursor() {
		this.cursor = Integer.valueOf(0);
	}

	public String getNamespacePrefix() {
		return namespacePrefix;
	}

	public void setNamespacePrefix(String namespacePrefix) {
		this.namespacePrefix = namespacePrefix;
	}

}
