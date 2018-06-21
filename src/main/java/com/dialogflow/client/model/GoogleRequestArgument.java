package com.dialogflow.client.model;

public class GoogleRequestArgument {

    private String rawText;
    private String textValue;
    private String name;

    public String getRawText() {
        return rawText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GoogleRequestArgument{");
        sb.append("rawText='").append(rawText).append('\'');
        sb.append(", textValue='").append(textValue).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
