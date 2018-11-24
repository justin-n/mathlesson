package com.mathlesson.matrices;

import java.util.List;

public class Matrix<N extends Number> {

    private List<N> rows;

    public Matrix() { }

    public Matrix(List<N> rows) {
        this.rows = rows;
    }

    public List<N> getRows() {
        return rows;
    }

    public void setRows(List<N> rows) {
        this.rows = rows;
    }
}
