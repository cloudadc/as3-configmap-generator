
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
 * Shared Application
 * <p>
 * Special application Shared holds objects other applications can share
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "class",
    "template",
    "enable"
})
@Generated("jsonschema2pojo")
public class ApplicationShared {

    /**
     * Class
     * <p>
     * 
     * (Required)
     * 
     */
    @JsonProperty("class")
    private String _class;
    /**
     * Template Name
     * <p>
     * Shared Application template is always generic
     * (Required)
     * 
     */
    @JsonProperty("template")
    @JsonPropertyDescription("Shared Application template is always generic")
    private String template;
    /**
     * Enable
     * <p>
     * If declared, you must enable the Shared Application
     * 
     */
    @JsonProperty("enable")
    @JsonPropertyDescription("If declared, you must enable the Shared Application")
    private Boolean enable = true;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Class
     * <p>
     * 
     * (Required)
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
     * (Required)
     * 
     */
    @JsonProperty("class")
    public void setClass_(String _class) {
        this._class = _class;
    }

    /**
     * Template Name
     * <p>
     * Shared Application template is always generic
     * (Required)
     * 
     */
    @JsonProperty("template")
    public String getTemplate() {
        return template;
    }

    /**
     * Template Name
     * <p>
     * Shared Application template is always generic
     * (Required)
     * 
     */
    @JsonProperty("template")
    public void setTemplate(String template) {
        this.template = template;
    }

    /**
     * Enable
     * <p>
     * If declared, you must enable the Shared Application
     * 
     */
    @JsonProperty("enable")
    public Boolean getEnable() {
        return enable;
    }

    /**
     * Enable
     * <p>
     * If declared, you must enable the Shared Application
     * 
     */
    @JsonProperty("enable")
    public void setEnable(Boolean enable) {
        this.enable = enable;
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
        sb.append(ApplicationShared.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("_class");
        sb.append('=');
        sb.append(((this._class == null)?"<null>":this._class));
        sb.append(',');
        sb.append("template");
        sb.append('=');
        sb.append(((this.template == null)?"<null>":this.template));
        sb.append(',');
        sb.append("enable");
        sb.append('=');
        sb.append(((this.enable == null)?"<null>":this.enable));
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
        result = ((result* 31)+((this.template == null)? 0 :this.template.hashCode()));
        result = ((result* 31)+((this._class == null)? 0 :this._class.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.enable == null)? 0 :this.enable.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ApplicationShared) == false) {
            return false;
        }
        ApplicationShared rhs = ((ApplicationShared) other);
        return (((((this.template == rhs.template)||((this.template!= null)&&this.template.equals(rhs.template)))&&((this._class == rhs._class)||((this._class!= null)&&this._class.equals(rhs._class))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.enable == rhs.enable)||((this.enable!= null)&&this.enable.equals(rhs.enable))));
    }

}
