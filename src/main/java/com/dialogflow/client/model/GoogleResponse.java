package com.dialogflow.client.model;

import com.dialogflow.client.model.response.Response;
import com.dialogflow.client.model.response.Suggestion;
import com.dialogflow.client.model.response.VisualSelectionResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GoogleResponse {

    @JsonProperty
    boolean expectUserInput;

    @JsonProperty
    Boolean resetUserStorage;

    @JsonIgnore
    final
    List<Response> responses = new ArrayList<>();

    @JsonProperty
    private RichResponse richResponse() {

        if (!expectUserInput) {
            return null;
        }

        return new RichResponse();

    }

    @JsonProperty
    private SystemIntent systemIntent() {

        boolean hasSystemIndent = responses.stream().anyMatch(Response::isSystemIndent);
        if (!hasSystemIndent) {
            return null;
        }

        return new SystemIntent();

    }

    private class RichResponse {

        @JsonProperty
        @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT, property = "type")
        public List<Response> items() {
            return responses.stream()
                    .filter(r -> !r.isSystemIndent())
                    .filter(r -> !(r instanceof Suggestion))
                    .collect(Collectors.toList());
        }

        @JsonProperty
        public List<Response> suggestions() {
            return responses.stream().filter(r -> r instanceof Suggestion).collect(Collectors.toList());
        }

    }

    @JsonPropertyOrder({"intent", "data"})
    private class SystemIntent {

        @JsonProperty
        private String intent() {
            VisualSelectionResponse response = (VisualSelectionResponse) responses.stream()
                    .filter(VisualSelectionResponse.class::isInstance)
                    .findFirst().orElse(null);

            if (response == null) {
                return null;
            }

            return response.intent;
        }

        @JsonProperty
        private Response data() {
            return responses.stream()
                    .filter(VisualSelectionResponse.class::isInstance)
                    .findFirst().orElse(null);
        }
    }
}
