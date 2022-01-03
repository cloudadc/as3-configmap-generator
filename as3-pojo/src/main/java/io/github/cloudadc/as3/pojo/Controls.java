
package io.github.cloudadc.as3.pojo;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Controls
 * <p>
 * Options to control configuration process
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "class",
    "logLevel",
    "trace",
    "traceResponse",
    "fortune"
})
@Generated("jsonschema2pojo")
public class Controls {

    /**
     * Class
     * <p>
     * 
     * 
     */
    @JsonProperty("class")
    private String _class = "Controls";
    /**
     * Log level
     * <p>
     * Controls the amount of detail in logs produced while configuring this Tenant (default is whole-declaration Controls/logLevel value)
     * 
     */
    @JsonProperty("logLevel")
    @JsonPropertyDescription("Controls the amount of detail in logs produced while configuring this Tenant (default is whole-declaration Controls/logLevel value)")
    private Controls.LogLevel logLevel = Controls.LogLevel.fromValue("error");
    /**
     * Trace
     * <p>
     * If true, AS3 creates a detailed trace of the configuration process for this Tenant for subsequent analysis (default is whole-declaration Controls/trace value).  Warning:  trace files may contain sensitive configuration data
     * 
     */
    @JsonProperty("trace")
    @JsonPropertyDescription("If true, AS3 creates a detailed trace of the configuration process for this Tenant for subsequent analysis (default is whole-declaration Controls/trace value).  Warning:  trace files may contain sensitive configuration data")
    private Boolean trace = false;
    /**
     * Trace Response
     * <p>
     * If true, the response will contain the trace files
     * 
     */
    @JsonProperty("traceResponse")
    @JsonPropertyDescription("If true, the response will contain the trace files")
    private Boolean traceResponse = false;
    /**
     * Fortune
     * <p>
     * If true, AS3 will activate Zoltar mode and read you your fortune
     * 
     */
    @JsonProperty("fortune")
    @JsonPropertyDescription("If true, AS3 will activate Zoltar mode and read you your fortune")
    private Boolean fortune = false;

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
     * Log level
     * <p>
     * Controls the amount of detail in logs produced while configuring this Tenant (default is whole-declaration Controls/logLevel value)
     * 
     */
    @JsonProperty("logLevel")
    public Controls.LogLevel getLogLevel() {
        return logLevel;
    }

    /**
     * Log level
     * <p>
     * Controls the amount of detail in logs produced while configuring this Tenant (default is whole-declaration Controls/logLevel value)
     * 
     */
    @JsonProperty("logLevel")
    public void setLogLevel(Controls.LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * Trace
     * <p>
     * If true, AS3 creates a detailed trace of the configuration process for this Tenant for subsequent analysis (default is whole-declaration Controls/trace value).  Warning:  trace files may contain sensitive configuration data
     * 
     */
    @JsonProperty("trace")
    public Boolean getTrace() {
        return trace;
    }

    /**
     * Trace
     * <p>
     * If true, AS3 creates a detailed trace of the configuration process for this Tenant for subsequent analysis (default is whole-declaration Controls/trace value).  Warning:  trace files may contain sensitive configuration data
     * 
     */
    @JsonProperty("trace")
    public void setTrace(Boolean trace) {
        this.trace = trace;
    }

    /**
     * Trace Response
     * <p>
     * If true, the response will contain the trace files
     * 
     */
    @JsonProperty("traceResponse")
    public Boolean getTraceResponse() {
        return traceResponse;
    }

    /**
     * Trace Response
     * <p>
     * If true, the response will contain the trace files
     * 
     */
    @JsonProperty("traceResponse")
    public void setTraceResponse(Boolean traceResponse) {
        this.traceResponse = traceResponse;
    }

    /**
     * Fortune
     * <p>
     * If true, AS3 will activate Zoltar mode and read you your fortune
     * 
     */
    @JsonProperty("fortune")
    public Boolean getFortune() {
        return fortune;
    }

    /**
     * Fortune
     * <p>
     * If true, AS3 will activate Zoltar mode and read you your fortune
     * 
     */
    @JsonProperty("fortune")
    public void setFortune(Boolean fortune) {
        this.fortune = fortune;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Controls.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("_class");
        sb.append('=');
        sb.append(((this._class == null)?"<null>":this._class));
        sb.append(',');
        sb.append("logLevel");
        sb.append('=');
        sb.append(((this.logLevel == null)?"<null>":this.logLevel));
        sb.append(',');
        sb.append("trace");
        sb.append('=');
        sb.append(((this.trace == null)?"<null>":this.trace));
        sb.append(',');
        sb.append("traceResponse");
        sb.append('=');
        sb.append(((this.traceResponse == null)?"<null>":this.traceResponse));
        sb.append(',');
        sb.append("fortune");
        sb.append('=');
        sb.append(((this.fortune == null)?"<null>":this.fortune));
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
        result = ((result* 31)+((this.trace == null)? 0 :this.trace.hashCode()));
        result = ((result* 31)+((this._class == null)? 0 :this._class.hashCode()));
        result = ((result* 31)+((this.fortune == null)? 0 :this.fortune.hashCode()));
        result = ((result* 31)+((this.logLevel == null)? 0 :this.logLevel.hashCode()));
        result = ((result* 31)+((this.traceResponse == null)? 0 :this.traceResponse.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Controls) == false) {
            return false;
        }
        Controls rhs = ((Controls) other);
        return ((((((this.trace == rhs.trace)||((this.trace!= null)&&this.trace.equals(rhs.trace)))&&((this._class == rhs._class)||((this._class!= null)&&this._class.equals(rhs._class))))&&((this.fortune == rhs.fortune)||((this.fortune!= null)&&this.fortune.equals(rhs.fortune))))&&((this.logLevel == rhs.logLevel)||((this.logLevel!= null)&&this.logLevel.equals(rhs.logLevel))))&&((this.traceResponse == rhs.traceResponse)||((this.traceResponse!= null)&&this.traceResponse.equals(rhs.traceResponse))));
    }


    /**
     * Log level
     * <p>
     * Controls the amount of detail in logs produced while configuring this Tenant (default is whole-declaration Controls/logLevel value)
     * 
     */
    @Generated("jsonschema2pojo")
    public enum LogLevel {

        EMERGENCY("emergency"),
        ALERT("alert"),
        CRITICAL("critical"),
        ERROR("error"),
        WARNING("warning"),
        NOTICE("notice"),
        INFO("info"),
        DEBUG("debug");
        private final String value;
        private final static Map<String, Controls.LogLevel> CONSTANTS = new HashMap<String, Controls.LogLevel>();

        static {
            for (Controls.LogLevel c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        LogLevel(String value) {
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
        public static Controls.LogLevel fromValue(String value) {
            Controls.LogLevel constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
