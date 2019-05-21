package com.epam.training.toto.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FormatCheckService {

    public String DATE_FORMAT = "yyyy.MM.dd";

    static int formatPriceValue(String priceValue) {
        return Integer.parseInt(priceValue.replaceAll("\\D", ""));
    }

    public boolean isLastGameDataCorrect(String dataString) {
        return dataString.replaceAll("(\\+X|\\+\\d)", "").isEmpty();
    }

    public boolean isDataCorrect(String dataString) {
        return dataString.replaceAll("(X|\\d)", "").isEmpty();
    }

    public String formatLastRoundValue(String dataString) {
        return dataString.replaceAll("([^\\+X|\\+\\d])", "").toUpperCase();
    }

    public String formatValue(String dataString) {
        return dataString.replaceAll("([^X|\\d])", "").toUpperCase();
    }

    public boolean validateDateFormat(String dateToValidate) {
        if (dateToValidate == null) {
            return false;
        }
        try {
            LocalDate.parse(dateToValidate, DateTimeFormatter.ofPattern(DATE_FORMAT));
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
