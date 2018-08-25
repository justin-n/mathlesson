package com.mathlesson.trigonometry.util;

public final class ArbitraryTriangleTrigUtil {

    private ArbitraryTriangleTrigUtil() { }

    public static double getThirdAngleBySumOfAnglesOfATriangle(double angleOne, double angleTwo) {
        return (180.0 - angleOne - angleTwo);
    }

    public static double getAngleDegreesFromThreeSides(double sideOne, double sideTwo, double oppSide) {
        // using the law of cosines
        return Math.toDegrees(Math.acos(
            (Math.pow(sideOne, 2.0D) + Math.pow(sideTwo, 2.0D) - Math.pow(oppSide, 2.0D))
                 / (2 * sideOne * sideTwo)));
    }

    public static double getThirdSideFromTwoSidesAndSeparatingAngle(
            double sideOne, double sideTwo, double angDegrees) {

        // using the law of cosines
        return Math.sqrt(
            (Math.pow(sideOne, 2.0D) + Math.pow(sideTwo, 2.0D)
                    - (2 * sideOne * sideTwo * Math.cos(Math.toRadians(angDegrees)))));
    }
}
