
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
 * Tenant
 * <p>
 * Declares a Tenant
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "class",
    "label",
    "remark",
    "verifiers",
    "enable",
    "defaultRouteDomain",
    "Shared",
    "constants",
    "controls",
    "optimisticLockKey"
})
@Generated("jsonschema2pojo")
public class Tenant {

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
     * Verifiers
     * <p>
     * Data (in 'key':'value' properties) used to verify automated tests.  Ordinary declarations do not need this
     * 
     */
    @JsonProperty("verifiers")
    @JsonPropertyDescription("Data (in 'key':'value' properties) used to verify automated tests.  Ordinary declarations do not need this")
    private Verifiers__1 verifiers;
    /**
     * Enable
     * <p>
     * Tenant handles traffic only when enabled (default)
     * 
     */
    @JsonProperty("enable")
    @JsonPropertyDescription("Tenant handles traffic only when enabled (default)")
    private Boolean enable = true;
    /**
     * Default route domain
     * <p>
     * Selects the default route domain for IP traffic to and from this Tenant's application resources (note: affects declared IP addresses which do not include a %RD route-domain specifier).  You must choose an existing route domain--this option cannot create one.  Route domain 0 (default) is always available
     * 
     */
    @JsonProperty("defaultRouteDomain")
    @JsonPropertyDescription("Selects the default route domain for IP traffic to and from this Tenant's application resources (note: affects declared IP addresses which do not include a %RD route-domain specifier).  You must choose an existing route domain--this option cannot create one.  Route domain 0 (default) is always available")
    private Integer defaultRouteDomain = 0;
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
     * Optimistic lock key
     * <p>
     * When you deploy a declaration with a non-empty 'key' value here, that activates an optimistic lock on changes to this Tenant.  If the key in your declaration does not match the key AS3 computes for the most-recent previous declaration, then AS3 will NOT update this Tenant and will return an error code.  To use optimistic locking, first retrieve a declaration using option 'showHash=true' to get the current per-Tenant keys.  Make any changes you desire, then deploy your updated declaration.  Deployment of each Tenant with a key will succeed only if that Tenant has not been modified since the time you retrieved the declaration.  (To overwrite all previous changes to a Tenant simply do NOT include any opportunistic-lock key for that Tenant when you deploy a declaration.  That is the default.)  Note that only keys computed by AS3 may be used here-- you cannot generate your own. If 'showHash=true' is used on a POST then the optimisticLockKey will be shown as a part of the output (This helps to avoid the need to do a GET request).
     * 
     */
    @JsonProperty("optimisticLockKey")
    @JsonPropertyDescription("When you deploy a declaration with a non-empty 'key' value here, that activates an optimistic lock on changes to this Tenant.  If the key in your declaration does not match the key AS3 computes for the most-recent previous declaration, then AS3 will NOT update this Tenant and will return an error code.  To use optimistic locking, first retrieve a declaration using option 'showHash=true' to get the current per-Tenant keys.  Make any changes you desire, then deploy your updated declaration.  Deployment of each Tenant with a key will succeed only if that Tenant has not been modified since the time you retrieved the declaration.  (To overwrite all previous changes to a Tenant simply do NOT include any opportunistic-lock key for that Tenant when you deploy a declaration.  That is the default.)  Note that only keys computed by AS3 may be used here-- you cannot generate your own. If 'showHash=true' is used on a POST then the optimisticLockKey will be shown as a part of the output (This helps to avoid the need to do a GET request).")
    private String optimisticLockKey = "";
    @JsonIgnore
    private Map<String, Application> additionalProperties = new HashMap<String, Application>();

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
     * Verifiers
     * <p>
     * Data (in 'key':'value' properties) used to verify automated tests.  Ordinary declarations do not need this
     * 
     */
    @JsonProperty("verifiers")
    public Verifiers__1 getVerifiers() {
        return verifiers;
    }

    /**
     * Verifiers
     * <p>
     * Data (in 'key':'value' properties) used to verify automated tests.  Ordinary declarations do not need this
     * 
     */
    @JsonProperty("verifiers")
    public void setVerifiers(Verifiers__1 verifiers) {
        this.verifiers = verifiers;
    }

    /**
     * Enable
     * <p>
     * Tenant handles traffic only when enabled (default)
     * 
     */
    @JsonProperty("enable")
    public Boolean getEnable() {
        return enable;
    }

    /**
     * Enable
     * <p>
     * Tenant handles traffic only when enabled (default)
     * 
     */
    @JsonProperty("enable")
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /**
     * Default route domain
     * <p>
     * Selects the default route domain for IP traffic to and from this Tenant's application resources (note: affects declared IP addresses which do not include a %RD route-domain specifier).  You must choose an existing route domain--this option cannot create one.  Route domain 0 (default) is always available
     * 
     */
    @JsonProperty("defaultRouteDomain")
    public Integer getDefaultRouteDomain() {
        return defaultRouteDomain;
    }

