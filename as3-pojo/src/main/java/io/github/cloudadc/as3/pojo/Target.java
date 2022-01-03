
package io.github.cloudadc.as3.pojo;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Target Device
 * <p>
 * Trusted BIG-IP or SSG target for config when configuring with BIG-IQ
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "hostname",
    "address",
    "ssgName"
})
@Generated("jsonschema2pojo")
public class Target {

    /**
     * Host Name
     * <p>
     * Host name of managed device to be configured
     * 
     */
    @JsonProperty("hostname")
    @JsonPropertyDescription("Host name of managed device to be configured")
    private String hostname;
    /**
     * IP Address
     * <p>
     * IP address of managed device to be configured
     * 
     */
    @JsonProperty("address")
    @JsonPropertyDescription("IP address of managed device to be configured")
    private String address;
    /**
     * SSG Name
     * <p>
     * Name of shared service group to be configured
     * 
     */
    @JsonProperty("ssgName")
    @JsonPropertyDescription("Name of shared service group to be configured")
    private String ssgName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Host Name
     * <p>
     * Host name of managed device to be configured
     * 
     */
    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    /**
     * Host Name
     * <p>
     * Host name of managed device to be configured
     * 
     */
    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * IP Address
     * <p>
     * IP address of managed device to be configured
     * 
     */
    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    /**
     * IP Address
     * <p>
     * IP address of managed device to be configured
     * 
     */
    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * SSG Name
     * <p>
     * Name of shared service group to be configured
     * 
     */
    @JsonProperty("ssgName")
    public String getSsgName() {
        return ssgName;
    }

    /**
     * SSG Name
     * <p>
     * Name of shared service group to be configured
     * 
     */
    @JsonProperty("ssgName")
    public void setSsgName(String ssgName) {
        this.ssgName = ssgName;
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
        sb.append(Target.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("hostname");
        sb.append('=');
        sb.append(((this.hostname == null)?"<null>":this.hostname));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        sb.append("ssgName");
        sb.append('=');
        sb.append(((this.ssgName == null)?"<null>":this.ssgName));
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
        result = ((result* 31)+((this.ssgName == null)? 0 :this.ssgName.hashCode()));
        result = ((result* 31)+((this.hostname == null)? 0 :this.hostname.hashCode()));
        result = ((result* 31)+((this.address == null)? 0 :this.address.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Target) == false) {
            return false;
        }
        Target rhs = ((Target) other);
        return (((((this.ssgName == rhs.ssgName)||((this.ssgName!= null)&&this.ssgName.equals(rhs.ssgName)))&&((this.hostname == rhs.hostname)||((this.hostname!= null)&&this.hostname.equals(rhs.hostname))))&&((this.address == rhs.address)||((this.address!= null)&&this.address.equals(rhs.address))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
