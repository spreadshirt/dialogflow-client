package com.dialogflow.client.model;

import com.dialogflow.client.EventInput;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WebhookResponse {

    @JsonProperty
    String fulfillmentText;

    @JsonProperty
    HashMap<String, Object> payload = new HashMap<>();

    @JsonProperty
    List<Context> outputContexts = new ArrayList<>();

    @JsonProperty
    EventInput followupEventInput;

    @JsonIgnore
    final
    GoogleResponse googleResponse;


    public WebhookResponse() {
        googleResponse = new GoogleResponse();
        payload.put("google", googleResponse);
    }
}
