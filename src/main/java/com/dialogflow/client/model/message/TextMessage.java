package com.dialogflow.client.model.message;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TextMessage extends Message {

    @JsonProperty
    private List<String> text;

    public List<String> getText() {
        return text;
    }
}
