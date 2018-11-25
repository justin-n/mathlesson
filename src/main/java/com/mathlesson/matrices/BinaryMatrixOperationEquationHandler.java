package com.mathlesson.matrices;

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
}
