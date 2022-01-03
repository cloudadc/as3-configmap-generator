
package io.github.cloudadc.as3.pojo;

import java.util.Date;
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
 * Options to control configuration process archiveId and archiveTimestamp reserved for future use.
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "class",
    "logLevel",
    "trace",
    "traceResponse",
    "userAgent",
    "archiveId",
    "archiveTimestamp"
})
@Generated("jsonschema2pojo")
public class Controls__1 {

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
     * Controls the amount of detail in logs produced by the configuration process using RFC 5424 severity levels (default is 'error').  May be overridden on a per-Tenant basis
     * 
     */
    @JsonProperty("logLevel")
    @JsonPropertyDescription("Controls the amount of detail in logs produced by the configuration process using RFC 5424 severity levels (default is 'error').  May be overridden on a per-Tenant basis")
    private Controls__1 .LogLevel logLevel = Controls__1 .LogLevel.fromValue("error");
    /**
     * Trace
     * <p>
     * If true, AS3 creates a detailed trace of the configuration process for subsequent analysis (default false).  May be overridden on a per-Tenant basis.  Warning:  trace files may contain sensitive configuration data
     * 
     */
    @JsonProperty("trace")
    @JsonPropertyDescription("If true, AS3 creates a detailed trace of the configuration process for subsequent analysis (default false).  May be overridden on a per-Tenant basis.  Warning:  trace files may contain sensitive configuration data")
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
     * User Agent
     * <p>
     * User Agent information to include in TEEM report
     * 
     */
    @JsonProperty("userAgent")
    @JsonPropertyDescription("User Agent information to include in TEEM report")
    private String userAgent;
    /**
     * Archive ID
     * <p>
     * Read-only property present when you GET a declaration from configuration system.  Archived versions of declaration are identified by a combination of 'id' and 'archiveId'
     * 
     */
    @JsonProperty("archiveId")
    @JsonPropertyDescription("Read-only property present when you GET a declaration from configuration system.  Archived versions of declaration are identified by a combination of 'id' and 'archiveId'")
    private Double archiveId;
    /**
     * Archive timestamp
     * <p>
     * Read-only property present when you GET a declaration from configuration system.  Indicates when this version (see archiveId) of declaration was archived
     * 
     */
    @JsonProperty("archiveTimestamp")
    @JsonPropertyDescription("Read-only property present when you GET a declaration from configuration system.  Indicates when this version (see archiveId) of declaration was archived")
    private Date archiveTimestamp;

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
     * Controls the amount of detail in logs produced by the configuration process using RFC 5424 severity levels (default is 'error').  May be overridden on a per-Tenant basis
     * 
     */
    @JsonProperty("logLevel")
    public Controls__1 .LogLevel getLogLevel() {
        return logLevel;
    }

