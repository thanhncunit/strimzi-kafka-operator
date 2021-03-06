/*
 * Copyright Strimzi authors.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.strimzi.api.kafka.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.strimzi.crdgenerator.annotations.Description;
import io.strimzi.crdgenerator.annotations.Pattern;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Representation for options to be passed to a JVM.
 */
@Buildable(
        editableEnabled = false,
        generateBuilderPackage = false,
        builderPackage = "io.fabric8.kubernetes.api.builder"
)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@EqualsAndHashCode
public class JvmOptions implements UnknownPropertyPreserving, Serializable {

    private static final long serialVersionUID = 1L;

    private String xmx;
    private String xms;
    private Boolean server;
    private boolean gcLoggingEnabled = false;
    private Map<String, String> xx;
    private Map<String, Object> additionalProperties = new HashMap<>(0);

    @JsonProperty("-Xmx")
    @Pattern("[0-9]+[mMgG]?")
    @Description("-Xmx option to to the JVM")
    public String getXmx() {
        return xmx;
    }

    public void setXmx(String xmx) {
        this.xmx = xmx;
    }

    @JsonProperty("-Xms")
    @Pattern("[0-9]+[mMgG]?")
    @Description("-Xms option to to the JVM")
    public String getXms() {
        return xms;
    }

    public void setXms(String xms) {
        this.xms = xms;
    }

    @JsonProperty("-server")
    @Description("-server option to to the JVM")
    public Boolean isServer() {
        return server;
    }

    public void setServer(Boolean server) {
        this.server = server;
    }

    @Description("Specifies whether the Garbage Collection logging is enabled. The default is false.")
    public boolean isGcLoggingEnabled() {
        return gcLoggingEnabled;
    }

    public void setGcLoggingEnabled(boolean gcLoggingEnabled) {
        this.gcLoggingEnabled = gcLoggingEnabled;
    }

    @JsonProperty("-XX")
    @Description("A map of -XX options to the JVM")
    public Map<String, String> getXx() {
        return xx;
    }

    public void setXx(Map<String, String> xx) {
        this.xx = xx;
    }

    @Override
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @Override
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

