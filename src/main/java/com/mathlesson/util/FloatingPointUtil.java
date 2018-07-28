package com.mathlesson.util;

public final class FloatingPointUtil {

    private FloatingPointUtil() { }

    public static int compareDoubleValueWithThreshold(double firstComparisonOperator, double secondComparisonOperator) {
        final double THRESHOLD = .000001;

        if (Math.abs(firstComparisonOperator - secondComparisonOperator) < THRESHOLD) {
            return 0;
        } else if (firstComparisonOperator < secondComparisonOperator) {
            return -1;
        } else {
            return 1;
        }
    }
}
