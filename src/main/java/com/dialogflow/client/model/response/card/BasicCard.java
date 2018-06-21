package com.dialogflow.client.model.response.card;

import com.dialogflow.client.model.response.Response;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;

@JsonTypeName("basicCard")
public class BasicCard implements Response {

    @JsonProperty
    private String title;

    @JsonProperty
    private String subtitle;

    @JsonProperty
    private String formattedText;

    @JsonProperty
    private Image image;

    @JsonProperty
    private ImageDisplayOptions imageDisplayOptions;

    @JsonProperty
    private List<Button> buttons;

    public BasicCard() {
    }

    public BasicCard withTitle(String title) {
        this.title = title;
        return this;
    }

    public BasicCard withSubtitle(String subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    public BasicCard withFormattedText(String formattedText) {
        this.formattedText = formattedText;
        return this;
    }

    public BasicCard withImage(Image image, ImageDisplayOptions imageDisplayOptions) {
        this.imageDisplayOptions = imageDisplayOptions;
        return withImage(image);
    }

    public BasicCard withImage(Image image) {
        this.image = image;
        return this;
    }

    public BasicCard withImage(String url, String accessibilityText) {
        return withImage(new Image(url, accessibilityText));
    }

    public BasicCard withButton(Button button) {

        if (this.buttons == null) {
            this.buttons = new ArrayList<>();
        }

        this.buttons.clear();
        this.buttons.add(button);

        return this;
    }

    public BasicCard withButton(String title, String url) {
        return withButton(new Button(title, url));
    }


    @Override
    public boolean isSystemIndent() {
        return false;
    }

    public enum ImageDisplayOptions {
        /***
         * Fill the gaps between the image and the image container with gray bars.
         */
        DEFAULT,

        /***
         * Fill the gaps between the image and the image container with white bars.
         */
        WHITE,

        /***
         * Image is scaled such that the image width and height match or exceed the container dimensions.
         * This may crop the top and bottom of the image if the scaled image height is greater than the container
         * height, or crop the left and right of the image if the scaled image width is greater than the container width.
         * This is similar to "Zoom Mode" on a widescreen TV when playing a 4:3 video.
         */
        CROPPED
    }

    public enum UrlTypeHint {
        /***
         * Unspecified
         */
        URL_TYPE_HINT_UNSPECIFIED,

        /***
         * URL that points directly to AMP content, or to a canonical URL which refers to AMP content via .
         */
        AMP_CONTENT
    }

    public static class Image {

        /***
         * The source url of the image. Images can be JPG, PNG and GIF (animated and non-animated). For example
         */
        @JsonProperty
        private final String url;

        /***
         * A text description of the image to be used for accessibility, e.g. screen readers.
         */
        @JsonProperty
        private final String accessibilityText;

        @JsonProperty
        private Integer width;

        @JsonProperty
        private Integer height;

        public Image(String url, String accessibilityText) {
            this.url = url;
            this.accessibilityText = accessibilityText;
        }

        public Image(String url, String accessibilityText, Integer width, Integer height) {
            this(url, accessibilityText);

            this.width = width;
            this.height = height;
        }


    }

    public static class Button {

        @JsonProperty
        private final String title;

        @JsonProperty
        private final OpenUrlAction openUrlAction;

        public Button(String title, OpenUrlAction openUrlAction) {
            this.title = title;
            this.openUrlAction = openUrlAction;
        }

        public Button(String title, String url) {
            this(title, new OpenUrlAction(url));
        }
    }

    public static class OpenUrlAction {

        @JsonProperty
        private final String url;

        @JsonProperty
        private UrlTypeHint urlTypeHint;

        // TODO: androidApp, see https://developers.google.com/actions/reference/rest/Shared.Types/OpenUrlAction

        public OpenUrlAction(String url) {
            this.url = url;
        }

        public OpenUrlAction(String url, UrlTypeHint urlTypeHint) {
            this(url);
            this.urlTypeHint = urlTypeHint;
        }
    }

}
