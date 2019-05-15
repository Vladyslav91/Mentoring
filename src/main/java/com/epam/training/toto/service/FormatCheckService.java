package com.epam.training.toto.service;

public class FormatCheckService {

    static int formatPriceValue(String priceValue) {
        return Integer.parseInt(priceValue.replaceAll("\\D", ""));
    }

    public static boolean isLastGameDataCorrect(String dataString) {
        return dataString.replaceAll("(\\+X|\\+\\d)", "").isEmpty();
    }

    public static boolean isDataCorrect(String dataString) {
        return dataString.replaceAll("(X|\\d)", "").isEmpty();
    }

    public static String formatLastRoundValue(String dataString) {
        return dataString.replaceAll("([^\\+X|\\+\\d])", "").toUpperCase();
    }

    public static String formatValue(String dataString) {
        return dataString.replaceAll("([^X|\\d])", "").toUpperCase();
    }
}
