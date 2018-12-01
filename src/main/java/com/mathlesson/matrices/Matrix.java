package com.mathlesson.matrices;

import com.mathlesson.util.StandardOutputUtil;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    private int width;
    private int height;
    private List<List<Integer>> rows;

    Matrix() {
        width = 0;
        height = 0;
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

    public void insertRow(List<Integer> row) {
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

    public Matrix addToMatrix(Matrix otherMatrix) {
        Matrix sum = new Matrix();

        for (int x = 0; x < height; x++) {
            sum.insertRow(MatrixOperationUtil.addRowsTogether(rows.get(x), otherMatrix.getRowByIndex(x)));
        }

        return sum;
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

    String getFormattedRowStringByIndex(int rowIndex) {
        if (rows.size() == 0 && rowIndex == 0) {
            return "[ ]";
        }
        else {
            StringBuilder sb = new StringBuilder();

            List<Integer> row = rows.get(rowIndex);

            if (row.size() == 1) {
                sb.append("[ ")
                    .append(StandardOutputUtil.getLeadingSpaces(
                            getNumberOfDigitsInLongestNumber(),
                            String.valueOf(row.get(0)).length()))
                    .append(row.get(0))
                    .append(" ]");
            }
            else {
                sb.append("[ ");

                for (int columnIndex = 0; columnIndex < row.size(); columnIndex++) {
                    if (columnIndex == row.size() - 1) {
                        sb.append(StandardOutputUtil.getLeadingSpaces(
                                    getNumberOfDigitsInLongestNumber(),
                                    String.valueOf(row.get(columnIndex)).length()))
                            .append(row.get(columnIndex))
                            .append(" ]");
                    }
                    else {
                        sb.append(StandardOutputUtil.getLeadingSpaces(
                                    getNumberOfDigitsInLongestNumber(),
                                    String.valueOf(row.get(columnIndex)).length()))
                            .append(row.get(columnIndex))
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
                        = StandardOutputUtil.getNumberOfPaddingSpacesNeeded(
                            numberOfDigitsInLongestNumber, String.valueOf(item).length());

                    sb.append("[ ")
                        .append(StandardOutputUtil.getSpacesString(spacesToPrint))
                        .append(item)
                        .append(" ]\n");
                }

            }
            else {

                for (int printIndex = 0; printIndex < row.size(); printIndex++) {

                    if (printIndex == 0) {

                        sb.append("[ ")
                            .append(StandardOutputUtil.getLeadingSpaces(
                                    numberOfDigitsInLongestNumber,
                                    String.valueOf(row.get(printIndex)).length()))
                            .append(row.get(printIndex))
                            .append(", ");

                    }
                    else if (printIndex == (row.size() - 1)) {

                        sb.append(StandardOutputUtil.getLeadingSpaces(
                                    numberOfDigitsInLongestNumber,
                                    String.valueOf(row.get(printIndex)).length()))
                            .append(row.get(printIndex))
                            .append(" ]\n");

                    }
                    else {

                        sb.append(StandardOutputUtil.getLeadingSpaces(
                                    numberOfDigitsInLongestNumber,
                                    String.valueOf(row.get(printIndex)).length()))
                            .append(row.get(printIndex))
                            .append(", ");

                    }
                }
            }
        }
        return sb.toString();
    }

}
