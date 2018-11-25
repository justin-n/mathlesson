package com.mathlesson.matrices;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    private List<List<Integer>> rows;

    Matrix() {
        rows = new ArrayList<>();
    }

    public List<List<Integer>> getRows() {
        return rows;
    }

    public List<Integer> getRowByIndex(int index) {
        return rows.get(index);
    }

    public void addRow(List<Integer> row) {
        rows.add(row);
    }

    @Override
    public String toString() {

        int numberOfDigitsInLongestNumber = getNumberOfDigitsInLongestNumber();

        StringBuilder sb = new StringBuilder();

        for (List<Integer> row : rows) {
            for (int i = 0; i < row.size(); i++) {

                int spacesToPrint
                    = getNumberOfPaddingSpacesNeeded(
                    numberOfDigitsInLongestNumber, String.valueOf(row.get(i)).length());

                if (i == 0) {

                    sb.append("[ ")
                        .append(getSpacesString(spacesToPrint))
                        .append(row.get(i))
                        .append(", ");

                }
                else if (i == (row.size() - 1)) {

                    sb.append(getSpacesString(spacesToPrint))
                        .append(row.get(i))
                        .append(" ]\n");

                }
                else {

                    sb.append(getSpacesString(spacesToPrint))
                        .append(row.get(i))
                        .append(", ");

                }
            }
        }
        return sb.toString();
    }

    private int getNumberOfDigitsInLongestNumber() {

        int highestNumberOfDigits = 0;

        for (List<Integer> row : rows) {
            for (Integer item : row) {
                int numberOfDigits = String.valueOf(item).length();

                if (numberOfDigits > highestNumberOfDigits) {
                    highestNumberOfDigits = numberOfDigits;
                }
            }
        }

        return highestNumberOfDigits;
    }

    private int getNumberOfPaddingSpacesNeeded(int numberOfDigitsInLongestNumber, int numberOfDigitsInCurrentNumber) {
        return (numberOfDigitsInLongestNumber - numberOfDigitsInCurrentNumber);
    }

    private String getSpacesString(int spacesToPrint) {
        switch (spacesToPrint) {
            case 0:
                return "";
            case 1:
                return " ";
            case 2:
                return "  ";
            case 3:
                return "   ";
            case 4:
                return "    ";
            case 5:
                return "     ";
            case 6:
                return "      ";
            case 7:
                return "       ";
            case 8:
                return "        ";
            case 9:
                return "         ";
            case 10:
                return "          ";
            default:
                throw new RuntimeException("Attempted to return a space string of " + spacesToPrint +
                    " length, which means there is an item in the matrix that has a longer digit width than" +
                    " the digit width this program supports");
        }
    }
}
