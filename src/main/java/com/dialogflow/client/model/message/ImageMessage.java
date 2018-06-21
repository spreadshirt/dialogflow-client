package com.dialogflow.client.model.message;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageMessage extends Message {

    @JsonProperty
    private String imageUri;

    @JsonProperty
    private String accessibilityText;

    public String getImageUri() {
        return imageUri;
    }

    public String getAccessibilityText() {
        return accessibilityText;
    }
}
