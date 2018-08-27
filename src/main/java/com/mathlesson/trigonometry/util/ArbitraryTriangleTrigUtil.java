package com.mathlesson.trigonometry.util;

import static java.lang.Math.*;

public final class ArbitraryTriangleTrigUtil {

    private ArbitraryTriangleTrigUtil() { }

    public static double getThirdAngleBySumOfAnglesOfATriangle(double angleOne, double angleTwo) {
        return (180.0D - angleOne - angleTwo);
    }

    public static double getAngleDegreesFromThreeSides(double sideOne, double sideTwo, double oppSide) {

        // using the law of cosines
        return toDegrees(acos(
            (pow(sideOne, 2.0D) + pow(sideTwo, 2.0D) - pow(oppSide, 2.0D)) / (2.0D * sideOne * sideTwo)));
    }

    public static double getThirdSideFromTwoSidesAndSeparatingAngle(
            double sideOne, double sideTwo, double angDegrees) {

        // using the law of cosines
        return sqrt((pow(sideOne, 2.0D) + pow(sideTwo, 2.0D)
                    - (2.0D * sideOne * sideTwo * cos(toRadians(angDegrees)))));
    }

    public static double getOtherNonSeparatingAngleFromTwoSidesAndNonSeparatingAngle(
            double oppositeSideLength, double adjacentSideLength, double angleDegrees) {

        // using the law of sines
        return toDegrees(
                asin((adjacentSideLength / oppositeSideLength) * sin(toRadians(angleDegrees))));
    }

    public static double getOtherNonSeparatingSideFromTwoAnglesAndNonSeparatingSide(
            double oppositeAngleDegrees, double adjacentAngleDegrees, double sideLength) {

        // using the law of sines
        return (sin(toRadians(adjacentAngleDegrees))
            * (sideLength / sin(toRadians(oppositeAngleDegrees))));
    }
}
