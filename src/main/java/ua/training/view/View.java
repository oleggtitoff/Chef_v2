package ua.training.view;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    private static final String MESSAGES_BUNDLE_NAME = "messages";
    // English
    private static final Locale locale = new Locale("en", "US");
    // Ukrainian
    //private static final Locale locale = new Locale("uk", "UA");
    private static final ResourceBundle bundle = ResourceBundle.getBundle(
            MESSAGES_BUNDLE_NAME, locale);

    public void printMessage (String message){
        System.out.println(message);
    }

    public String getBundleString(String message) {
        return bundle.getString(message);
    }

    public String concatenationString (String... messages){
        StringBuilder concatString = new StringBuilder();

        Arrays.stream(messages).forEach(concatString::append);
        return concatString.toString();
    }
}
