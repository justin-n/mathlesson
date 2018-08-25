package com.mathlesson.trigonometry;

import com.mathlesson.util.FloatingPointUtil;

import java.util.EnumSet;
import java.util.function.Function;

import static com.mathlesson.trigonometry.TriangleProperty.*;

final class TriangleBuilder {

    private EnumSet<TriangleProperty> properties = EnumSet.noneOf(TriangleProperty.class);

    private double sideA;
    private double sideB;
    private double sideC;

    private double angleA;
    private double angleB;
    private double angleC;

    TriangleBuilder() { }

    EnumSet<TriangleProperty> getProperties() {
        return properties;
    }

    double getSideA() {
        return sideA;
    }

    double getSideB() {
        return sideB;
    }

    double getSideC() {
        return sideC;
    }

    double getAngleA() {
        return angleA;
    }

    double getAngleB() {
        return angleB;
    }

    double getAngleC() {
        return angleC;
    }

    TriangleBuilder sideA(double length) {
        this.sideA = length;
        return this;
    }

    TriangleBuilder sideA(Function<TriangleBuilder, Double> function) {
        this.sideA = function.apply(this);
        return this;
    }

    TriangleBuilder sideB(double length) {
        this.sideB = length;
        return this;
    }

    TriangleBuilder sideB(Function<TriangleBuilder, Double> function) {
        this.sideB = function.apply(this);
        return this;
    }

    TriangleBuilder sideC(double length) {
        this.sideC = length;
        return this;
    }

    TriangleBuilder sideC(Function<TriangleBuilder, Double> function) {
        this.sideC = function.apply(this);
        return this;
    }

    TriangleBuilder angleA(double degrees) {
        this.angleA = degrees;
        return this;
    }

    TriangleBuilder angleA(Function<TriangleBuilder, Double> function) {
        this.angleA = function.apply(this);
        return this;
    }

    TriangleBuilder angleB(double degrees) {
        this.angleB = degrees;
        return this;
    }

    TriangleBuilder angleB(Function<TriangleBuilder, Double> function) {
        this.angleB = function.apply(this);
        return this;
    }

    TriangleBuilder angleC(double degrees) {
        this.angleC = degrees;
        return this;
    }

    TriangleBuilder angleC(Function<TriangleBuilder, Double> function) {
        this.angleC = function.apply(this);
        return this;
    }

    Triangle build() {

        checkAndAddProperties();

        Triangle triangle = null;
        try {
            triangle = new Triangle(this);
        } catch (NotATriangleException nate) {
            // this is a temporary solution, when the program expands to a
            // UI this will be more elaborate
            nate.printStackTrace();
            System.exit(1);

        }
        return triangle;
    }

    private void checkAndAddProperties() {
        checkForRightAndOblique();
        checkForEquilateral();
        checkForIsosceles();
        checkForScalene();
        checkForAcute();
        checkForObtuse();
    }

    private void checkForRightAndOblique() {
        if (FloatingPointUtil.compareDoubleValueWithThreshold(angleA, 90.0D) == 0
                || FloatingPointUtil.compareDoubleValueWithThreshold(angleB, 90.0D) == 0
                || FloatingPointUtil.compareDoubleValueWithThreshold(angleC, 90.0D) == 0) {
            properties.add(RIGHT);
        } else {
            properties.add(OBLIQUE);
        }
    }

    private void checkForEquilateral() {
        if (FloatingPointUtil.compareDoubleValueWithThreshold(sideA, sideB) == 0
                && FloatingPointUtil.compareDoubleValueWithThreshold(sideB, sideC) == 0) {
            properties.add(EQUILATERAL);
        }
    }

    private void checkForIsosceles() {
        if (FloatingPointUtil.compareDoubleValueWithThreshold(sideA, sideB) == 0
                || FloatingPointUtil.compareDoubleValueWithThreshold(sideB, sideC) == 0
                || FloatingPointUtil.compareDoubleValueWithThreshold(sideC, sideA) == 0) {
            properties.add(ISOSCELES);
        }
    }

    private void checkForScalene() {
        if (FloatingPointUtil.compareDoubleValueWithThreshold(sideA, sideB) != 0
                && FloatingPointUtil.compareDoubleValueWithThreshold(sideB, sideC) != 0
                && FloatingPointUtil.compareDoubleValueWithThreshold(sideC, sideA) != 0) {
            properties.add(SCALENE);
        }
    }

    private void checkForAcute() {
        if (FloatingPointUtil.compareDoubleValueWithThreshold(angleA, 90.0D) == -1
                && FloatingPointUtil.compareDoubleValueWithThreshold(angleB, 90.0D) == -1
                && FloatingPointUtil.compareDoubleValueWithThreshold(angleC, 90.0D) == -1) {
            properties.add(ACUTE);
        }
    }

    private void checkForObtuse() {
        if (FloatingPointUtil.compareDoubleValueWithThreshold(angleA, 90.0D) == 1
                || FloatingPointUtil.compareDoubleValueWithThreshold(angleB, 90.0D) == 1
                || FloatingPointUtil.compareDoubleValueWithThreshold(angleC, 90.0D) == 1) {
            properties.add(OBTUSE);
        }
    }
}
