package com.dialogflow.client.processor.exception;

import com.dialogflow.client.model.WebhookRequest;

public class ActionProcessingException extends Exception {

    private final String actionName;
    private final WebhookRequest request;

    public ActionProcessingException(String message, String actionName, WebhookRequest request) {
        super(message);

        this.actionName = actionName;
        this.request = request;
    }

    public String getActionName() {
        return actionName;
    }

    public WebhookRequest getRequest() {
        return request;
    }
}
