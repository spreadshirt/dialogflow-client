package com.dialogflow.client.model;

import com.dialogflow.client.model.WebhookRequest;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class GoogleWebhookTest {
    @Test
    public void testSimpleWebhookRequest() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("GoogleWebhookRequest.json")) {
            WebhookRequest webhookRequest = mapper.readValue(stream, WebhookRequest.class);
//            webhookRequest = webhookRequest;
            mapper.writeValue(System.out, webhookRequest);
//            System.out.println(mapper.);
        }


    }

}
