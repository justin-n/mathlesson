package com.mathlesson.util;

public class InputValidationUtil {

    public static boolean validateMenuChoiceInput(String input) {

        if (InputValidationUtil.stringContainsSpaces(input)) {
            System.out.println("Please exclude spaces in menu selection");
            return false;
        }

        if (!InputValidationUtil.stringContainsOnlyNumbers(input)) {
            System.out.println("Please only include numbers in menu selection");
            return false;
        }

        return true;
    }

    public static boolean validateCommaSeparatedRowInput(String input) {

        if (InputValidationUtil.stringContainsSpacesBetweenNumbers(input)) {
            System.out.println("Please do not include spaces between numbers");
            return false;
        }

        String inputWithoutWhitespace = input.replaceAll("\\s", "");

        if (!InputValidationUtil.stringContainsOnlyNumbersAndCommas(inputWithoutWhitespace)) {
            System.out.println("Please only include numbers and commas");
            return false;
        }

        if (InputValidationUtil.stringContainsConsecutiveCommas(input)) {
            System.out.println("Please do not include consecutive commas");
            return false;
        }

        return true;
    }

    public static boolean stringContainsSpaces(String input) {
        return input.split(" ").length > 1;
    }

    public static boolean stringContainsOnlyNumbers(String input) {
        for (char c : input.toCharArray()) {
            if (!charIsADigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean stringContainsOnlyNumbersAndCommas(String input) {
        for (char c : input.toCharArray()) {
            if (!charIsADigit(c) && (c != ',')) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean stringContainsConsecutiveCommas(String input) {

        char[] inputCharArr = input.toCharArray();
        
        for (int i = 0; i < inputCharArr.length - 2; i++) {
            if (inputCharArr[i] == ',') {
                if (inputCharArr[i + 1] == ',') {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static boolean stringContainsSpacesBetweenNumbers(String input) {
        
        char[] inputCharArr = input.toCharArray();
        
        for (int i = 0; i < inputCharArr.length - 3; i++) {
            if (charIsADigit(inputCharArr[i])) {
                if (inputCharArr[i + 1] == ' ') {
                    int nextIndexToCheck = i + 2;
                    
                    while (inputCharArr[nextIndexToCheck] == ' ') {
                        nextIndexToCheck++;
                    }
                    
                    i = nextIndexToCheck;
                    
                    if (charIsADigit(inputCharArr[nextIndexToCheck])) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }

    private static boolean charIsADigit(char c) {
        return (c >= '0' && c <= '9');
    }
}
