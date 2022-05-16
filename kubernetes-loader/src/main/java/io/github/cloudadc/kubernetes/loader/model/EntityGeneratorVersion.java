package io.github.cloudadc.kubernetes.loader.model;

public class EntityGeneratorVersion {
	
	private String as3Version;
	
	private String cisVersion;
	
	private String version;

	public EntityGeneratorVersion(String version) {
		this.version = version;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getAs3Version() {
		return as3Version;
	}

	public void setAs3Version(String as3Version) {
		this.as3Version = as3Version;
	}

	public String getCisVersion() {
		return cisVersion;
	}

	public void setCisVersion(String cisVersion) {
		this.cisVersion = cisVersion;
	}
}
