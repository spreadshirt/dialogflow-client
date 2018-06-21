package com.dialogflow.client.model.response;

public class ImageResponse implements Response {

    private final String imageUri;

    private final String accessibilityText;

    public ImageResponse(String imageUri, String accessibilityText) {
        this.imageUri = imageUri;
        this.accessibilityText = accessibilityText;
    }

    public String getImageUri() {
        return imageUri;
    }

    public String getAccessibilityText() {
        return accessibilityText;
    }

    @Override
    public boolean isSystemIndent() {
        return false;
    }
}
