package io.github.cloudadc.generator;

public interface Generator {
	
	public static final String REPLACEMENT_AS3_VERSION = "REPLACEMENT_AS3_VERSION";
	
	public static final String REPLACEMENT_AS3_ID = "REPLACEMENT_AS3_ID";
	
	public static final String REPLACEMENT_AS3_TENANT = "REPLACEMENT_AS3_TENANT";
	
	public static final String REPLACEMENT_AS3_APPLICATIONS = "REPLACEMENT_AS3_APPLICATIONS";
	
	public static final String REPLACEMENT_AS3_APP = "REPLACEMENT_AS3_APP";
	
	public static final String REPLACEMENT_AS3_VS_IP = "REPLACEMENT_AS3_VS_IP";
	
	public static final String REPLACEMENT_AS3_MEMBER_IP = "REPLACEMENT_AS3_MEMBER_IP";
	
	public static final String REPLACEMENT_CM_AS_VERSION = "REPLACEMENT_CM_AS_VERSION";
	
	public static final String REPLACEMENT_NAMESPACE = "REPLACEMENT_NAMESPACE";
	
	public static final String REPLACEMENT_ZONE = "REPLACEMENT_ZONE";
	
	public static final String REPLACEMENT_APP_NAME = "REPLACEMENT_APP_NAME";
	
	public static final String REPLACEMENT_BACKEND_IMAGE = "REPLACEMENT_BACKEND_IMAGE";
	
	public static final String REPLACEMENT_BACKEND_PORT = "REPLACEMENT_BACKEND_PORT";
	
	public static final String REPLACEMENT_SERVICE_NAME = "REPLACEMENT_SERVICE_NAME";
	
	public static final String REPLACEMENT_APP_VS_IP = "REPLACEMENT_APP_VS_IP";
	
	public static final String TD = "TD";
	
	public String deployment();
	
	public String configmap();
	
	public String ingress();
	
	public String as3();

}
