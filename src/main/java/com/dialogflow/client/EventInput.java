package com.dialogflow.client;


import com.fasterxml.jackson.annotation.JsonProperty;

public class EventInput {

    /***
     * Required. The unique identifier of the event.
     */
    @JsonProperty
    private String name;

    /***
     * Required. The language of this query. See Language Support for a list of the currently supported language codes. Note that queries in the same session do not necessarily need to specify the same language.
     */
    @JsonProperty
    private String languageCode;
}
