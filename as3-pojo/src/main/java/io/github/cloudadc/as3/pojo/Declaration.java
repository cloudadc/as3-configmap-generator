
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
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * ADC Declaration
 * <p>
 * A declarative configuration for an ADC such as F5 BIG-IP
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "class",
    "updateMode",
    "schemaVersion",
    "id",
    "target",
    "label",
    "remark",
    "constants",
    "Common",
    "controls",
    "scratch"
})
@Generated("jsonschema2pojo")
public class Declaration {

    /**
     * Class
     * <p>
     * Indicates this JSON document is an ADC declaration
     * (Required)
     * 
     */
    @JsonProperty("class")
    @JsonPropertyDescription("Indicates this JSON document is an ADC declaration")
    private String _class;
    /**
     * Update mode
     * <p>
     * When set to 'selective' (default) AS3 does not modify Tenants not referenced in the declaration.  Otherwise ('complete') AS3 removes unreferenced Tenants.
     * 
     */
    @JsonProperty("updateMode")
    @JsonPropertyDescription("When set to 'selective' (default) AS3 does not modify Tenants not referenced in the declaration.  Otherwise ('complete') AS3 removes unreferenced Tenants.")
    private Declaration.UpdateMode updateMode = Declaration.UpdateMode.fromValue("selective");
    /**
     * Schema version
     * <p>
     * Version of ADC Declaration schema this declaration uses IMPORTANT: In enum array, please put current schema version first, oldest-supported version last.  Keep enum array sorted most-recent-first.
     * (Required)
     * 
     */
    @JsonProperty("schemaVersion")
    @JsonPropertyDescription("Version of ADC Declaration schema this declaration uses")
    private Declaration.SchemaVersion schemaVersion;
    /**
     * Declaration ID
     * <p>
     * Unique identifier for this declaration (max 255 printable chars with no spaces, quotation marks, angle brackets, nor backslashes)
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Unique identifier for this declaration (max 255 printable chars with no spaces, quotation marks, angle brackets, nor backslashes)")
    private String id;
    /**
     * Target Device
     * <p>
     * Trusted BIG-IP or SSG target for config when configuring with BIG-IQ
     * 
     */
    @JsonProperty("target")
    @JsonPropertyDescription("Trusted BIG-IP or SSG target for config when configuring with BIG-IQ")
    private Target target;
    /**
     * Label
     * <p>
     * Optional friendly name for this declaration
     * 
     */
    @JsonProperty("label")
    @JsonPropertyDescription("Optional friendly name for this declaration")
    private String label;
    /**
     * Remark
     * <p>
     * Arbitrary (brief) text pertaining to this declaration (optional)
     * 
     */
    @JsonProperty("remark")
    @JsonPropertyDescription("Arbitrary (brief) text pertaining to this declaration (optional)")
    private String remark;
    /**
     * Constants
     * <p>
     * Declaration metadata and/or named values for (re-)use by declaration objects
     * 
     */
    @JsonProperty("constants")
    @JsonPropertyDescription("Declaration metadata and/or named values for (re-)use by declaration objects")
    private Constants constants;
    /**
     * Common tenant
     * <p>
     * Special tenant Common holds objects other tenants can share
     * 
     */
    @JsonProperty("Common")
    @JsonPropertyDescription("Special tenant Common holds objects other tenants can share")
    private Common common;
    /**
     * Controls
     * <p>
     * Options to control configuration process archiveId and archiveTimestamp reserved for future use.
     * 
     */
    @JsonProperty("controls")
    @JsonPropertyDescription("Options to control configuration process")
    private Controls__1 controls;
    /**
     * f5 scratch
     * <p>
     * Holds some system data during declaration processing
     * 
     */
    @JsonProperty("scratch")
    @JsonPropertyDescription("Holds some system data during declaration processing")
    private String scratch;
    @JsonIgnore
    private Map<String, Tenant> additionalProperties = new HashMap<String, Tenant>();

    /**
     * Class
     * <p>
     * Indicates this JSON document is an ADC declaration
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
     * Indicates this JSON document is an ADC declaration
     * (Required)
     * 
     */
    @JsonProperty("class")
    public void setClass_(String _class) {
        this._class = _class;
    }

    /**
     * Update mode
     * <p>
     * When set to 'selective' (default) AS3 does not modify Tenants not referenced in the declaration.  Otherwise ('complete') AS3 removes unreferenced Tenants.
     * 
     */
    @JsonProperty("updateMode")
    public Declaration.UpdateMode getUpdateMode() {
        return updateMode;
    }

    /**
     * Update mode
     * <p>
     * When set to 'selective' (default) AS3 does not modify Tenants not referenced in the declaration.  Otherwise ('complete') AS3 removes unreferenced Tenants.
     * 
     */
    @JsonProperty("updateMode")
    public void setUpdateMode(Declaration.UpdateMode updateMode) {
        this.updateMode = updateMode;
    }

