package com.mathlesson.trigonometry;

import static com.mathlesson.trigonometry.util.ArbitraryTriangleTrigUtil.*;
import static com.mathlesson.trigonometry.util.RightTriangleTrigUtil.*;

/**
 * Follows this triangle model:
 *
 *
 *                                  / |
 *                                /   |
 *                              /     |
 *                            /    B  |
 *                          /         |
 *                        /           |
 *                      /             |
 *               c    /               |
 *                  /                 |  a
 *                /                   |
 *              /                     |
 *            /                       |
 *          /                         |
 *        /                      _____|
 *      /                       |     |
 *    /   A                     |  C  |
 *  /___________________________|_____|
 *
 *                   b
 *
 */
public final class RightTriangleCreator {

    private RightTriangleCreator() { }

    public static Triangle withAngleAndOppositeSide(double angDegrees, double oppLength) {
        return new TriangleBuilder()
                .angleA(angDegrees)
                .angleC(90.0D)
                .sideA(oppLength)
                .sideC(tb -> getHypotenuseByAngleAndOpposite(angDegrees, oppLength))
                .sideB(tb -> getThirdSideByPythagoreanTheorem(tb.getSideC(), oppLength))
                .angleB(tb -> getThirdAngleBySumOfAnglesOfATriangle(angDegrees, tb.getAngleC()))
                .build();
    }

    public static Triangle withAngleAndHypotenuse(double angDegrees, double hypLength) {
        return new TriangleBuilder()
                .angleA(angDegrees)
                .angleC(90.0D)
                .sideC(hypLength)
                .angleB(tb -> getThirdAngleBySumOfAnglesOfATriangle(angDegrees, tb.getAngleC()))
                .sideA(tb -> getOppositeSideByAngleAndHypotenuse(angDegrees, hypLength))
                .sideB(tb -> getThirdSideByPythagoreanTheorem(hypLength, tb.getSideA()))
                .build();
    }

    public static Triangle withAngleAndAdjacentSide(double angDegrees, double adjLength) {
        return new TriangleBuilder()
                .angleA(angDegrees)
                .sideB(adjLength)
                .angleC(90.0D)
                .angleB(tb -> getThirdAngleBySumOfAnglesOfATriangle(angDegrees, tb.getAngleC()))
                .sideC(tb -> getHypotenuseByAngleAndAdjacent(angDegrees, adjLength))
                .sideA(tb -> getThirdSideByPythagoreanTheorem(tb.getSideC(), adjLength))
                .build();
    }

    public static Triangle withOppositeAndHypotenuseSides(double oppLength, double hypLength) {
        return new TriangleBuilder()
                .sideC(hypLength)
                .sideA(oppLength)
                .angleC(90.0D)
                .angleA(tb -> getAngleDegreesByOppositeAndHypotenuse(oppLength, hypLength))
                .angleB(tb -> getThirdAngleBySumOfAnglesOfATriangle(tb.getAngleC(), tb.getAngleA()))
                .sideB(tb -> getThirdSideByPythagoreanTheorem(hypLength, oppLength))
                .build();
    }

    public static Triangle withAdjacentAndHypotenuseSides(double adjLength, double hypLength) {
        return new TriangleBuilder()
                .sideB(adjLength)
                .sideC(hypLength)
                .angleC(90.0D)
                .sideA(tb -> getThirdSideByPythagoreanTheorem(hypLength, adjLength))
                .angleA(tb -> getAngleDegreesByAdjacentAndHypotenuse(adjLength, hypLength))
                .angleB(tb -> getThirdAngleBySumOfAnglesOfATriangle(tb.getAngleA(), tb.getAngleC()))
                .build();
    }
}
