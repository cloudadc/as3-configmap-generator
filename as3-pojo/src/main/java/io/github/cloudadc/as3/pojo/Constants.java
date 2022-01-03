
package io.github.cloudadc.as3.pojo;

import java.util.Date;
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
 * Constants
 * <p>
 * Declaration metadata and/or named values for (re-)use by declaration objects
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "class",
    "version",
    "timestamp"
})
@Generated("jsonschema2pojo")
public class Constants {

    /**
     * Class
     * <p>
     * 
     * 
     */
    @JsonProperty("class")
    private String _class = "Constants";
    /**
     * Declaration version
     * <p>
     * Version number of declaration; update when you change contents but not ID (optional but recommended)
     * 
     */
    @JsonProperty("version")
    @JsonPropertyDescription("Version number of declaration; update when you change contents but not ID (optional but recommended)")
    private Double version;
    /**
     * Declaration timestamp
     * <p>
     * Date+time (this version of) declaration was created (optional but recommended)
     * 
     */
    @JsonProperty("timestamp")
    @JsonPropertyDescription("Date+time (this version of) declaration was created (optional but recommended)")
    private Date timestamp;
    @JsonIgnore
    private Map<String, Boolean> additionalProperties = new HashMap<String, Boolean>();

    /**
     * Class
     * <p>
     * 
     * 
     */
    @JsonProperty("class")
    public String getClass_() {
        return _class;
    }

    /**
     * Class
     * <p>
     * 
     * 
     */
    @JsonProperty("class")
    public void setClass_(String _class) {
        this._class = _class;
    }

    /**
     * Declaration version
     * <p>
     * Version number of declaration; update when you change contents but not ID (optional but recommended)
     * 
     */
    @JsonProperty("version")
    public Double getVersion() {
        return version;
    }

    /**
     * Declaration version
     * <p>
     * Version number of declaration; update when you change contents but not ID (optional but recommended)
     * 
     */
    @JsonProperty("version")
    public void setVersion(Double version) {
        this.version = version;
    }

    /**
     * Declaration timestamp
     * <p>
     * Date+time (this version of) declaration was created (optional but recommended)
     * 
     */
    @JsonProperty("timestamp")
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Declaration timestamp
     * <p>
     * Date+time (this version of) declaration was created (optional but recommended)
     * 
     */
    @JsonProperty("timestamp")
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @JsonAnyGetter
    public Map<String, Boolean> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Boolean value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("_class");
        sb.append('=');
        sb.append(((this._class == null)?"<null>":this._class));
        sb.append(',');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
        sb.append(',');
        sb.append("timestamp");
        sb.append('=');
        sb.append(((this.timestamp == null)?"<null>":this.timestamp));
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
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        result = ((result* 31)+((this.timestamp == null)? 0 :this.timestamp.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Constants) == false) {
            return false;
        }
        Constants rhs = ((Constants) other);
        return (((((this._class == rhs._class)||((this._class!= null)&&this._class.equals(rhs._class)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&((this.timestamp == rhs.timestamp)||((this.timestamp!= null)&&this.timestamp.equals(rhs.timestamp))));
    }

}
