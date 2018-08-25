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

    /*

    This is not going to be an easy one to write up.

    public static Triangle withTwoSidesAndCounterClockwiseAngleAcute(double angleA, double sideB, double sideA);

     */

}
