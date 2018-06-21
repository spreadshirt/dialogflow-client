package com.dialogflow.client.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class WebhookRequest {

    /***
     * The unique identifier of detectIntent request session. Can be used to identify end-user inside webhook implementation. Format: projects/<Project ID>/agent/sessions/<Session ID>.
     */
    @JsonProperty
    private String session;

    /***
     * The unique identifier of the response. Contains the same value as [Streaming]DetectIntentResponse.response_id.
     */
    @JsonProperty
    private UUID responseId;


    /***
     * The result of the conversational query or event processing. Contains the same value as [Streaming]DetectIntentResponse.query_result.
     */
    @JsonProperty
    private QueryResult queryResult;

    /***
     * Optional. The contents of the original request that was passed to [Streaming]sessions.detectIntent call.
     */
    @JsonProperty
    private OriginalDetectIntentRequest originalDetectIntentRequest;

    public String getSession() {
        return session;
    }

    public UUID getResponseId() {
        return responseId;
    }

    public QueryResult getQueryResult() {
        return queryResult;
    }

    public OriginalDetectIntentRequest getOriginalDetectIntentRequest() {
        return originalDetectIntentRequest;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WebhookRequest{");
        sb.append("session='").append(session).append('\'');
        sb.append(", responseId=").append(responseId);
        sb.append(", queryResult=").append(queryResult);
        sb.append(", originalDetectIntentRequest=").append(originalDetectIntentRequest);
        sb.append('}');
        return sb.toString();
    }
}
