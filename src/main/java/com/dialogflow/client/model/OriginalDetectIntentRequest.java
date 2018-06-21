package com.dialogflow.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class OriginalDetectIntentRequest {

    /***
     * The source of this request, e.g., google, facebook, slack. It is set by Dialogflow-owned servers.
     */
    @JsonProperty
    private String source;

    /***
     * Optional. This field is set to the value of QueryParameters.payload field passed in the request.
     */
    private JsonNode payload;

    public String getSource() {
        return source;
    }

    public JsonNode getPayload() {
        return payload;
    }
}
