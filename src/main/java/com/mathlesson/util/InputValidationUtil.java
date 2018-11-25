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
            if (!charIsANumber(c) && (c != ',')) {
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
            if (charIsANumber(inputCharArr[i])) {
                if (inputCharArr[i + 1] == ' ') {
                    int nextIndexToCheck = i + 2;
                    
                    while (inputCharArr[nextIndexToCheck] == ' ') {
                        nextIndexToCheck++;
                    }
                    
                    i = nextIndexToCheck;
                    
                    if (charIsANumber(inputCharArr[nextIndexToCheck])) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }

    private static boolean charIsANumber(char c) {
        return (c >= '0' && c <= '9');
    }
}
