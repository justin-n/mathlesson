package com.mathlesson.util;

public class InputValidationUtil {

    public static boolean stringContainsSpaces(String input) {
        return input.split(" ").length > 1;
    }

    public static boolean stringContainsOnlyNumbers(String input) {
        for (char c : input.toCharArray()) {
            if (!charIsANumber(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean stringContainsOnlyNumbersAndCommas(String input) {
        for (char c : input.toCharArray()) {
            if (!charIsANumber(c) || !(c == ',')) {
                return false;
            }
        }
        return true;
    }

    private static boolean charIsANumber(char c) {
        return (c >= '0' && c <= '9');
    }
}
