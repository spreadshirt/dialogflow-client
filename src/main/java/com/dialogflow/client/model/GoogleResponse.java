package com.dialogflow.client.model;

import com.dialogflow.client.model.response.Response;
import com.dialogflow.client.model.response.Suggestion;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
}
