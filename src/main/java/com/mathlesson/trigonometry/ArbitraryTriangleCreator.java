package com.mathlesson.trigonometry;

import static com.mathlesson.trigonometry.util.ArbitraryTriangleTrigUtil.*;

/**
 * Follows this triangle model:
 *
 *
 *                        / \
 *                      /    \
 *                    /   B   \
 *                  /          \
 *                /             \
 *          c   /                \   a
 *            /                   \
 *          /                      \
 *        /                         \
 *      /                            \
 *    /   A                       C   \
 *  /__________________________________\
 *
 *                   b
 *
 */
public final class ArbitraryTriangleCreator {

    private ArbitraryTriangleCreator() { }

    public static Triangle withThreeSides(double sideA, double sideB, double sideC) {
        return new TriangleBuilder()
                .sideA(sideA)
                .sideB(sideB)
                .sideC(sideC)
                .angleC(tb -> getAngleDegreesFromThreeSides(sideA, sideB, sideC))
                .angleB(tb -> getAngleDegreesFromThreeSides(sideA, sideC, sideB))
                .angleA(tb -> getThirdAngleBySumOfAnglesOfATriangle(tb.getAngleC(), tb.getAngleB()))
                .build();
    }

    public static Triangle withTwoSidesAndSeparatingAngle(double sideA, double sideB, double angleC) {
        return new TriangleBuilder()
                .sideA(sideA)
                .angleC(angleC)
                .sideB(sideB)
                .sideC(
                    tb -> getThirdSideFromTwoSidesAndSeparatingAngle(sideA, sideB, tb.getAngleC()))
                .angleA(tb -> getAngleDegreesFromThreeSides(tb.getSideC(), sideB, sideA))
                .angleB(tb -> getThirdAngleBySumOfAnglesOfATriangle(angleC, tb.getAngleA()))
                .build();
    }

    public static Triangle withTwoSidesAndCounterClockwiseAngleAcute(double sideA, double sideB, double angleA) {
        return new TriangleBuilder()
                .angleA(angleA)
                .sideA(sideA)
                .sideB(sideB)
                .angleB(
                    tb ->
                        getOtherNonSeparatingAngleFromTwoSidesAndCounterClockwiseAngle(sideA, sideB, angleA))
                .angleC(tb -> getThirdAngleBySumOfAnglesOfATriangle(angleA, tb.getAngleB()))
                .sideC(tb -> getThirdSideFromTwoSidesAndSeparatingAngle(sideA, sideB, tb.getAngleC()))
                .build();
    }

    public static Triangle withTwoSidesAndCounterClockwiseAngleObtuse(double sideA, double sideB, double angleA) {
        return new TriangleBuilder()
                .angleA(angleA)
                .sideA(sideA)
                .sideB(sideB)
                .angleB(
                    tb ->
                        180 - getOtherNonSeparatingAngleFromTwoSidesAndCounterClockwiseAngle(sideA, sideB, angleA))
                .angleC(tb -> getThirdAngleBySumOfAnglesOfATriangle(angleA, tb.getAngleB()))
                .sideC(tb -> getThirdSideFromTwoSidesAndSeparatingAngle(sideA, sideB, tb.getAngleC()))
                .build();
    }

}
