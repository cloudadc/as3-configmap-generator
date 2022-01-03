
package io.github.cloudadc.as3.pojo;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Common tenant
 * <p>
 * Special tenant Common holds objects other tenants can share
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "class",
    "label",
    "remark",
    "verifiers",
    "enable",
    "Shared",
    "constants",
    "controls"
})
@Generated("jsonschema2pojo")
public class Common {

    /**
     * Class
     * <p>
     * 
     * 
     */
    @JsonProperty("class")
    private String _class = "Tenant";
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
     * Verifiers
     * <p>
     * Data (in 'key':'value' properties) used to verify automated tests.  Ordinary declarations do not need this
     * 
     */
    @JsonProperty("verifiers")
    @JsonPropertyDescription("Data (in 'key':'value' properties) used to verify automated tests.  Ordinary declarations do not need this")
    private Verifiers verifiers;
    /**
     * Enable
     * <p>
     * If declared, you must enable the Common tenant
     * 
     */
    @JsonProperty("enable")
    @JsonPropertyDescription("If declared, you must enable the Common tenant")
    private Boolean enable;
    /**
     * Shared Application
     * <p>
     * Special application Shared holds objects other applications can share
     * 
     */
    @JsonProperty("Shared")
    @JsonPropertyDescription("Special application Shared holds objects other applications can share")
    private ApplicationShared shared;
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
     * Controls
     * <p>
     * Options to control configuration process
     * 
     */
    @JsonProperty("controls")
    @JsonPropertyDescription("Options to control configuration process")
    private Controls controls;

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
     * Verifiers
     * <p>
     * Data (in 'key':'value' properties) used to verify automated tests.  Ordinary declarations do not need this
     * 
     */
    @JsonProperty("verifiers")
    public Verifiers getVerifiers() {
        return verifiers;
    }

    /**
     * Verifiers
     * <p>
     * Data (in 'key':'value' properties) used to verify automated tests.  Ordinary declarations do not need this
     * 
     */
    @JsonProperty("verifiers")
    public void setVerifiers(Verifiers verifiers) {
        this.verifiers = verifiers;
    }

    /**
     * Enable
     * <p>
     * If declared, you must enable the Common tenant
     * 
     */
    @JsonProperty("enable")
    public Boolean getEnable() {
        return enable;
    }

    /**
     * Enable
     * <p>
     * If declared, you must enable the Common tenant
     * 
     */
    @JsonProperty("enable")
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /**
     * Shared Application
     * <p>
     * Special application Shared holds objects other applications can share
     * 
     */
    @JsonProperty("Shared")
    public ApplicationShared getShared() {
        return shared;
    }

    /**
     * Shared Application
     * <p>
     * Special application Shared holds objects other applications can share
     * 
     */
    @JsonProperty("Shared")
    public void setShared(ApplicationShared shared) {
        this.shared = shared;
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
     * Controls
     * <p>
     * Options to control configuration process
     * 
     */
    @JsonProperty("controls")
    public Controls getControls() {
        return controls;
    }

    /**
     * Controls
     * <p>
     * Options to control configuration process
     * 
     */
    @JsonProperty("controls")
    public void setControls(Controls controls) {
        this.controls = controls;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Common.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("verifiers");
        sb.append('=');
        sb.append(((this.verifiers == null)?"<null>":this.verifiers));
        sb.append(',');
        sb.append("enable");
        sb.append('=');
        sb.append(((this.enable == null)?"<null>":this.enable));
        sb.append(',');
        sb.append("shared");
        sb.append('=');
        sb.append(((this.shared == null)?"<null>":this.shared));
        sb.append(',');
        sb.append("constants");
        sb.append('=');
        sb.append(((this.constants == null)?"<null>":this.constants));
        sb.append(',');
        sb.append("controls");
        sb.append('=');
        sb.append(((this.controls == null)?"<null>":this.controls));
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
        result = ((result* 31)+((this.shared == null)? 0 :this.shared.hashCode()));
        result = ((result* 31)+((this.controls == null)? 0 :this.controls.hashCode()));
        result = ((result* 31)+((this.enable == null)? 0 :this.enable.hashCode()));
        result = ((result* 31)+((this.remark == null)? 0 :this.remark.hashCode()));
        result = ((result* 31)+((this._class == null)? 0 :this._class.hashCode()));
        result = ((result* 31)+((this.label == null)? 0 :this.label.hashCode()));
        result = ((result* 31)+((this.constants == null)? 0 :this.constants.hashCode()));
        result = ((result* 31)+((this.verifiers == null)? 0 :this.verifiers.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Common) == false) {
            return false;
        }
        Common rhs = ((Common) other);
        return (((((((((this.shared == rhs.shared)||((this.shared!= null)&&this.shared.equals(rhs.shared)))&&((this.controls == rhs.controls)||((this.controls!= null)&&this.controls.equals(rhs.controls))))&&((this.enable == rhs.enable)||((this.enable!= null)&&this.enable.equals(rhs.enable))))&&((this.remark == rhs.remark)||((this.remark!= null)&&this.remark.equals(rhs.remark))))&&((this._class == rhs._class)||((this._class!= null)&&this._class.equals(rhs._class))))&&((this.label == rhs.label)||((this.label!= null)&&this.label.equals(rhs.label))))&&((this.constants == rhs.constants)||((this.constants!= null)&&this.constants.equals(rhs.constants))))&&((this.verifiers == rhs.verifiers)||((this.verifiers!= null)&&this.verifiers.equals(rhs.verifiers))));
    }

}
