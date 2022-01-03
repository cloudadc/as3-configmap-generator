
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
 * AS3 API Request
 * <p>
 * AS3 API request body
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "declaration"
})
@Generated("jsonschema2pojo")
public class As3Schema31804Cis {

    /**
     * ADC Declaration
     * <p>
     * A declarative configuration for an ADC such as F5 BIG-IP
     * 
     */
    @JsonProperty("declaration")
    @JsonPropertyDescription("A declarative configuration for an ADC such as F5 BIG-IP")
    private Declaration declaration;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * ADC Declaration
     * <p>
     * A declarative configuration for an ADC such as F5 BIG-IP
     * 
     */
    @JsonProperty("declaration")
    public Declaration getDeclaration() {
        return declaration;
    }

    /**
     * ADC Declaration
     * <p>
     * A declarative configuration for an ADC such as F5 BIG-IP
     * 
     */
    @JsonProperty("declaration")
    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
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
        sb.append(As3Schema31804Cis.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("declaration");
        sb.append('=');
        sb.append(((this.declaration == null)?"<null>":this.declaration));
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
        result = ((result* 31)+((this.declaration == null)? 0 :this.declaration.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof As3Schema31804Cis) == false) {
            return false;
        }
        As3Schema31804Cis rhs = ((As3Schema31804Cis) other);
        return (((this.declaration == rhs.declaration)||((this.declaration!= null)&&this.declaration.equals(rhs.declaration)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
