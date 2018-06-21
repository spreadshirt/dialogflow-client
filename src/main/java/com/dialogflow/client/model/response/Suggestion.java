package com.dialogflow.client.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("suggestion")
public class Suggestion implements Response {

    @JsonProperty
    private final String title;

    public Suggestion(String title) {
        this.title = title;
    }

    @Override
    public boolean isSystemIndent() {
        return false;
    }
}
