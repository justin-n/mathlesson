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
                3.0, 5.196152422706633, 6.0);

        rightTriangleTest(arbTriangle1);
    }

    @Test
    void withTwoSidesAndSeparateAngleReturnsValidTriangle() {
        arbTriangle1 =
                ArbitraryTriangleCreator.withTwoSidesAndSeparatingAngle(
                        3.0, 5.196152422706633, 90.0);

        rightTriangleTest(arbTriangle1);
    }

    private void rightTriangleTest(Triangle triangle) {
        assertEquals(triangle.getSideA(), 3.0, 0.000001);
        assertEquals(triangle.getSideB(), 5.196152422706633, 0.000001);
        assertEquals(triangle.getSideC(), 6.0, 0.000001);
        assertEquals(triangle.getAngleA(), 30.0, 0.000001);
        assertEquals(triangle.getAngleB(), 60.0, 0.000001);
        assertEquals(triangle.getAngleC(), 90.0, 0.000001);
    }

}
