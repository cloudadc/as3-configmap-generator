
package io.github.cloudadc.as3.pojo;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "class"
})
@Generated("jsonschema2pojo")
public class ApplicationProperty {

    @JsonProperty("class")
    private ApplicationProperty.Class _class;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("class")
    public ApplicationProperty.Class getClass_() {
        return _class;
    }

    @JsonProperty("class")
    public void setClass_(ApplicationProperty.Class _class) {
        this._class = _class;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ApplicationProperty.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("_class");
        sb.append('=');
        sb.append(((this._class == null)?"<null>":this._class));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this._class == null)? 0 :this._class.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ApplicationProperty) == false) {
            return false;
        }
        ApplicationProperty rhs = ((ApplicationProperty) other);
        return (((this._class == rhs._class)||((this._class!= null)&&this._class.equals(rhs._class)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

    @Generated("jsonschema2pojo")
    public enum Class {

        SERVICE_HTTP("Service_HTTP"),
        SERVICE_HTTPS("Service_HTTPS"),
        SERVICE_TCP("Service_TCP"),
        SERVICE_UDP("Service_UDP"),
        SERVICE_SCTP("Service_SCTP"),
        SERVICE_L_4("Service_L4"),
        SERVICE_GENERIC("Service_Generic"),
        SERVICE_FORWARDING("Service_Forwarding"),
        SERVICE_ADDRESS("Service_Address"),
        SNAT_POOL("SNAT_Pool"),
        I_RULE("iRule"),
        WAF_POLICY("WAF_Policy"),
        PERSIST("Persist"),
        POOL("Pool"),
        MONITOR("Monitor"),
        TLS_SERVER("TLS_Server"),
        TLS_CLIENT("TLS_Client"),
        CERTIFICATE("Certificate"),
        CA_BUNDLE("CA_Bundle"),
        CERTIFICATE_VALIDATOR_OCSP("Certificate_Validator_OCSP"),
        FIX_PROFILE("FIX_Profile"),
        SIP_PROFILE("SIP_Profile"),
        ANALYTICS_PROFILE("Analytics_Profile"),
        ANALYTICS_TCP_PROFILE("Analytics_TCP_Profile"),
        FTP_PROFILE("FTP_Profile"),
        HTTP_PROFILE("HTTP_Profile"),
        HTTP_COMPRESS("HTTP_Compress"),
        HTTP_2_PROFILE("HTTP2_Profile"),
        MULTIPLEX_PROFILE("Multiplex_Profile"),
        TCP_PROFILE("TCP_Profile"),
        UDP_PROFILE("UDP_Profile"),
        L_4_PROFILE("L4_Profile"),
        CLASSIFICATION_PROFILE("Classification_Profile"),
        RADIUS_PROFILE("Radius_Profile"),
        IP_OTHER_PROFILE("IP_Other_Profile"),
        REWRITE_PROFILE("Rewrite_Profile"),
        HTTP_ACCELERATION_PROFILE("HTTP_Acceleration_Profile"),
        STREAM_PROFILE("Stream_Profile"),
        ACCESS_PROFILE("Access_Profile"),
        ICAP_PROFILE("ICAP_Profile"),
        ADAPT_PROFILE("Adapt_Profile"),
        CIPHER_RULE("Cipher_Rule"),
        CIPHER_GROUP("Cipher_Group"),
        FIREWALL_ADDRESS_LIST("Firewall_Address_List"),
        FIREWALL_PORT_LIST("Firewall_Port_List"),
        FIREWALL_RULE_LIST("Firewall_Rule_List"),
        FIREWALL_POLICY("Firewall_Policy"),
        NAT_POLICY("NAT_Policy"),
        NAT_SOURCE_TRANSLATION("NAT_Source_Translation"),
        PROTOCOL_INSPECTION_PROFILE("Protocol_Inspection_Profile"),
        SSH_PROXY_PROFILE("SSH_Proxy_Profile"),
        DATA_GROUP("Data_Group"),
        DNS_CACHE("DNS_Cache"),
        DNS_PROFILE("DNS_Profile"),
        DNS_TSIG_KEY("DNS_TSIG_Key"),
        DNS_ZONE("DNS_Zone"),
        DNS_NAMESERVER("DNS_Nameserver"),
        DOS_PROFILE("DOS_Profile"),
        GSLB_DOMAIN("GSLB_Domain"),
        GSLB_MONITOR("GSLB_Monitor"),
        GSLB_POOL("GSLB_Pool"),
        GSLB_SERVER("GSLB_Server"),
        GSLB_DATA_CENTER("GSLB_Data_Center"),
        GSLB_PROBER_POOL("GSLB_Prober_Pool"),
        GSLB_TOPOLOGY_RECORDS("GSLB_Topology_Records"),
        GSLB_TOPOLOGY_REGION("GSLB_Topology_Region"),
        SECURITY_LOG_PROFILE("Security_Log_Profile"),
        LOG_PUBLISHER("Log_Publisher"),
        LOG_DESTINATION("Log_Destination"),
        TRAFFIC_LOG_PROFILE("Traffic_Log_Profile"),
        ENDPOINT_POLICY("Endpoint_Policy"),
        ENDPOINT_STRATEGY("Endpoint_Strategy"),
        BANDWIDTH_CONTROL_POLICY("Bandwidth_Control_Policy"),
        ENFORCEMENT_POLICY("Enforcement_Policy"),
        ENFORCEMENT_DIAMETER_ENDPOINT_PROFILE("Enforcement_Diameter_Endpoint_Profile"),
        ENFORCEMENT_I_RULE("Enforcement_iRule"),
        ENFORCEMENT_RADIUS_AAA_PROFILE("Enforcement_Radius_AAA_Profile"),
        ENFORCEMENT_PROFILE("Enforcement_Profile"),
        ENFORCEMENT_SUBSCRIBER_MANAGEMENT_PROFILE("Enforcement_Subscriber_Management_Profile"),
        ENFORCEMENT_LISTENER("Enforcement_Listener"),
        ENFORCEMENT_INTERCEPTION_ENDPOINT("Enforcement_Interception_Endpoint"),
        ENFORCEMENT_FORMAT_SCRIPT("Enforcement_Format_Script"),
        ENFORCEMENT_FORWARDING_ENDPOINT("Enforcement_Forwarding_Endpoint"),
        ENFORCEMENT_SERVICE_CHAIN_ENDPOINT("Enforcement_Service_Chain_Endpoint");
        private final String value;
        private final static Map<String, ApplicationProperty.Class> CONSTANTS = new HashMap<String, ApplicationProperty.Class>();

        static {
            for (ApplicationProperty.Class c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Class(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static ApplicationProperty.Class fromValue(String value) {
            ApplicationProperty.Class constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
