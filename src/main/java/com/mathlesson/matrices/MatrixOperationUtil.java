package com.mathlesson.matrices;

import java.util.ArrayList;
import java.util.List;

public class MatrixOperationUtil {

    public static List<Integer> addRowsTogether(List<Integer> firstRow, List<Integer> secondRow) {

        List<Integer> sumRow = new ArrayList<>();

        for (int i = 0; i < firstRow.size(); i++) {
            sumRow.add(firstRow.get(i) + secondRow.get(i));
        }

        return sumRow;
    }

}
