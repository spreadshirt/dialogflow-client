package com.dialogflow.client.model;


import com.dialogflow.client.model.response.*;
import com.dialogflow.client.model.response.card.BasicCard;

import java.util.Arrays;

public class Conversation {

    private final WebhookResponse webhookResponse;
    private final GoogleResponse googleResponse;

    private Conversation(String text, boolean expectUserInput) {
        this(new SimpleTextResponse(text), expectUserInput);
    }

    private Conversation(SimpleResponse response, boolean expectUserInput) {
        webhookResponse = new WebhookResponse();
        googleResponse = webhookResponse.googleResponse;
        webhookResponse.fulfillmentText = response.fulfillmentText();

        googleResponse.expectUserInput = expectUserInput;

        googleResponse.responses.add(response);
    }

    public Conversation resetUserStorage() {
        googleResponse.resetUserStorage = true;
        return this;
    }

    public WebhookResponse build() {
        return webhookResponse;
    }

    public static Conversation close(String text) {
        return new Conversation(text, false);
    }

    public static Conversation close(SimpleResponse response) {
        return new Conversation(response, false);
    }

    public static Conversation ask(String text) {
        return new Conversation(text, true);
    }

    public static Conversation ask(SimpleResponse response) {
        return new Conversation(response, true);
    }

    public Conversation add(Response... responses) {
        googleResponse.responses.addAll(Arrays.asList(responses));
        return this;
    }

    public Conversation suggest(String... suggestions) {
         return add(Arrays.stream(suggestions).map(Suggestion::new).toArray(Suggestion[]::new));
    }

    public Conversation card(BasicCard card) {
        return add(card);
    }

}
