package com.dialogflow.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;

/**
 * @author tony
 */
public class QueryResult {

    /***
     * The original conversational query text:
     * - If natural language text was provided as input, queryText contains a copy of the input.
     * - If natural language speech audio was provided as input, queryText contains the speech recognition result.
     *   If speech recognizer produced multiple alternatives, a particular one is picked.
     * - If an event was provided as input, queryText is not set.
     */
    @JsonProperty
    private String queryText;

    /***
     * The language that was triggered during intent detection. See Language Support for a list of the currently supported language codes.
     */
    @JsonProperty
    private String languageCode;

    /***
     * The Speech recognition confidence between 0.0 and 1.0. A higher number indicates an estimated greater
     * likelihood that the recognized words are correct. The default of 0.0 is a sentinel value indicating that
     * confidence was not set.
     *
     * This field is not guaranteed to be accurate or set. In particular this field isn't set for
     * StreamingDetectIntent since the streaming endpoint has separate confidence estimates per portion of the audio
     * in StreamingRecognitionResult.
     */
    @JsonProperty
    private Float speechRecognitionConfidence;

    /***
     * The action name from the matched intent.
     */
    @JsonProperty
    private String action;

    private HashMap<String, String> parameters;

    /***
     * This field is set to: - false if the matched intent has required parameters and not all of the required
     * parameter values have been collected.
     * - true if all required parameter values have been collected, or if the matched intent doesn't contain any required parameters.
     */
    @JsonProperty
    private boolean allRequiredParamsPresent;

    /***
     * The text to be pronounced to the user or shown on the screen.
     */
    @JsonProperty
    private String fulfillmentText;

//
//    /***
//     * The collection of rich messages to present to the user.
//     */
//    @JsonProperty
//    @JsonDeserialize(using = CustomerDesierualier.class)
//
//    private List<Message> fulfillmentMessages;

    /***
     * If the query was fulfilled by a webhook call, this field is set to the value of the source field returned in the webhook response.
     */
    @JsonProperty
    private String webhookSource;

    /***
     * The collection of output contexts. If applicable, outputContexts.parameters contains entries with
     * ame <parameter name>.original containing the original parameter values before the query.
     */
    @JsonProperty
    private List<Context> outputContexts;

    @JsonProperty
    private Intent intent;

    /***
     * The intent detection confidence. Values range from 0.0 (completely uncertain) to 1.0 (completely certain).
     */
    @JsonProperty
    private Float intentDetectionConfidence;

    //region getter

    public String getQueryText() {
        return queryText;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public Float getSpeechRecognitionConfidence() {
        return speechRecognitionConfidence;
    }

    public String getAction() {
        return action;
    }

    public HashMap<String, String> getParameters() {
        return parameters;
    }

    public boolean isAllRequiredParamsPresent() {
        return allRequiredParamsPresent;
    }

    public String getFulfillmentText() {
        return fulfillmentText;
    }

    public String getWebhookSource() {
        return webhookSource;
    }

    public List<Context> getOutputContexts() {
        return outputContexts;
    }

    public Intent getIntent() {
        return intent;
    }

    public Float getIntentDetectionConfidence() {
        return intentDetectionConfidence;
    }

    //endregion
}
