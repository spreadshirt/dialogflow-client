package com.dialogflow.client.model.message;


import com.dialogflow.client.model.Platform;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.WRAPPER_OBJECT,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextMessage.class, name = "text"),
        @JsonSubTypes.Type(value = ImageMessage.class, name = "image")
})
public abstract class Message {

    /***
     * Optional. The platform that this message is intended for.
     */
    @JsonProperty
    private Platform platform;

    @JsonProperty
    private String type;

    public Platform getPlatform() {
        return platform;
    }
}
