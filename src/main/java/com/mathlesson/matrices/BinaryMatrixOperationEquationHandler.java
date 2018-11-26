package com.mathlesson.matrices;

import com.mathlesson.util.StandardOutputUtil;

public class BinaryMatrixOperationEquationHandler {

    private Matrix firstMatrix;
    private Matrix secondMatrix;
    private Matrix resultMatrix;

    BinaryMatrixOperationEquationHandler() {
        firstMatrix = new Matrix();
        secondMatrix = new Matrix();
        resultMatrix = new Matrix();
    }

    public Matrix getFirstMatrix() {
        return firstMatrix;
    }

    public void setFirstMatrix(Matrix firstMatrix) {
        this.firstMatrix = firstMatrix;
    }

    public Matrix getSecondMatrix() {
        return secondMatrix;
    }

    public void setSecondMatrix(Matrix secondMatrix) {
        this.secondMatrix = secondMatrix;
    }

    public Matrix getResultMatrix() {
        return resultMatrix;
    }

    public void setResultMatrix(Matrix resultMatrix) {
        this.resultMatrix = resultMatrix;
    }

    public void printOperands() {

        int firstMatrixHeight = firstMatrix.getHeight();
        int secondMatrixHeight = secondMatrix.getHeight();

        int heightOfHighestMatrix =
            (firstMatrixHeight > secondMatrixHeight ? firstMatrixHeight : secondMatrixHeight);

        StringBuilder sb = new StringBuilder();

        int widthOfFirstMatrixRowString = firstMatrix.getFormattedRowStringByIndex(0).length();

        for (int printIndex = 0; printIndex < heightOfHighestMatrix || printIndex == 0; printIndex++) {

            if (printIndex == 0) {
                sb.append(firstMatrix.getFormattedRowStringByIndex(printIndex));
                sb.append(" ");
                sb.append(secondMatrix.getFormattedRowStringByIndex(printIndex));
                sb.append("\n");
            }
            else {
                if (printIndex < firstMatrixHeight) {
                    sb.append(firstMatrix.getFormattedRowStringByIndex(printIndex));
                    sb.append(" ");
                }
                else {
                    sb.append(StandardOutputUtil.getSpacesString(widthOfFirstMatrixRowString + 1));
                }
                if (printIndex < secondMatrixHeight) {
                    sb.append(secondMatrix.getFormattedRowStringByIndex(printIndex));
                    sb.append("\n");
                }
                else {
                    sb.append("\n");
                }
            }
        }
        System.out.print(sb.toString());
    }
}
