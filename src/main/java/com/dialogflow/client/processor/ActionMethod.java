package com.dialogflow.client.processor;


import com.dialogflow.client.model.Conversation;
import com.dialogflow.client.model.WebhookRequest;

public interface ActionMethod {
    Conversation handle(WebhookRequest request);
}
