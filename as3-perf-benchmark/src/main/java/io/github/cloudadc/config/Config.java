package io.github.cloudadc.config;

public class Config {
	
	private String[] addresses;
	
	private String[] memberAddresses;
	
	private Integer cursor = Integer.valueOf(0);
	
	private Integer memberCursor = Integer.valueOf(0);
	
	private String subnet;
	
	private String memberSubnet;
	
	private Mode mode;
	
	private String as3Version;
	
	private Integer appCount;
	
	private Integer appPerNamespace;
	
	private String appImage;
	
	private Integer appImageContainerPort;
	
	private String namespacePrefix;
	
	private String deployFile;
	
	private String configmapFile;
	
	public Config() {
		super();
	}

	public Config(String subnet, String memberSubnet, Mode mode, String as3Version, Integer appCount, Integer appPerNamespace,
	        String appImage, Integer appImageContainerPort, String namespacePrefix, String deployFile, String configmapFile) {
		super();
		this.subnet = subnet;
		this.memberSubnet = memberSubnet;
		this.mode = mode;
		this.as3Version = as3Version;
		this.appCount = appCount;
		this.appPerNamespace = appPerNamespace;
		this.appImage = appImage;
		this.appImageContainerPort = appImageContainerPort;
		this.namespacePrefix = namespacePrefix;
		this.deployFile = deployFile;
		this.configmapFile = configmapFile;
	}

	public String getSubnet() {
		return subnet;
	}

	public void setSubnet(String subnet) {
		this.subnet = subnet;
	}

	public String getMemberSubnet() {
		return memberSubnet;
	}

	public void setMemberSubnet(String memberSubnet) {
		this.memberSubnet = memberSubnet;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
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
	
	public String[] getMemberAddresses() {
		return memberAddresses;
	}

	public void setMemberAddresses(String[] memberAddresses) {
		this.memberAddresses = memberAddresses;
	}
	
	public String memberIp() {
		return memberAddresses[memberCursor++];
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

	public String getDeployFile() {
		return deployFile;
	}

	public void setDeployFile(String deployFile) {
		this.deployFile = deployFile;
	}

	public String getConfigmapFile() {
		return configmapFile;
	}

	public void setConfigmapFile(String configmapFile) {
		this.configmapFile = configmapFile;
	}

}
