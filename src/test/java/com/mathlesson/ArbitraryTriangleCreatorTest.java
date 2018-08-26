package com.mathlesson;

import com.mathlesson.trigonometry.ArbitraryTriangleCreator;
import com.mathlesson.trigonometry.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArbitraryTriangleCreatorTest {

    private Triangle arbTriangle1;

    @Test
    void withThreeSidesMethodReturnsValidTriangle() {
        arbTriangle1 = ArbitraryTriangleCreator.withThreeSides(
                3.0D, 5.196152422706633D, 6.0D);

        rightTriangleTest(arbTriangle1);
    }

    @Test
    void withTwoSidesAndSeparateAngleReturnsValidTriangle() {
        arbTriangle1 =
                ArbitraryTriangleCreator.withTwoSidesAndSeparatingAngle(
                        3.0D, 5.196152422706633D, 90.0D);

        rightTriangleTest(arbTriangle1);
    }

    @Test
    void withTwoSidesAndCounterClockwiseAngleAcuteReturnsValidTriangle() {
        arbTriangle1 = ArbitraryTriangleCreator
                .withTwoSidesAndCounterClockwiseAngleAcute(3.0D, 5.196152422706633D, 30.0D);

        rightTriangleTest(arbTriangle1);
    }

    private void rightTriangleTest(Triangle triangle) {
        assertEquals(triangle.getSideA(), 3.0D, 0.000001D);
        assertEquals(triangle.getSideB(), 5.196152422706633D, 0.000001D);
        assertEquals(triangle.getSideC(), 6.0D, 0.000001D);
        assertEquals(triangle.getAngleA(), 30.0D, 0.000001D);
        assertEquals(triangle.getAngleB(), 60.0D, 0.000001D);
        assertEquals(triangle.getAngleC(), 90.0D, 0.000001D);
    }

}
