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
                RightTriangleCreator.withAngleAndOppositeSide(30.0D, 3.0D);

        rightTriangle1Test(rightTriangle1);
    }

    @Test
    void withAngleAndHypotenuseReturnsValidTriangle() {
        rightTriangle1 =
                RightTriangleCreator.withAngleAndHypotenuse(30.0D, 6.0D);

        rightTriangle1Test(rightTriangle1);
    }

    @Test
    void withAngleAndAdjacentSideReturnsValidTriangle() {
        rightTriangle1 =
                RightTriangleCreator.withAngleAndAdjacentSide(
                        30.0D, 5.196152422706633D);

        rightTriangle1Test(rightTriangle1);
    }

    @Test
    void withOppositeAndHypotenuseSidesReturnsValidTriangle() {
        rightTriangle1 =
                RightTriangleCreator.withOppositeAndHypotenuseSides(3.0D, 6.0D);

        rightTriangle1Test(rightTriangle1);
    }

    @Test
    void withAdjacentAndHypotenuseSidesReturnsValidTriangle() {
        rightTriangle1 =
                RightTriangleCreator.withAdjacentAndHypotenuseSides(
                        5.196152422706633D, 6.0D);

        rightTriangle1Test(rightTriangle1);
    }

    private void rightTriangle1Test(Triangle triangle) {
        assertEquals(3.0D, triangle.getSideA(), 0.000001D);
        assertEquals(5.196152422706633D, triangle.getSideB(), 0.000001D);
        assertEquals(6.0D, triangle.getSideC(), 0.000001D);
        assertEquals(30.0D, triangle.getAngleA(), 0.000001D);
        assertEquals(60.0D, triangle.getAngleB(), 0.000001D);
        assertEquals(90.0D, triangle.getAngleC(), 0.000001D);
    }
}
