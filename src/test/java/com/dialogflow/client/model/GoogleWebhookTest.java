package com.dialogflow.client.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class GoogleWebhookTest {
    @Test
    public void testSimpleWebhookRequest() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("WebhookRequest.json")) {
            WebhookRequest webhookRequest = mapper.readValue(stream, WebhookRequest.class);
            mapper.writeValue(System.out, webhookRequest);
        }


    }

}
