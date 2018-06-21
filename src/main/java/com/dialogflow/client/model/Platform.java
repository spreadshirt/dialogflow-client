package com.dialogflow.client.model;


import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum Platform {
    DEFAULT(null),
    GOOGLE("google"),
    FACEBOOK("facebook"),
    SLACK("slack"),
    TELEGRAM("telegram"),
    KIK("kik"),
    VIBER("viber"),
    SKYPE("skype"),
    LINE("line");

    private final String name;

    Platform(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    private static final Map<String, Platform> platformByName = new HashMap<>();

    static {
        for (Platform platform : values()) {
            String platformName = platform.getName();
            platformByName.put(platformName != null ? platformName.toLowerCase() : null, platform);
        }
    }

    public static Platform fromName(String name) {
        return platformByName.get(name != null ? name.toLowerCase() : null);
    }
}
