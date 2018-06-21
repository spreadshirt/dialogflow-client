package com.dialogflow.client.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Part {

    @JsonProperty
    private String text;

    @JsonProperty
    private String entityType;

    @JsonProperty
    private String alias;

    @JsonProperty
    private Boolean userDefined;

    public String getText() {
        return text;
    }

    public String getEntityType() {
        return entityType;
    }

    public String getAlias() {
        return alias;
    }

    public Boolean getUserDefined() {
        return userDefined;
    }
}
