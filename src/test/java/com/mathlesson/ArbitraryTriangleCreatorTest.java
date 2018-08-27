package com.mathlesson;

import com.mathlesson.trigonometry.ArbitraryTriangleCreator;
import com.mathlesson.trigonometry.Triangle;
import com.mathlesson.trigonometry.TriangleNotSolvableException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArbitraryTriangleCreatorTest {

    private static final double TEST_DELTA = 0.000001D;

    private Triangle arbTriangle1;

    @Test
    void withThreeSidesReturnsValidTriangle() {
        arbTriangle1 = ArbitraryTriangleCreator.withThreeSides(
                3.0D, 5.196152422706633D, 6.0D);

        rightTriangleTest1(arbTriangle1);
    }

    @Test
    void withTwoSidesAndSeparateAngleReturnsValidTriangle() {
        arbTriangle1 =
                ArbitraryTriangleCreator.withTwoSidesAndSeparatingAngle(
                        3.0D, 5.196152422706633D, 90.0D);

        rightTriangleTest1(arbTriangle1);
    }

    @Test
    void withTwoSidesAndClockwiseAngleReturnsValidTriangle() throws TriangleNotSolvableException {
        arbTriangle1 = ArbitraryTriangleCreator
                .withTwoSidesAndClockwiseAngle(3.0D, 5.196152422706633D, 30.0D);

        rightTriangleTest1(arbTriangle1);
    }

    @Test
    void withTwoSidesAndClockwiseAngleAlternativeReturnsValidTriangle() throws TriangleNotSolvableException {
        arbTriangle1 = ArbitraryTriangleCreator
                .withTwoSidesAndClockwiseAngleAlternative(3.0D, 5.196152422706633D, 30.0D);

        alternateSolutionRightTriangleTest1(arbTriangle1);
    }

    @Test
    void withTwoSidesAndCounterClockwiseAngleReturnsValidTriangle() throws TriangleNotSolvableException {
        arbTriangle1 = ArbitraryTriangleCreator
            .withTwoSidesAndCounterClockwiseAngle(5.196152422706633D, 3.0D, 30.0D);

        rightTriangleTest2(arbTriangle1);
    }

    @Test
    void withTwoSidesAndCounterClockwiseAngleAlternativeReturnsValidTriangle()
        throws TriangleNotSolvableException {

        arbTriangle1 = ArbitraryTriangleCreator
            .withTwoSidesAndCounterClockwiseAngleAlternative(5.196152422706633D, 3.0D, 30.0D);

        alternateSolutionRightTriangleTest2(arbTriangle1);
    }

    @Test
    void withTwoAnglesAndOneCounterClockwiseSideReturnsValidTriangle() {
        arbTriangle1 = ArbitraryTriangleCreator
            .withTwoAnglesAndOneCounterClockwiseSide(30.0D, 60.0D, 5.196152422706633D);

        rightTriangleTest1(arbTriangle1);
    }

    private void rightTriangleTest1(Triangle triangle) {
        assertEquals(triangle.getSideA(), 3.0D, TEST_DELTA);
        assertEquals(triangle.getSideB(), 5.196152422706633D, TEST_DELTA);
        assertEquals(triangle.getSideC(), 6.0D, TEST_DELTA);
        assertEquals(triangle.getAngleA(), 30.0D, TEST_DELTA);
        assertEquals(triangle.getAngleB(), 60.0D, TEST_DELTA);
        assertEquals(triangle.getAngleC(), 90.0D, TEST_DELTA);
    }

    private void alternateSolutionRightTriangleTest1(Triangle triangle) {
        assertEquals(triangle.getSideA(), 3.0D, TEST_DELTA);
        assertEquals(triangle.getSideB(), 5.196152422706633D, TEST_DELTA);
        assertEquals(triangle.getSideC(), 3.0D, TEST_DELTA);
        assertEquals(triangle.getAngleA(), 30.0D, TEST_DELTA);
        assertEquals(triangle.getAngleB(), 120.0D, TEST_DELTA);
        assertEquals(triangle.getAngleC(), 30.0D, TEST_DELTA);
    }

    private void singleSolutionTriangleTest(Triangle triangle) {
        assertEquals(triangle.getSideA(), 6.0D, TEST_DELTA);
        assertEquals(triangle.getSideB(), 3.0D, TEST_DELTA);
        assertEquals(triangle.getSideC(), 5.196152422706633D, TEST_DELTA);
        assertEquals(triangle.getAngleA(), 90.0D, TEST_DELTA);
        assertEquals(triangle.getAngleB(), 30.0D, TEST_DELTA);
        assertEquals(triangle.getAngleC(), 60.0D, TEST_DELTA);
    }

    private void rightTriangleTest2(Triangle triangle) {
        assertEquals(triangle.getSideA(), 5.196152422706633D, TEST_DELTA);
        assertEquals(triangle.getSideB(), 3.0D, TEST_DELTA);
        assertEquals(triangle.getSideC(), 6.0D, TEST_DELTA);
        assertEquals(triangle.getAngleA(), 60.0D, TEST_DELTA);
        assertEquals(triangle.getAngleB(), 30.0D, TEST_DELTA);
        assertEquals(triangle.getAngleC(), 90.0D, TEST_DELTA);
    }

    private void alternateSolutionRightTriangleTest2(Triangle triangle) {
        assertEquals(triangle.getSideA(), 5.196152422706633D, TEST_DELTA);
        assertEquals(triangle.getSideB(), 3.0D, TEST_DELTA);
        assertEquals(triangle.getSideC(), 3.0D, TEST_DELTA);
        assertEquals(triangle.getAngleA(), 120.0D, TEST_DELTA);
        assertEquals(triangle.getAngleB(), 30.0D, TEST_DELTA);
        assertEquals(triangle.getAngleC(), 30.0D, TEST_DELTA);
    }
}
