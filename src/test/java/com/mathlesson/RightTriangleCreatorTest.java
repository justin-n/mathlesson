package com.mathlesson;

import com.mathlesson.trigonometry.RightTriangleCreator;
import com.mathlesson.trigonometry.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RightTriangleCreatorTest {

    private Triangle rightTriangle1;

    @Test
    void withAngleAndOppositeSideReturnsValidTriangle() {
        rightTriangle1 =
                RightTriangleCreator.withAngleAndOppositeSide(30.0, 3.0);

        rightTriangle1Test(rightTriangle1);
    }

    @Test
    void withAngleAndHypotenuseReturnsValidTriangle() {
        rightTriangle1 =
                RightTriangleCreator.withAngleAndHypotenuse(30.0, 6.0);

        rightTriangle1Test(rightTriangle1);
    }

    @Test
    void withAngleAndAdjacentSideReturnsValidTriangle() {
        rightTriangle1 =
                RightTriangleCreator.withAngleAndAdjacentSide(
                        30.0, 5.196152422706633);

        rightTriangle1Test(rightTriangle1);
    }

    @Test
    void withOppositeAndHypotenuseSidesReturnsValidTriangle() {
        rightTriangle1 =
                RightTriangleCreator.withOppositeAndHypotenuseSides(3.0, 6.0);

        rightTriangle1Test(rightTriangle1);
    }

    @Test
    void withAdjacentAndHypotenuseSidesReturnsValidTriangle() {
        rightTriangle1 =
                RightTriangleCreator.withAdjacentAndHypotenuseSides(
                        5.196152422706633, 6.0);

        rightTriangle1Test(rightTriangle1);
    }

    private void rightTriangle1Test(Triangle triangle) {
        assertEquals(triangle.getSideA(), 3.0, 0.000001);
        assertEquals(triangle.getSideB(), 5.196152422706633, 0.000001);
        assertEquals(triangle.getSideC(), 6.0, 0.000001);
        assertEquals(triangle.getAngleA(), 30.0, 0.000001);
        assertEquals(triangle.getAngleB(), 60.0, 0.000001);
        assertEquals(triangle.getAngleC(), 90.0, 0.000001);
    }
}