    /**
     * Default route domain
     * <p>
     * Selects the default route domain for IP traffic to and from this Tenant's application resources (note: affects declared IP addresses which do not include a %RD route-domain specifier).  You must choose an existing route domain--this option cannot create one.  Route domain 0 (default) is always available
     * 
     */
    @JsonProperty("defaultRouteDomain")
    public void setDefaultRouteDomain(Integer defaultRouteDomain) {
        this.defaultRouteDomain = defaultRouteDomain;
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

    /**
     * Optimistic lock key
     * <p>
     * When you deploy a declaration with a non-empty 'key' value here, that activates an optimistic lock on changes to this Tenant.  If the key in your declaration does not match the key AS3 computes for the most-recent previous declaration, then AS3 will NOT update this Tenant and will return an error code.  To use optimistic locking, first retrieve a declaration using option 'showHash=true' to get the current per-Tenant keys.  Make any changes you desire, then deploy your updated declaration.  Deployment of each Tenant with a key will succeed only if that Tenant has not been modified since the time you retrieved the declaration.  (To overwrite all previous changes to a Tenant simply do NOT include any opportunistic-lock key for that Tenant when you deploy a declaration.  That is the default.)  Note that only keys computed by AS3 may be used here-- you cannot generate your own. If 'showHash=true' is used on a POST then the optimisticLockKey will be shown as a part of the output (This helps to avoid the need to do a GET request).
     * 
     */
    @JsonProperty("optimisticLockKey")
    public String getOptimisticLockKey() {
        return optimisticLockKey;
    }

    /**
     * Optimistic lock key
     * <p>
     * When you deploy a declaration with a non-empty 'key' value here, that activates an optimistic lock on changes to this Tenant.  If the key in your declaration does not match the key AS3 computes for the most-recent previous declaration, then AS3 will NOT update this Tenant and will return an error code.  To use optimistic locking, first retrieve a declaration using option 'showHash=true' to get the current per-Tenant keys.  Make any changes you desire, then deploy your updated declaration.  Deployment of each Tenant with a key will succeed only if that Tenant has not been modified since the time you retrieved the declaration.  (To overwrite all previous changes to a Tenant simply do NOT include any opportunistic-lock key for that Tenant when you deploy a declaration.  That is the default.)  Note that only keys computed by AS3 may be used here-- you cannot generate your own. If 'showHash=true' is used on a POST then the optimisticLockKey will be shown as a part of the output (This helps to avoid the need to do a GET request).
     * 
     */
    @JsonProperty("optimisticLockKey")
    public void setOptimisticLockKey(String optimisticLockKey) {
        this.optimisticLockKey = optimisticLockKey;
    }

    @JsonAnyGetter
    public Map<String, Application> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Application value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Tenant.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("defaultRouteDomain");
        sb.append('=');
        sb.append(((this.defaultRouteDomain == null)?"<null>":this.defaultRouteDomain));
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
        sb.append("optimisticLockKey");
        sb.append('=');
        sb.append(((this.optimisticLockKey == null)?"<null>":this.optimisticLockKey));
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
        result = ((result* 31)+((this.shared == null)? 0 :this.shared.hashCode()));
        result = ((result* 31)+((this.controls == null)? 0 :this.controls.hashCode()));
        result = ((result* 31)+((this.optimisticLockKey == null)? 0 :this.optimisticLockKey.hashCode()));
        result = ((result* 31)+((this.enable == null)? 0 :this.enable.hashCode()));
        result = ((result* 31)+((this.defaultRouteDomain == null)? 0 :this.defaultRouteDomain.hashCode()));
        result = ((result* 31)+((this.remark == null)? 0 :this.remark.hashCode()));
        result = ((result* 31)+((this._class == null)? 0 :this._class.hashCode()));
        result = ((result* 31)+((this.label == null)? 0 :this.label.hashCode()));
        result = ((result* 31)+((this.constants == null)? 0 :this.constants.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.verifiers == null)? 0 :this.verifiers.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Tenant) == false) {
            return false;
        }
        Tenant rhs = ((Tenant) other);
        return ((((((((((((this.shared == rhs.shared)||((this.shared!= null)&&this.shared.equals(rhs.shared)))&&((this.controls == rhs.controls)||((this.controls!= null)&&this.controls.equals(rhs.controls))))&&((this.optimisticLockKey == rhs.optimisticLockKey)||((this.optimisticLockKey!= null)&&this.optimisticLockKey.equals(rhs.optimisticLockKey))))&&((this.enable == rhs.enable)||((this.enable!= null)&&this.enable.equals(rhs.enable))))&&((this.defaultRouteDomain == rhs.defaultRouteDomain)||((this.defaultRouteDomain!= null)&&this.defaultRouteDomain.equals(rhs.defaultRouteDomain))))&&((this.remark == rhs.remark)||((this.remark!= null)&&this.remark.equals(rhs.remark))))&&((this._class == rhs._class)||((this._class!= null)&&this._class.equals(rhs._class))))&&((this.label == rhs.label)||((this.label!= null)&&this.label.equals(rhs.label))))&&((this.constants == rhs.constants)||((this.constants!= null)&&this.constants.equals(rhs.constants))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.verifiers == rhs.verifiers)||((this.verifiers!= null)&&this.verifiers.equals(rhs.verifiers))));
    }

}
