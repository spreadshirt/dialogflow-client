package com.dialogflow.client.model;

import java.util.List;

public class GoogleRequestConversation {

    private String conversationId;
    // TODO - enum
    private String type;
    private String conversationToken;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConversationToken() {
        return conversationToken;
    }

    public void setConversationToken(String conversationToken) {
        this.conversationToken = conversationToken;
    }

    public String getConversationId() {

        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GoogleRequestConversation{");
        sb.append("conversationId='").append(conversationId).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", conversationToken='").append(conversationToken).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
