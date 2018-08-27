package com.mathlesson.trigonometry;

import com.mathlesson.util.FloatingPointUtil;

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
            .sideC(tb -> getThirdSideFromTwoSidesAndSeparatingAngle(sideA, sideB, tb.getAngleC()))
            .angleA(tb -> getAngleDegreesFromThreeSides(tb.getSideC(), sideB, sideA))
            .angleB(tb -> getThirdAngleBySumOfAnglesOfATriangle(angleC, tb.getAngleA()))
            .build();
    }

    public static Triangle withTwoSidesAndClockwiseAngle(
            double sideA, double sideB, double angleA) throws TriangleNotSolvableException {

        // this validation might eventually be moved to a higher level
        validateInputForTwoSidesAndNonSeparatingAngleSolution(sideA, sideB, angleA);

        return new TriangleBuilder()
            .angleA(angleA)
            .sideA(sideA)
            .sideB(sideB)
            .angleB(
                tb -> getOtherNonSeparatingAngleFromTwoSidesAndNonSeparatingAngle(sideA, sideB, angleA))
            .angleC(tb -> getThirdAngleBySumOfAnglesOfATriangle(angleA, tb.getAngleB()))
            .sideC(tb -> getThirdSideFromTwoSidesAndSeparatingAngle(sideA, sideB, tb.getAngleC()))
            .build();
    }

    public static Triangle withTwoSidesAndClockwiseAngleAlternative(
            double sideA, double sideB, double angleA) throws TriangleNotSolvableException {

        // this validation might eventually be moved to a higher level
        validateInputForTwoSidesAndNonSeparatingAngleSolution(sideA, sideB, angleA);

        return new TriangleBuilder()
            .angleA(angleA)
            .sideA(sideA)
            .sideB(sideB)
            .angleB(
                tb -> 180 - getOtherNonSeparatingAngleFromTwoSidesAndNonSeparatingAngle(sideA, sideB, angleA))
            .angleC(tb -> getThirdAngleBySumOfAnglesOfATriangle(angleA, tb.getAngleB()))
            .sideC(tb -> getThirdSideFromTwoSidesAndSeparatingAngle(sideA, sideB, tb.getAngleC()))
            .build();
    }

    public static Triangle withTwoSidesAndCounterClockwiseAngle(
            double sideA, double sideB, double angleB) throws TriangleNotSolvableException {

        // this validation might eventually be moved to a higher level
        validateInputForTwoSidesAndNonSeparatingAngleSolution(sideB, sideA, angleB);

        return new TriangleBuilder()
            .sideB(sideB)
            .sideA(sideA)
            .angleB(angleB)
            .angleA(
                tb -> getOtherNonSeparatingAngleFromTwoSidesAndNonSeparatingAngle(sideB, sideA, angleB))
            .angleC(tb -> getThirdAngleBySumOfAnglesOfATriangle(angleB, tb.getAngleA()))
            .sideC(tb -> getThirdSideFromTwoSidesAndSeparatingAngle(sideA, sideB, tb.getAngleC()))
            .build();
    }

    public static Triangle withTwoSidesAndCounterClockwiseAngleAlternative(
            double sideA, double sideB, double angleB) throws TriangleNotSolvableException {

        // this validation might eventually be moved to a higher level
        validateInputForTwoSidesAndNonSeparatingAngleSolution(sideB, sideA, angleB);

        return new TriangleBuilder()
            .sideB(sideB)
            .sideA(sideA)
            .angleB(angleB)
            .angleA(
                tb -> 180 - getOtherNonSeparatingAngleFromTwoSidesAndNonSeparatingAngle(sideB, sideA, angleB))
            .angleC(tb -> getThirdAngleBySumOfAnglesOfATriangle(angleB, tb.getAngleA()))
            .sideC(tb -> getThirdSideFromTwoSidesAndSeparatingAngle(sideA, sideB, tb.getAngleC()))
            .build();
    }

    public static Triangle withTwoAnglesAndOneCounterClockwiseSide(
            double angleA, double angleB, double sideB) {

        return new TriangleBuilder()
            .angleB(angleB)
            .angleA(angleA)
            .sideB(sideB)
            .sideA(
                tb -> getOtherNonSeparatingSideFromTwoAnglesAndNonSeparatingSide(angleB, angleA, sideB))
            .angleC(tb -> getThirdAngleBySumOfAnglesOfATriangle(angleA, angleB))
            .sideC(tb -> getThirdSideFromTwoSidesAndSeparatingAngle(tb.getSideA(), tb.getSideB(), tb.getAngleC()))
            .build();
    }

    private static void validateInputForTwoSidesAndNonSeparatingAngleSolution(
            double oppositeSideLength, double adjacentSideLength, double angleDegrees)
            throws TriangleNotSolvableException {

        if (((FloatingPointUtil.compareDoubleValueWithThreshold(oppositeSideLength, adjacentSideLength) != 1))
                && (FloatingPointUtil.compareDoubleValueWithThreshold(angleDegrees, 90.0D) != -1)) {

            throw new TriangleNotSolvableException("opposite side of angle cannot reach third side");
        }
        if (FloatingPointUtil.compareDoubleValueWithThreshold(
                (adjacentSideLength / oppositeSideLength) * (Math.sin(Math.toRadians(angleDegrees))), 1.0D) == 1) {
            throw new TriangleNotSolvableException("law of sines check failed");
        }
    }
}
