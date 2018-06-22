# DialogFlow Client

A java [dialogflow](https://dialogflow.com) client and processing framework for creating conversions with the 
google assistant.

* Serialization / Deserialization of Webhook Requests and Responses in API Version 2.
* Nice api to define conversation with support of
    * Ssml
    * Text
    * Suggestion chips
    * BasicCards
* Processing framework with annotations clear code separation

# Usage

## Configure the DialogFlowProcessor

Create a DialogFlowProcessor by scanning packages and automatically adding all classes annotated with `@ActionHandler`.
 
```java
DialogFlowProcessor processor = DialogFlowProcessor.scanPackages("my.package", "some.other.package");
```

An ActionHandler contains a list of methods annotated with `@Action("name")`, where the value of the 
annotation matches the action it handles.

The signature of such a method returns a `Conversation` and can optionally take the `WebhookRequest` as 
a parameter.

```java
@ActionHandler
class ExampleActionHandler {

    @Action("fun.cat")
    public Conversation withRequest(WebhookRequest request) {
    	...
    }

    @Action("fun.stop")
    public Conversation withoutRequest() {
    	...
    }
}
```

The processor can also be created manually without scanning packages and ActionHandlers can be added 
manually.

```java
DialogFlowProcessor processor = new DialogFlowProcessor();

// by providing a class
processor.addActionHandler(ExampleActionHandler.class);

// by providing an instance
processor.addActionHandler(new ExampleActionHandler());
```

It's also possible to dynamically add `ActionMethod` at runtime.

```java
processor.addActionHandler("ActionName", new ActionMethod() {
    @Override
    public Conversation handle(WebhookRequest request) {
        // do something with action "ActionName"
    }
});

processor.addActionHandler("Lambda", request -> Conversation.ask("ok"));
```

## Processesing request

The spring way with auto mapping json via jackson.

```java
@RestController
public class WebhookController {

    @Autowired private DialogFlowProcessor dialogFlowProcessor;

    @PostMapping(path = "/webhook")
    public WebhookResponse handleAction(@RequestBody WebhookRequest request) {
        try {
            return dialogFlowProcessor.handleRequest(request);
        } catch (ActionProcessingException e) {
            return Conversation.close("Some error").build();
        }
    }
}
```

Framework independent way

```java
WebhookResponse response = null;
try {
     response = processor.handleRequest(json);
} catch (ActionProcessingException e) {
    // processing went wrong, e.g. action not found 
    response = Conversation.close("Some error").build(); 
}
    
// serialize response to json and send it back
```

## Conversations

Conversations can be respond to in a two ways:

* `Conversation.ask` - let's the microphone open, so that the user can respond immediately
* `Conversation.close` - closes the microphone and ends the conversation

Every conversation needs to respond with at least one text that is speaken and/or shown to the user.

* `Conversation.ask("Some text")` - the text is spoken and shown to the user.
* `Conversation.ask(new SimpleTextResponse("speech", "write"))` - different text is spoken then displayed
* `Conversation.ask(new SimpleSsmlResponse(ssml, "text to display"))` - audio is composed by [SSML](https://developers.google.com/actions/reference/ssml);

Next to the text and audio response, conversations can have more rich responses, like

### Suggestion chips

[Suggestion chips](https://developers.google.com/actions/assistant/responses#suggestion_chip) are small bubbles at the end of the conversation in the chat, for easy responses when working a device with a surface.

```java
Conversation.ask("Which do you like more?")
            .suggest("Foo", "Bar");
```

# License

This project is licensed under the [MIT License](LICENSE.md).