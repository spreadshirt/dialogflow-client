package com.dialogflow.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class Context {

    /***
     * Required. The unique identifier of the context. Format: projects/<Project ID>/agent/sessions/<Session ID>/contexts/<Context ID>.
     */
    @JsonProperty
    private String name;

    /***
     * Optional. The number of conversational query requests after which the context expires. If set to 0 (the default) the context expires immediately. Contexts expire automatically after 10 minutes even if there are no matching queries.
     */
    @JsonProperty
    private Integer lifespanCount;

    /***
     * Optional. The collection of parameters associated with this context. Refer to this doc for syntax.
     */
    @JsonProperty
    private Map<String, String> parameters;

    public String getName() {
        return name;
    }

    public Integer getLifespanCount() {
        return lifespanCount;
    }

}