    /**
     * Log level
     * <p>
     * Controls the amount of detail in logs produced by the configuration process using RFC 5424 severity levels (default is 'error').  May be overridden on a per-Tenant basis
     * 
     */
    @JsonProperty("logLevel")
    public void setLogLevel(Controls__1 .LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * Trace
     * <p>
     * If true, AS3 creates a detailed trace of the configuration process for subsequent analysis (default false).  May be overridden on a per-Tenant basis.  Warning:  trace files may contain sensitive configuration data
     * 
     */
    @JsonProperty("trace")
    public Boolean getTrace() {
        return trace;
    }

    /**
     * Trace
     * <p>
     * If true, AS3 creates a detailed trace of the configuration process for subsequent analysis (default false).  May be overridden on a per-Tenant basis.  Warning:  trace files may contain sensitive configuration data
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
     * User Agent
     * <p>
     * User Agent information to include in TEEM report
     * 
     */
    @JsonProperty("userAgent")
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * User Agent
     * <p>
     * User Agent information to include in TEEM report
     * 
     */
    @JsonProperty("userAgent")
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    /**
     * Archive ID
     * <p>
     * Read-only property present when you GET a declaration from configuration system.  Archived versions of declaration are identified by a combination of 'id' and 'archiveId'
     * 
     */
    @JsonProperty("archiveId")
    public Double getArchiveId() {
        return archiveId;
    }

    /**
     * Archive ID
     * <p>
     * Read-only property present when you GET a declaration from configuration system.  Archived versions of declaration are identified by a combination of 'id' and 'archiveId'
     * 
     */
    @JsonProperty("archiveId")
    public void setArchiveId(Double archiveId) {
        this.archiveId = archiveId;
    }

    /**
     * Archive timestamp
     * <p>
     * Read-only property present when you GET a declaration from configuration system.  Indicates when this version (see archiveId) of declaration was archived
     * 
     */
    @JsonProperty("archiveTimestamp")
    public Date getArchiveTimestamp() {
        return archiveTimestamp;
    }

    /**
     * Archive timestamp
     * <p>
     * Read-only property present when you GET a declaration from configuration system.  Indicates when this version (see archiveId) of declaration was archived
     * 
     */
    @JsonProperty("archiveTimestamp")
    public void setArchiveTimestamp(Date archiveTimestamp) {
        this.archiveTimestamp = archiveTimestamp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Controls__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("userAgent");
        sb.append('=');
        sb.append(((this.userAgent == null)?"<null>":this.userAgent));
        sb.append(',');
        sb.append("archiveId");
        sb.append('=');
        sb.append(((this.archiveId == null)?"<null>":this.archiveId));
        sb.append(',');
        sb.append("archiveTimestamp");
        sb.append('=');
        sb.append(((this.archiveTimestamp == null)?"<null>":this.archiveTimestamp));
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
        result = ((result* 31)+((this.archiveTimestamp == null)? 0 :this.archiveTimestamp.hashCode()));
        result = ((result* 31)+((this.logLevel == null)? 0 :this.logLevel.hashCode()));
        result = ((result* 31)+((this.userAgent == null)? 0 :this.userAgent.hashCode()));
        result = ((result* 31)+((this._class == null)? 0 :this._class.hashCode()));
        result = ((result* 31)+((this.traceResponse == null)? 0 :this.traceResponse.hashCode()));
        result = ((result* 31)+((this.archiveId == null)? 0 :this.archiveId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Controls__1) == false) {
            return false;
        }
        Controls__1 rhs = ((Controls__1) other);
        return ((((((((this.trace == rhs.trace)||((this.trace!= null)&&this.trace.equals(rhs.trace)))&&((this.archiveTimestamp == rhs.archiveTimestamp)||((this.archiveTimestamp!= null)&&this.archiveTimestamp.equals(rhs.archiveTimestamp))))&&((this.logLevel == rhs.logLevel)||((this.logLevel!= null)&&this.logLevel.equals(rhs.logLevel))))&&((this.userAgent == rhs.userAgent)||((this.userAgent!= null)&&this.userAgent.equals(rhs.userAgent))))&&((this._class == rhs._class)||((this._class!= null)&&this._class.equals(rhs._class))))&&((this.traceResponse == rhs.traceResponse)||((this.traceResponse!= null)&&this.traceResponse.equals(rhs.traceResponse))))&&((this.archiveId == rhs.archiveId)||((this.archiveId!= null)&&this.archiveId.equals(rhs.archiveId))));
    }


    /**
     * Log level
     * <p>
     * Controls the amount of detail in logs produced by the configuration process using RFC 5424 severity levels (default is 'error').  May be overridden on a per-Tenant basis
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
        private final static Map<String, Controls__1 .LogLevel> CONSTANTS = new HashMap<String, Controls__1 .LogLevel>();

        static {
            for (Controls__1 .LogLevel c: values()) {
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
        public static Controls__1 .LogLevel fromValue(String value) {
            Controls__1 .LogLevel constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