    /**
     * Schema version
     * <p>
     * Version of ADC Declaration schema this declaration uses IMPORTANT: In enum array, please put current schema version first, oldest-supported version last.  Keep enum array sorted most-recent-first.
     * (Required)
     * 
     */
    @JsonProperty("schemaVersion")
    public Declaration.SchemaVersion getSchemaVersion() {
        return schemaVersion;
    }

    /**
     * Schema version
     * <p>
     * Version of ADC Declaration schema this declaration uses IMPORTANT: In enum array, please put current schema version first, oldest-supported version last.  Keep enum array sorted most-recent-first.
     * (Required)
     * 
     */
    @JsonProperty("schemaVersion")
    public void setSchemaVersion(Declaration.SchemaVersion schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

    /**
     * Declaration ID
     * <p>
     * Unique identifier for this declaration (max 255 printable chars with no spaces, quotation marks, angle brackets, nor backslashes)
     * (Required)
     * 
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * Declaration ID
     * <p>
     * Unique identifier for this declaration (max 255 printable chars with no spaces, quotation marks, angle brackets, nor backslashes)
     * (Required)
     * 
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Target Device
     * <p>
     * Trusted BIG-IP or SSG target for config when configuring with BIG-IQ
     * 
     */
    @JsonProperty("target")
    public Target getTarget() {
        return target;
    }

    /**
     * Target Device
     * <p>
     * Trusted BIG-IP or SSG target for config when configuring with BIG-IQ
     * 
     */
    @JsonProperty("target")
    public void setTarget(Target target) {
        this.target = target;
    }

    /**
     * Label
     * <p>
     * Optional friendly name for this declaration
     * 
     */
    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    /**
     * Label
     * <p>
     * Optional friendly name for this declaration
     * 
     */
    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Remark
     * <p>
     * Arbitrary (brief) text pertaining to this declaration (optional)
     * 
     */
    @JsonProperty("remark")
    public String getRemark() {
        return remark;
    }

    /**
     * Remark
     * <p>
     * Arbitrary (brief) text pertaining to this declaration (optional)
     * 
     */
    @JsonProperty("remark")
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * Constants
     * <p>
     * Declaration metadata and/or named values for (re-)use by declaration objects
     * 
     */
    @JsonProperty("constants")
    public Constants getConstants() {
        return constants;
    }

    /**
     * Constants
     * <p>
     * Declaration metadata and/or named values for (re-)use by declaration objects
     * 
     */
    @JsonProperty("constants")
    public void setConstants(Constants constants) {
        this.constants = constants;
    }

    /**
     * Common tenant
     * <p>
     * Special tenant Common holds objects other tenants can share
     * 
     */
    @JsonProperty("Common")
    public Common getCommon() {
        return common;
    }

    /**
     * Common tenant
     * <p>
     * Special tenant Common holds objects other tenants can share
     * 
     */
    @JsonProperty("Common")
    public void setCommon(Common common) {
        this.common = common;
    }

    /**
     * Controls
     * <p>
     * Options to control configuration process archiveId and archiveTimestamp reserved for future use.
     * 
     */
    @JsonProperty("controls")
    public Controls__1 getControls() {
        return controls;
    }

    /**
     * Controls
     * <p>
     * Options to control configuration process archiveId and archiveTimestamp reserved for future use.
     * 
     */
    @JsonProperty("controls")
    public void setControls(Controls__1 controls) {
        this.controls = controls;
    }

    /**
     * f5 scratch
     * <p>
     * Holds some system data during declaration processing
     * 
     */
    @JsonProperty("scratch")
    public String getScratch() {
        return scratch;
    }

    /**
     * f5 scratch
     * <p>
     * Holds some system data during declaration processing
     * 
     */
    @JsonProperty("scratch")
    public void setScratch(String scratch) {
        this.scratch = scratch;
    }

    @JsonAnyGetter
    public Map<String, Tenant> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Tenant value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Declaration.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("_class");
        sb.append('=');
        sb.append(((this._class == null)?"<null>":this._class));
        sb.append(',');
        sb.append("updateMode");
        sb.append('=');
        sb.append(((this.updateMode == null)?"<null>":this.updateMode));
        sb.append(',');
        sb.append("schemaVersion");
        sb.append('=');
        sb.append(((this.schemaVersion == null)?"<null>":this.schemaVersion));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("target");
        sb.append('=');
        sb.append(((this.target == null)?"<null>":this.target));
        sb.append(',');
        sb.append("label");
        sb.append('=');
        sb.append(((this.label == null)?"<null>":this.label));
        sb.append(',');
        sb.append("remark");
        sb.append('=');
        sb.append(((this.remark == null)?"<null>":this.remark));
        sb.append(',');
        sb.append("constants");
        sb.append('=');
        sb.append(((this.constants == null)?"<null>":this.constants));
        sb.append(',');
        sb.append("common");
        sb.append('=');
        sb.append(((this.common == null)?"<null>":this.common));
        sb.append(',');
        sb.append("controls");
        sb.append('=');
        sb.append(((this.controls == null)?"<null>":this.controls));
        sb.append(',');
        sb.append("scratch");
        sb.append('=');
        sb.append(((this.scratch == null)?"<null>":this.scratch));
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
        result = ((result* 31)+((this.schemaVersion == null)? 0 :this.schemaVersion.hashCode()));
        result = ((result* 31)+((this.controls == null)? 0 :this.controls.hashCode()));
        result = ((result* 31)+((this.remark == null)? 0 :this.remark.hashCode()));
        result = ((result* 31)+((this.scratch == null)? 0 :this.scratch.hashCode()));
        result = ((result* 31)+((this.label == null)? 0 :this.label.hashCode()));
        result = ((result* 31)+((this.target == null)? 0 :this.target.hashCode()));
        result = ((result* 31)+((this.common == null)? 0 :this.common.hashCode()));
        result = ((result* 31)+((this.updateMode == null)? 0 :this.updateMode.hashCode()));
        result = ((result* 31)+((this._class == null)? 0 :this._class.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.constants == null)? 0 :this.constants.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Declaration) == false) {
            return false;
        }
        Declaration rhs = ((Declaration) other);
        return (((((((((((((this.schemaVersion == rhs.schemaVersion)||((this.schemaVersion!= null)&&this.schemaVersion.equals(rhs.schemaVersion)))&&((this.controls == rhs.controls)||((this.controls!= null)&&this.controls.equals(rhs.controls))))&&((this.remark == rhs.remark)||((this.remark!= null)&&this.remark.equals(rhs.remark))))&&((this.scratch == rhs.scratch)||((this.scratch!= null)&&this.scratch.equals(rhs.scratch))))&&((this.label == rhs.label)||((this.label!= null)&&this.label.equals(rhs.label))))&&((this.target == rhs.target)||((this.target!= null)&&this.target.equals(rhs.target))))&&((this.common == rhs.common)||((this.common!= null)&&this.common.equals(rhs.common))))&&((this.updateMode == rhs.updateMode)||((this.updateMode!= null)&&this.updateMode.equals(rhs.updateMode))))&&((this._class == rhs._class)||((this._class!= null)&&this._class.equals(rhs._class))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.constants == rhs.constants)||((this.constants!= null)&&this.constants.equals(rhs.constants))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }


    /**
     * Schema version
     * <p>
     * Version of ADC Declaration schema this declaration uses IMPORTANT: In enum array, please put current schema version first, oldest-supported version last.  Keep enum array sorted most-recent-first.
     * 
     */
    @Generated("jsonschema2pojo")
    public enum SchemaVersion {

        _3_18_0("3.18.0"),
        _3_17_0("3.17.0"),
        _3_16_0("3.16.0"),
        _3_15_0("3.15.0"),
        _3_14_0("3.14.0"),
        _3_13_0("3.13.0"),
        _3_12_0("3.12.0"),
        _3_11_0("3.11.0"),
        _3_10_0("3.10.0"),
        _3_9_0("3.9.0"),
        _3_8_0("3.8.0"),
        _3_7_0("3.7.0"),
        _3_6_0("3.6.0"),
        _3_5_0("3.5.0"),
        _3_4_0("3.4.0"),
        _3_3_0("3.3.0"),
        _3_2_0("3.2.0"),
        _3_1_0("3.1.0"),
        _3_0_0("3.0.0");
        private final String value;
        private final static Map<String, Declaration.SchemaVersion> CONSTANTS = new HashMap<String, Declaration.SchemaVersion>();

        static {
            for (Declaration.SchemaVersion c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        SchemaVersion(String value) {
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
        public static Declaration.SchemaVersion fromValue(String value) {
            Declaration.SchemaVersion constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }


    /**
     * Update mode
     * <p>
     * When set to 'selective' (default) AS3 does not modify Tenants not referenced in the declaration.  Otherwise ('complete') AS3 removes unreferenced Tenants.
     * 
     */
    @Generated("jsonschema2pojo")
    public enum UpdateMode {

        COMPLETE("complete"),
        SELECTIVE("selective");
        private final String value;
        private final static Map<String, Declaration.UpdateMode> CONSTANTS = new HashMap<String, Declaration.UpdateMode>();

        static {
            for (Declaration.UpdateMode c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        UpdateMode(String value) {
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
        public static Declaration.UpdateMode fromValue(String value) {
            Declaration.UpdateMode constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
