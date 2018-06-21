package com.dialogflow.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class OriginalDetectIntentRequest {

    /***
     * The source of this request, e.g., google, facebook, slack. It is set by Dialogflow-owned servers.
     */
    @JsonProperty
    private String source;
    @JsonProperty
    private String version;
    /***
     * Optional. This field is set to the value of QueryParameters.payload field passed in the request.
     */
    @JsonProperty
    private GoogleOriginalDetectIntentRequestPayload payload;

    public String getSource() {
        return source;
    }

    public GoogleOriginalDetectIntentRequestPayload getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OriginalDetectIntentRequest{");
        sb.append("source='").append(source).append('\'');
        sb.append(", version='").append(version).append('\'');
        sb.append(", payload=").append(payload);
        sb.append('}');
        return sb.toString();
    }
}
