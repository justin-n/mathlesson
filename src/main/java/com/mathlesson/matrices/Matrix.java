package com.mathlesson.matrices;

import java.util.List;

public class Matrix<N extends Number> {

    private List<List<N>> rows;

    public Matrix() { }

    public Matrix(List<List<N>> rows) {
        this.rows = rows;
    }

    public List<List<N>> getRows() {
        return rows;
    }

    public void setRows(List<List<N>> rows) {
        this.rows = rows;
    }
}
