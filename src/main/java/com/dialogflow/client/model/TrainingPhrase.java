package com.dialogflow.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TrainingPhrase {

    /***
     * Required. The unique identifier of this training phrase.
     */
    @JsonProperty
    private String name;

    /***
     * Required. The type of the training phrase.
     */
    @JsonProperty
    private Type type;

    /***
     * Required. The collection of training phrase parts (can be annotated).
     * Fields: entityType, alias and userDefined should be populated only for the annotated parts of the training phrase.
     */
    @JsonProperty
    private List<Part> parts;

    @JsonProperty
    private Integer timesAddedCount;

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public List<Part> getParts() {
        return parts;
    }

    public Integer getTimesAddedCount() {
        return timesAddedCount;
    }
}
