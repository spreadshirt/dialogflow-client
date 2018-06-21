package com.dialogflow.client.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface Response {

    @JsonIgnore
    boolean isSystemIndent();
}
