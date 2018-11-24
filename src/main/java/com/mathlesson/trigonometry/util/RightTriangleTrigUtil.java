package com.mathlesson.trigonometry.util;

import static java.lang.Math.*;

public final class RightTriangleTrigUtil {

    private RightTriangleTrigUtil() { }

    public static double getHypotenuseByAngleAndOpposite(double angDegrees, double oppLength) {
        return ( oppLength / sin(toRadians(angDegrees)) );
    }

    public static double getHypotenuseByAngleAndAdjacent(double angDegrees, double adjLength) {
        return ( adjLength / cos(toRadians(angDegrees)) );
    }

    public static double getOppositeSideByAngleAndHypotenuse(double angDegrees, double hypLength) {
        return ( sin(toRadians(angDegrees)) * hypLength );
    }

    public static double getThirdSideByPythagoreanTheorem(double hypLength, double otherSideLength) {
        return ( sqrt( pow(hypLength, 2.0D) - pow(otherSideLength, 2.0D) ) );
    }

    public static double getAngleDegreesByOppositeAndHypotenuse(double oppLength, double hypLength) {
        return toDegrees( asin( oppLength / hypLength ) );
    }

    public static double getAngleDegreesByAdjacentAndHypotenuse(double adjLength, double hypLength) {
        return toDegrees( acos( adjLength / hypLength ) );
    }
}
