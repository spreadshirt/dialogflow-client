package com.dialogflow.client.model;

import java.util.List;

public class GoogleRequestInput {

    private List<GoogleRequestRawInput> rawInputs;
    private List<GoogleRequestArgument> arguments;
    private String intent;

    public List<GoogleRequestRawInput> getRawInputs() {
        return rawInputs;
    }

    public void setRawInputs(List<GoogleRequestRawInput> rawInputs) {
        this.rawInputs = rawInputs;
    }

    public List<GoogleRequestArgument> getArguments() {
        return arguments;
    }

    public void setArguments(List<GoogleRequestArgument> arguments) {
        this.arguments = arguments;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GoogleRequestInput{");
        sb.append("rawInputs=").append(rawInputs);
        sb.append(", arguments=").append(arguments);
        sb.append(", intent='").append(intent).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
