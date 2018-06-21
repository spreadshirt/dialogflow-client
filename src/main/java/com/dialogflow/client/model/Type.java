package com.dialogflow.client.model;

public enum Type {

    /***
     * Not specified. This value should never be used.
     */
    TYPE_UNSPECIFIED,

    /***
     * Examples do not contain @-prefixed entity type names, but example parts can be annotated with entity types.
     */
    EXAMPLE,

    /***
     * Templates are not annotated with entity types, but they can contain @-prefixed entity type names as substrings.
     */
    TEMPLATE
}
