package com.dialogflow.client.model;


import java.util.HashMap;

public class Session extends HashMap<String, Object> {

    private final String id;

    protected Session(String id) {

        this.id = id;
    }

    public String getId() {
        return id;
    }
}
