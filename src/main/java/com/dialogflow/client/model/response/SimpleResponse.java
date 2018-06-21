package com.dialogflow.client.model.response;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("simpleResponse")
public abstract class SimpleResponse implements Response {

    @Override
    public boolean isSystemIndent() {
        return false;
    }

    public abstract String fulfillmentText();
}
