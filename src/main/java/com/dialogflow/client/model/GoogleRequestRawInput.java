package com.dialogflow.client.model;

public class GoogleRequestRawInput {

    private String query;
    private String inputType;

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public String getQuery() {

        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GoogleRequestRawInput{");
        sb.append("query='").append(query).append('\'');
        sb.append(", inputType='").append(inputType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
