package com.mathlesson.matrices;

public class BinaryMatrixOperationEquationHandler<N extends Number> {

    private Matrix<N> firstMatrix;
    private Matrix<N> secondMatrix;
    private Matrix<N> resultMatrix;

    BinaryMatrixOperationEquationHandler() {
        firstMatrix = new Matrix<>();
    }

    public Matrix<N> getFirstMatrix() {
        return firstMatrix;
    }

    public void setFirstMatrix(Matrix<N> firstMatrix) {
        this.firstMatrix = firstMatrix;
    }

    public Matrix<N> getSecondMatrix() {
        return secondMatrix;
    }

    public void setSecondMatrix(Matrix<N> secondMatrix) {
        this.secondMatrix = secondMatrix;
    }

    public Matrix<N> getResultMatrix() {
        return resultMatrix;
    }

    public void setResultMatrix(Matrix<N> resultMatrix) {
        this.resultMatrix = resultMatrix;
    }
}
