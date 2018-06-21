package com.dialogflow.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GoogleOriginalDetectIntentRequestPayload {
    @JsonProperty
    private GoogleRequestPayloadSurface surface;
    @JsonProperty("isInSandbox")
    private boolean inSandbox;
    @JsonProperty
    private List<GoogleRequestInput> inputs;
    @JsonProperty
    private GoogleRequestUser user;
    @JsonProperty
    private GoogleRequestConversation conversation;
    @JsonProperty
    private String version;


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public GoogleRequestPayloadSurface getSurface() {
        return surface;
    }

    public void setSurface(GoogleRequestPayloadSurface surface) {
        this.surface = surface;
    }

    public boolean isInSandbox() {
        return inSandbox;
    }

    public void setInSandbox(boolean inSandbox) {
        this.inSandbox = inSandbox;
    }

    public List<GoogleRequestInput> getInputs() {
        return inputs;
    }

    public void setInputs(List<GoogleRequestInput> inputs) {
        this.inputs = inputs;
    }

    public GoogleRequestUser getUser() {
        return user;
    }

    public void setUser(GoogleRequestUser user) {
        this.user = user;
    }

    public GoogleRequestConversation getConversation() {
        return conversation;
    }

    public void setConversation(GoogleRequestConversation conversation) {
        this.conversation = conversation;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GoogleOriginalDetectIntentRequestPayload{");
        sb.append("surface=").append(surface);
        sb.append(", inSandbox=").append(inSandbox);
        sb.append(", inputs=").append(inputs);
        sb.append(", user=").append(user);
        sb.append(", conversation=").append(conversation);
        sb.append(", version='").append(version).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
