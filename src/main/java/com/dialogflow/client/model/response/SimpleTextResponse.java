package com.dialogflow.client.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;


public class SimpleTextResponse extends SimpleResponse {

    @JsonProperty
    private final String textToSpeech;

    @JsonProperty
    private final String displayText;

    public SimpleTextResponse(String textToSpeech) {
        this(textToSpeech, textToSpeech);
    }

    public SimpleTextResponse(String textToSpeech, String displayText) {
        this.textToSpeech = textToSpeech;
        this.displayText = displayText;
    }

    @Override
    public String fulfillmentText() {
        return displayText;
    }
}
