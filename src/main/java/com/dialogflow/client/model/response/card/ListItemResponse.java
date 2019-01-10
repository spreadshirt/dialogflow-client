package com.dialogflow.client.model.response.card;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListItemResponse {

    @JsonProperty
    private String title;

    @JsonProperty
    private String description;

    @JsonProperty
    private Image image;

    @JsonProperty
    private OptionInfo optionInfo;

    public ListItemResponse withTitle(String title) {
        this.title = title;
        return this;
    }

    public ListItemResponse withDescription(String description) {
        this.description = description;
        return this;
    }

    public ListItemResponse withImage(Image image) {
        this.image = image;
        return this;
    }

    public ListItemResponse withOptionInfo(OptionInfo optionInfo) {
        this.optionInfo = optionInfo;
        return this;
    }

    public static class Image {

        @JsonProperty
        private String url;

        @JsonProperty
        private String accessibilityText;

        public Image withUrl(String url) {
            this.url = url;
            return this;
        }

        public Image withAccessibilityText(String accessibilityText) {
            this.accessibilityText = accessibilityText;
            return this;
        }

    }

    public static class OptionInfo {

        @JsonProperty
        private String key;

        @JsonProperty
        private String[] synonyms;

        public OptionInfo withKey(String key) {
            this.key = key;
            return this;
        }

        public OptionInfo withSynonyms(String... synonyms) {
            this.synonyms = synonyms;
            return this;
        }

    }

}
