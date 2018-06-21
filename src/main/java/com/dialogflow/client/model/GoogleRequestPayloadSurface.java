package com.dialogflow.client.model;

import java.util.List;

public class GoogleRequestPayloadSurface {
    private List<Capability> capabilities;

    public List<Capability> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(List<Capability> capabilities) {
        this.capabilities = capabilities;
    }
}
