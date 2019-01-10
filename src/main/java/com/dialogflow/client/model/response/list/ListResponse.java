package com.dialogflow.client.model.response.list;

import com.dialogflow.client.model.response.Response;
import com.dialogflow.client.model.response.card.ListItemResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("listSelect")
@JsonPropertyOrder({"title", "items"})
public class ListResponse implements Response {

    @JsonProperty
    private String title;

    @JsonProperty
    private ListItemResponse[] items;

    public ListResponse withTitle(String title) {
        this.title = title;
        return this;
    }

    public ListResponse withItems(ListItemResponse... items) {
        this.items = items;
        return this;
    }

    @Override
    public boolean isSystemIndent() {
        return false;
    }
}
