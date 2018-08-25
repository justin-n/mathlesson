package com.mathlesson.trigonometry.util;

public class RightTriangleTrigUtil {

    private RightTriangleTrigUtil() { }

    public static double getHypotenuseByAngleAndOpposite(double angDegrees, double oppLength) {
        return ( oppLength / Math.sin(Math.toRadians(angDegrees)) );
    }

    public static double getHypotenuseByAngleAndAdjacent(double angDegrees, double adjLength) {
        return ( adjLength / Math.cos(Math.toRadians(angDegrees)) );
    }

    public static double getOppositeSideByAngleAndHypotenuse(double angDegrees, double hypLength) {
        return ( Math.sin(Math.toRadians(angDegrees)) * hypLength );
    }

    public static double getThirdSideByPythagoreanTheorem(double hypLength, double otherSideLength) {
        return ( Math.sqrt( Math.pow(hypLength, 2.0D) - Math.pow(otherSideLength, 2.0D) ) );
    }

    public static double getAngleDegreesByOppositeAndHypotenuse(double oppLength, double hypLength) {
        return Math.toDegrees( Math.asin( oppLength / hypLength ) );
    }

    public static double getAngleDegreesByAdjacentAndHypotenuse(double adjLength, double hypLength) {
        return Math.toDegrees( Math.acos( adjLength / hypLength ) );
    }
}
