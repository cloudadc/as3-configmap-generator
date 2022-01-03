
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
 * Application
 * <p>
 * Application declaration master schema
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "class",
    "label",
    "remark",
    "template",
    "schemaOverlay",
    "enable",
    "constants",
    "serviceMain"
})
@Generated("jsonschema2pojo")
public class Application {

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
     * Label
     * <p>
     * Optional friendly name for this object
     * 
     */
    @JsonProperty("label")
    @JsonPropertyDescription("Optional friendly name for this object")
    private String label;
    /**
     * Remark
     * <p>
     * Arbitrary (brief) text pertaining to this object (optional)
     * 
     */
    @JsonProperty("remark")
    @JsonPropertyDescription("Arbitrary (brief) text pertaining to this object (optional)")
    private String remark;
    /**
     * Template Name
     * <p>
     * Each application type has certain required and default elements and selects appropriate setup of various ADC/Security features
     * (Required)
     * 
     */
    @JsonProperty("template")
    @JsonPropertyDescription("Each application type has certain required and default elements and selects appropriate setup of various ADC/Security features")
    private String template;
    /**
     * Schema Overlay
     * <p>
     * BIG-IQ name for a supplemental validation schema is applied to the Application class definition before the main AS3 schema
     * 
     */
    @JsonProperty("schemaOverlay")
    @JsonPropertyDescription("BIG-IQ name for a supplemental validation schema is applied to the Application class definition before the main AS3 schema")
    private String schemaOverlay;
    /**
     * Enable
     * <p>
     * Application handles traffic only when enabled (default)
     * 
     */
    @JsonProperty("enable")
    @JsonPropertyDescription("Application handles traffic only when enabled (default)")
    private Boolean enable = true;
    /**
     * Constants
     * <p>
     * Named values for (re-)use by declaration objects
     * 
     */
    @JsonProperty("constants")
    @JsonPropertyDescription("Named values for (re-)use by declaration objects")
    private Constants__1 constants;
    /**
     * Primary service of the application
     * 
     */
    @JsonProperty("serviceMain")
    @JsonPropertyDescription("Primary service of the application")
    private Object serviceMain;
    @JsonIgnore
    private Map<String, ApplicationProperty> additionalProperties = new HashMap<String, ApplicationProperty>();

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
     * Label
     * <p>
     * Optional friendly name for this object
     * 
     */
    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    /**
     * Label
     * <p>
     * Optional friendly name for this object
     * 
     */
    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Remark
     * <p>
     * Arbitrary (brief) text pertaining to this object (optional)
     * 
     */
    @JsonProperty("remark")
    public String getRemark() {
        return remark;
    }

    /**
     * Remark
     * <p>
     * Arbitrary (brief) text pertaining to this object (optional)
     * 
     */
    @JsonProperty("remark")
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Template Name
     * <p>
     * Each application type has certain required and default elements and selects appropriate setup of various ADC/Security features
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
     * Each application type has certain required and default elements and selects appropriate setup of various ADC/Security features
     * (Required)
     * 
     */
    @JsonProperty("template")
    public void setTemplate(String template) {
        this.template = template;
    }

    /**
     * Schema Overlay
     * <p>
     * BIG-IQ name for a supplemental validation schema is applied to the Application class definition before the main AS3 schema
     * 
     */
    @JsonProperty("schemaOverlay")
    public String getSchemaOverlay() {
        return schemaOverlay;
    }

    /**
     * Schema Overlay
     * <p>
     * BIG-IQ name for a supplemental validation schema is applied to the Application class definition before the main AS3 schema
     * 
     */
    @JsonProperty("schemaOverlay")
    public void setSchemaOverlay(String schemaOverlay) {
        this.schemaOverlay = schemaOverlay;
    }

    /**
     * Enable
     * <p>
     * Application handles traffic only when enabled (default)
     * 
     */
    @JsonProperty("enable")
    public Boolean getEnable() {
        return enable;
    }

    /**
     * Enable
     * <p>
     * Application handles traffic only when enabled (default)
     * 
     */
    @JsonProperty("enable")
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /**
     * Constants
     * <p>
     * Named values for (re-)use by declaration objects
     * 
     */
    @JsonProperty("constants")
    public Constants__1 getConstants() {
        return constants;
    }

    /**
     * Constants
     * <p>
     * Named values for (re-)use by declaration objects
     * 
     */
    @JsonProperty("constants")
    public void setConstants(Constants__1 constants) {
        this.constants = constants;
    }

    /**
     * Primary service of the application
     * 
     */
    @JsonProperty("serviceMain")
    public Object getServiceMain() {
        return serviceMain;
    }

    /**
     * Primary service of the application
     * 
     */
    @JsonProperty("serviceMain")
    public void setServiceMain(Object serviceMain) {
        this.serviceMain = serviceMain;
    }

    @JsonAnyGetter
    public Map<String, ApplicationProperty> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, ApplicationProperty value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Application.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("_class");
        sb.append('=');
        sb.append(((this._class == null)?"<null>":this._class));
        sb.append(',');
        sb.append("label");
        sb.append('=');
        sb.append(((this.label == null)?"<null>":this.label));
        sb.append(',');
        sb.append("remark");
        sb.append('=');
        sb.append(((this.remark == null)?"<null>":this.remark));
        sb.append(',');
        sb.append("template");
        sb.append('=');
        sb.append(((this.template == null)?"<null>":this.template));
        sb.append(',');
        sb.append("schemaOverlay");
        sb.append('=');
        sb.append(((this.schemaOverlay == null)?"<null>":this.schemaOverlay));
        sb.append(',');
        sb.append("enable");
        sb.append('=');
        sb.append(((this.enable == null)?"<null>":this.enable));
        sb.append(',');
        sb.append("constants");
        sb.append('=');
        sb.append(((this.constants == null)?"<null>":this.constants));
        sb.append(',');
        sb.append("serviceMain");
        sb.append('=');
        sb.append(((this.serviceMain == null)?"<null>":this.serviceMain));
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
        result = ((result* 31)+((this.serviceMain == null)? 0 :this.serviceMain.hashCode()));
        result = ((result* 31)+((this.enable == null)? 0 :this.enable.hashCode()));
        result = ((result* 31)+((this.remark == null)? 0 :this.remark.hashCode()));
        result = ((result* 31)+((this._class == null)? 0 :this._class.hashCode()));
        result = ((result* 31)+((this.label == null)? 0 :this.label.hashCode()));
        result = ((result* 31)+((this.constants == null)? 0 :this.constants.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.schemaOverlay == null)? 0 :this.schemaOverlay.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Application) == false) {
            return false;
        }
        Application rhs = ((Application) other);
        return ((((((((((this.template == rhs.template)||((this.template!= null)&&this.template.equals(rhs.template)))&&((this.serviceMain == rhs.serviceMain)||((this.serviceMain!= null)&&this.serviceMain.equals(rhs.serviceMain))))&&((this.enable == rhs.enable)||((this.enable!= null)&&this.enable.equals(rhs.enable))))&&((this.remark == rhs.remark)||((this.remark!= null)&&this.remark.equals(rhs.remark))))&&((this._class == rhs._class)||((this._class!= null)&&this._class.equals(rhs._class))))&&((this.label == rhs.label)||((this.label!= null)&&this.label.equals(rhs.label))))&&((this.constants == rhs.constants)||((this.constants!= null)&&this.constants.equals(rhs.constants))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.schemaOverlay == rhs.schemaOverlay)||((this.schemaOverlay!= null)&&this.schemaOverlay.equals(rhs.schemaOverlay))));
    }

}
