package com.mathlesson;

import com.mathlesson.trigonometry.RightTriangleCreator;
import com.mathlesson.trigonometry.Triangle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleTest {

    private static Triangle rightTriangle1;

    @BeforeAll
    static void init() {
        rightTriangle1 =
                RightTriangleCreator.withOppositeAndHypotenuseSides(3.0D, 6.0D);
    }

    @Test
    void getAreaReturnsCorrectArea() {
        assertEquals(rightTriangle1.getArea(), 7.7942286340599495D, 0.000001D);
    }

}
