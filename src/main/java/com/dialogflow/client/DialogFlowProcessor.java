package com.dialogflow.client;


import com.dialogflow.client.model.Conversation;
import com.dialogflow.client.model.WebhookRequest;
import com.dialogflow.client.model.WebhookResponse;
import com.dialogflow.client.processor.ActionMethod;
import com.dialogflow.client.processor.annotation.Action;
import com.dialogflow.client.processor.annotation.ActionHandler;
import com.dialogflow.client.processor.exception.ActionProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.reflections.Reflections;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

@SuppressWarnings({"UnusedReturnValue", "WeakerAccess"})
public class DialogFlowProcessor {

    private final HashMap<String, ActionMethod> actionHandlers = new HashMap<>();

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DialogFlowProcessor.class);

    public static DialogFlowProcessor scanPackages(String... packages) {

        DialogFlowProcessor dialogFlowProcessor = new DialogFlowProcessor();

        Arrays.stream(packages)
              .forEach(p -> {
                  Reflections reflections = new Reflections(p);

                  reflections.getTypesAnnotatedWith(ActionHandler.class)
                             .forEach(dialogFlowProcessor::addActionHandler);

              });

        return dialogFlowProcessor;
    }

    public DialogFlowProcessor addActionHandler(Class<?> actionHandlerClass) {
        try {
            log.info("Adding class '{}' as ActionHandler", actionHandlerClass.getCanonicalName());

            return addActionHandler(actionHandlerClass.getConstructor().newInstance());
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            log.error("Error creating instance of '{}'", actionHandlerClass.getCanonicalName(), e);
            throw new RuntimeException(e);
        }
    }

    public DialogFlowProcessor addActionHandler(Object actionHandler) {

        Method[] methods = actionHandler.getClass().getMethods();
        for (Method method : methods) {
            Action action = method.getAnnotation(Action.class);
            //noinspection ConstantConditions
            if (action != null && action.value() != null) {

                log.debug("Found annotated method '{}' in '{}' for action '{}'",
                        method.getName(), actionHandler.getClass().getSimpleName(), action.value());

                addActionHandler(action.value(), request -> {
                    try {

                        Object response;
                        if (method.getParameterCount() == 0) {
                            response = method.invoke(actionHandler);
                        } else {
                            response = method.invoke(actionHandler, request);
                        }

                        return (Conversation) response;

                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }

        return this;

    }

    public DialogFlowProcessor addActionHandler(String action, ActionMethod handler) {

        log.info("Register handler method for action '{}'", action);
        actionHandlers.put(action, handler);

        return this;
    }

    public WebhookResponse handleRequest(String body) throws ActionProcessingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        WebhookRequest request = objectMapper.readValue(body, WebhookRequest.class);

        return handleRequest(request);

    }

    public WebhookResponse handleRequest(WebhookRequest request) throws ActionProcessingException {

        String actionName = request.getQueryResult().getAction();

        if (!actionHandlers.containsKey(actionName)) {
            throw new ActionProcessingException(
                    String.format("No registered handler for action '%s' found", actionName), actionName, request);
        }

        Conversation conversation = actionHandlers.get(actionName).handle(request);

        if (conversation == null) {
            throw new ActionProcessingException(
                    String.format("No conversation for action '%s'", actionName), actionName, request);
        }


        return conversation.build();

    }


}
