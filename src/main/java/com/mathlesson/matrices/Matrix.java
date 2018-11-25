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
}
