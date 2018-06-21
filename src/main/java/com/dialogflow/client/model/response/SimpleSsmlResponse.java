package com.dialogflow.client.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;


public class SimpleSsmlResponse extends SimpleResponse {

    @JsonProperty
    private final String ssml;

    @JsonProperty
    private final String displayText;

    public SimpleSsmlResponse(String ssml, String displayText) {
        this.ssml = ssml;
        this.displayText = displayText;
    }

    @Override
    public String fulfillmentText() {
        return displayText;
    }
}
