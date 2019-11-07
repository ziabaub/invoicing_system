package accounter.backend.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DataValidator {

    private static final String NUM_PATTERN = "-?\\d+(\\.\\d+)?";
    private static final String NAME_PATTERN = "[A-Za-z0-9]+";
    private static final String EMAIL_PATTERN = "[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})";


    public static boolean checkData(String num, String quantity, String unPrice) {
        if (!matchPattern(num, NAME_PATTERN)) {
            return false;
        }
        if (!matchPattern(quantity, NUM_PATTERN)) {
            return false;
        }
        return matchPattern(unPrice, NUM_PATTERN);
    }

    public static boolean isNumeric(String text){
        return text.matches(NUM_PATTERN);
    }

    private static boolean matchPattern(String data, String currentPattern) {
        Pattern pattern = Pattern.compile(currentPattern);
        Matcher matcher = pattern.matcher(data);

        return matcher.matches();
    }

}