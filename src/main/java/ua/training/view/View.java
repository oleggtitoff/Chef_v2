package ua.training.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    private static final String MESSAGES_BUNDLE_NAME = "messages";
    // English
    private static final Locale locale = new Locale("en", "US");
    // Ukrainian
    //private static final Locale locale = new Locale("uk", "UA");
    public static final ResourceBundle bundle = ResourceBundle.getBundle(
            MESSAGES_BUNDLE_NAME, locale);
}
