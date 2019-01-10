package com.dialogflow.client.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"type", "visualSelection"})
public class VisualSelectionResponse implements Response {

    @JsonProperty(value = "@type")
    private String type = "type.googleapis.com/google.actions.v2.OptionValueSpec";

    @JsonProperty(value = "listSelect") // FIXME: remove hardcoded name (there are other options e.g.: carouselSelect)
    private final Response visualSelection;

    @JsonIgnore
    public final String intent = "actions.intent.OPTION";

    public VisualSelectionResponse(Response visualSelection) {
        this.visualSelection = visualSelection;
    }

    @Override
    public boolean isSystemIndent() {
        return true;
    }

}
