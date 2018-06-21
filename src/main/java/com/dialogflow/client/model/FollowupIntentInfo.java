package com.dialogflow.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FollowupIntentInfo {

    @JsonProperty
    private String followupIntentName;

    @JsonProperty
    private String parentFollowupIntentName;


    public String getFollowupIntentName() {
        return followupIntentName;
    }

    public String getParentFollowupIntentName() {
        return parentFollowupIntentName;
    }

}
