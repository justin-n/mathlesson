package com.mathlesson;

import com.mathlesson.trigonometry.ArbitraryTriangleCreator;
import com.mathlesson.trigonometry.Triangle;
import com.mathlesson.trigonometry.TriangleNotSolvableException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArbitraryTriangleCreatorTest {

    private static final double TEST_DELTA = 0.01D;

    private Triangle arbTriangle1;
    private Triangle arbTriangle2;

    @Test
    void withThreeSidesReturnsValidTriangle() {
        arbTriangle1 = ArbitraryTriangleCreator.withThreeSides(
                3.0D, 5.196152422706633D, 6.0D);
        arbTriangle2 = ArbitraryTriangleCreator.withThreeSides(
            8.152D, 10.0D, 9.216D);

        rightTriangleTest1(arbTriangle1);
        arbitraryTriangleTest1(arbTriangle2);
    }

    @Test
    void withTwoSidesAndSeparateAngleReturnsValidTriangle() {
        arbTriangle1 =
                ArbitraryTriangleCreator.withTwoSidesAndSeparatingAngle(
                        3.0D, 5.196152422706633D, 90.0D);
        arbTriangle2 =
                ArbitraryTriangleCreator.withTwoSidesAndSeparatingAngle(
                    8.152D, 10.0D, 60.0D);

        rightTriangleTest1(arbTriangle1);
        arbitraryTriangleTest1(arbTriangle2);
    }

    @Test
    void withTwoSidesAndClockwiseAngleReturnsValidTriangle() throws TriangleNotSolvableException {
        arbTriangle1 = ArbitraryTriangleCreator
                .withTwoSidesAndClockwiseAngle(3.0D, 5.196152422706633D, 30.0D);
        arbTriangle2 = ArbitraryTriangleCreator
                .withTwoSidesAndClockwiseAngle(8.152D, 10.00000000000D, 50.00000000000D);

        rightTriangleTest1(arbTriangle1);
        arbitraryTriangleTest1(arbTriangle2);
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
        arbTriangle2 = ArbitraryTriangleCreator
            .withTwoSidesAndCounterClockwiseAngle(8.152D, 10.0D, 70.0D);

        rightTriangleTest2(arbTriangle1);
        arbitraryTriangleTest1(arbTriangle2);
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
            .withTwoAnglesAndCounterClockwiseSide(30.0D, 60.0D, 5.196152422706633D);
        arbTriangle2 = ArbitraryTriangleCreator
            .withTwoAnglesAndCounterClockwiseSide(50.0D, 70.0D, 10.0D);

        rightTriangleTest1(arbTriangle1);
        arbitraryTriangleTest1(arbTriangle2);
    }

    @Test
    void withTwoAnglesAndSeparatingSideReturnsValidTriangle() {
        arbTriangle1 = ArbitraryTriangleCreator
            .withTwoAnglesAndSeparatingSide(30.0D, 5.196152422706633D, 90.0D);
        arbTriangle2 = ArbitraryTriangleCreator
            .withTwoAnglesAndSeparatingSide(50.0D, 10.0D, 60.0D);

        rightTriangleTest1(arbTriangle1);
        arbitraryTriangleTest1(arbTriangle2);
    }

    private void rightTriangleTest1(Triangle triangle) {
        assertEquals(3.0D, triangle.getSideA(), TEST_DELTA);
        assertEquals(5.196152422706633D, triangle.getSideB(), TEST_DELTA);
        assertEquals(6.0D, triangle.getSideC(), TEST_DELTA);
        assertEquals(30.0D, triangle.getAngleA(), TEST_DELTA);
        assertEquals(60.0D, triangle.getAngleB(), TEST_DELTA);
        assertEquals(90.0D, triangle.getAngleC(), TEST_DELTA);
    }

    private void alternateSolutionRightTriangleTest1(Triangle triangle) {
        assertEquals(3.0D, triangle.getSideA(), TEST_DELTA);
        assertEquals(5.196152422706633D, triangle.getSideB(), TEST_DELTA);
        assertEquals(3.0D, triangle.getSideC(), TEST_DELTA);
        assertEquals(30.0D, triangle.getAngleA(), TEST_DELTA);
        assertEquals(120.0D, triangle.getAngleB(), TEST_DELTA);
        assertEquals(30.0D, triangle.getAngleC(), TEST_DELTA);
    }

    private void rightTriangleTest2(Triangle triangle) {
        assertEquals(5.196152422706633D, triangle.getSideA(), TEST_DELTA);
        assertEquals(3.0D, triangle.getSideB(), TEST_DELTA);
        assertEquals(6.0D, triangle.getSideC(), TEST_DELTA);
        assertEquals(60.0D, triangle.getAngleA(), TEST_DELTA);
        assertEquals(30.0D, triangle.getAngleB(), TEST_DELTA);
        assertEquals(90.0D, triangle.getAngleC(), TEST_DELTA);
    }

    private void alternateSolutionRightTriangleTest2(Triangle triangle) {
        assertEquals(5.196152422706633D, triangle.getSideA(), TEST_DELTA);
        assertEquals(3.0D, triangle.getSideB(), TEST_DELTA);
        assertEquals(3.0D, triangle.getSideC(), TEST_DELTA);
        assertEquals(120.0D, triangle.getAngleA(), TEST_DELTA);
        assertEquals(30.0D, triangle.getAngleB(), TEST_DELTA);
        assertEquals(30.0D, triangle.getAngleC(), TEST_DELTA);
    }

    private void arbitraryTriangleTest1(Triangle triangle) {
        assertEquals(8.152D, triangle.getSideA(), TEST_DELTA);
        assertEquals(10.0D, triangle.getSideB(), TEST_DELTA);
        assertEquals(9.216D, triangle.getSideC(), TEST_DELTA);
        assertEquals(50.0D, triangle.getAngleA(), TEST_DELTA);
        assertEquals(70.0D, triangle.getAngleB(), TEST_DELTA);
        assertEquals(60.0D, triangle.getAngleC(), TEST_DELTA);
    }
}
