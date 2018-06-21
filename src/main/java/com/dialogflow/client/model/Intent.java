package com.dialogflow.client.model;

import com.dialogflow.client.model.message.Message;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Intent {

    /***
     * Required for all methods except create (create populates the name automatically. The unique identifier of this intent. Format: projects/<Project ID>/agent/intents/<Intent ID>.
     */
    @JsonProperty
    private String name;

    /***
     * Required. The name of this intent.
     */
    @JsonProperty
    private String displayName;

    /***
     * Required. Indicates whether webhooks are enabled for the intent.
     */
    @JsonProperty
    private WebhookState webhookState;

    /***
     * Optional. The priority of this intent. Higher numbers represent higher priorities. Zero or negative numbers mean that the intent is disabled.
     */
    @JsonProperty
    private Integer priority;

    /***
     * Optional. Indicates whether this is a fallback intent.
     */
    @JsonProperty
    private Boolean isFallback;

    /***
     * Optional. Indicates whether Machine Learning is disabled for the intent. Note: If ml_diabled setting is set to true, then this intent is not taken into account during inference in ML ONLY match mode. Also, auto-markup in the UI is turned off.
     */
    @JsonProperty
    private Boolean mlDisabled;

    /***
     * Optional. The list of context names required for this intent to be triggered. Format: projects/<Project ID>/agent/sessions/-/contexts/<Context ID>.
     */
    @JsonProperty
    private List<String> inputContextNames;

    /***
     * Optional. The collection of event names that trigger the intent. If the collection of input contexts is not empty, all of the contexts must be present in the active user session for an event to trigger this intent.
     */
    @JsonProperty
    private List<String> events;

    /***
     * Optional. The collection of examples/templates that the agent is trained on.
     */
    @JsonProperty
    private List<TrainingPhrase> trainingPhrases;

    /***
     * Optional. The name of the action associated with the intent.
     */
    @JsonProperty
    private String action;

    /***
     * Optional. The collection of contexts that are activated when the intent is matched. Context messages in this collection should not set the parameters field. Setting the lifespanCount to 0 will reset the context when the intent is matched. Format: projects/<Project ID>/agent/sessions/-/contexts/<Context ID>.
     */
    @JsonProperty
    private List<Context> outputContexts;

    /***
     * Optional. Indicates whether to delete all contexts in the current session when this intent is matched.
     */
    @JsonProperty
    private Boolean resetContexts;

    /***
     * Optional. The collection of parameters associated with the intent.
     */
    @JsonProperty
    private List<Parameter> parameters;

    /***
     * Optional. The collection of rich messages corresponding to the Response field in the Dialogflow console.
     */
    @JsonProperty
    private List<Message> messages;


    /***
     * Optional. The list of platforms for which the first response will be taken from among the messages assigned to the DEFAULT_PLATFORM.
     */
    @JsonProperty
    private List<Platform> defaultResponsePlatforms;

    /***
     * The unique identifier of the root intent in the chain of followup intents. It identifies the correct followup intents chain for this intent. Format: projects/<Project ID>/agent/intents/<Intent ID>.
     */
    @JsonProperty
    private String rootFollowupIntentName;

    /***
     * The unique identifier of the parent intent in the chain of followup intents. It identifies the parent followup intent. Format: projects/<Project ID>/agent/intents/<Intent ID>.
     */
    @JsonProperty
    private String parentFollowupIntentName;

    /***
     * Optional. Collection of information about all followup intents that have name of this intent as a root_name.
     */
    @JsonProperty
    private List<FollowupIntentInfo> followupIntentInfo;

    //region getter

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public WebhookState getWebhookState() {
        return webhookState;
    }

    public Integer getPriority() {
        return priority;
    }

    public Boolean getFallback() {
        return isFallback;
    }

    public Boolean getMlDisabled() {
        return mlDisabled;
    }

    public List<String> getInputContextNames() {
        return inputContextNames;
    }

    public List<String> getEvents() {
        return events;
    }

    public List<TrainingPhrase> getTrainingPhrases() {
        return trainingPhrases;
    }

    public String getAction() {
        return action;
    }

    public List<Context> getOutputContexts() {
        return outputContexts;
    }

    public Boolean getResetContexts() {
        return resetContexts;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public List<Platform> getDefaultResponsePlatforms() {
        return defaultResponsePlatforms;
    }

    public String getRootFollowupIntentName() {
        return rootFollowupIntentName;
    }

    public String getParentFollowupIntentName() {
        return parentFollowupIntentName;
    }

    public List<FollowupIntentInfo> getFollowupIntentInfo() {
        return followupIntentInfo;
    }
    
    //endregion
}
