package io.github.cloudadc.config;

public enum ASSchemaVersion {

	V_3_18_0("3.18.0"),
	
	V_3_19_0("3.19.0"),
	
    V_3_20_0("3.20.0"),
	
	V_3_21_0("3.21.0"),
	
    V_3_22_0("3.22.0"),
	
	V_3_23_0("3.23.0"),
	
    V_3_24_0("3.24.0"),
	
	V_3_25_0("3.25.0");
	
	String version;
	
	ASSchemaVersion(String version) {
		this.version = version;
	}
	
	public String value() {
		return this.version;
	}
}
