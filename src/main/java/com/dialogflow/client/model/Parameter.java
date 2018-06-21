package com.dialogflow.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Parameter {

    @JsonProperty
    private String name;

    @JsonProperty
    private String displayName;

    @JsonProperty
    private String value;

    @JsonProperty
    private String defaultValue;

    @JsonProperty
    private String entityTypeDisplayName;

    @JsonProperty
    private boolean mandatory;

    @JsonProperty
    private List<String> prompts;

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getValue() {
        return value;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public String getEntityTypeDisplayName() {
        return entityTypeDisplayName;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public List<String> getPrompts() {
        return prompts;
    }
}
