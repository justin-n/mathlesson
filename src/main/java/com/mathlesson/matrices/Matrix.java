package com.mathlesson.matrices;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    private int width;
    private int height;
    private List<List<Integer>> rows;

    Matrix() {
        rows = new ArrayList<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<List<Integer>> getRows() {
        return rows;
    }

    public List<Integer> getRowByIndex(int index) {
        return rows.get(index);
    }

    public void addRow(List<Integer> row) {
        if (rows.size() == 0) {
            rows.add(row);
            width = row.size();
            height = 1;
        } else {
            if (row.size() != width) {
                System.err.println(
                    "Unable to add row, width of row: " + row.size() + " is not the width of the matrix: " + width);
                System.out.println();
            } else {
                rows.add(row);
                height++;
            }
        }
    }

    int getNumberOfDigitsInLongestNumber() {

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

    String getFormattedRowStringByIndex(int rowIndex) {
        if (rows.size() == 0 && rowIndex == 0) {
            return "[ ]";
        }
        else {
            StringBuilder sb = new StringBuilder();

            List<Integer> row = rows.get(rowIndex);

            if (row.size() == 1) {
                sb.append("[ ")
                    .append(getNumberOfPaddingSpacesNeeded(
                        getNumberOfDigitsInLongestNumber(), row.get(0)))
                    .append(" ]");
            }
            else {
                sb.append("[ ");

                for (int columnIndex = 0; columnIndex < row.size(); columnIndex++) {
                    if (columnIndex == row.size() - 1) {
                        sb.append(getNumberOfPaddingSpacesNeeded(
                                getNumberOfDigitsInLongestNumber(), row.get(columnIndex)))
                            .append(" ]");
                    }
                    else {
                        sb.append(getNumberOfPaddingSpacesNeeded(
                                getNumberOfDigitsInLongestNumber(), row.get(columnIndex)))
                            .append(", ");
                    }
                }
            }

            return sb.toString();
        }
    }

    @Override
    public String toString() {

        if (rows.size() == 0) {
            return "[ ]\n";
        }

        int numberOfDigitsInLongestNumber = getNumberOfDigitsInLongestNumber();

        StringBuilder sb = new StringBuilder();

        for (List<Integer> row : rows) {

            if (width == 1) {
                for (Integer item : row) {
                    int spacesToPrint
                        = getNumberOfPaddingSpacesNeeded(
                            numberOfDigitsInLongestNumber, String.valueOf(item).length());

                    sb.append("[ ")
                        .append(getSpacesString(spacesToPrint))
                        .append(item)
                        .append(" ]\n");
                }

            }
            else {

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
        }
        return sb.toString();
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
