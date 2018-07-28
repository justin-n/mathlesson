package com.mathlesson.trigonometry;

import com.mathlesson.util.FloatingPointUtil;

import java.util.EnumSet;

import static com.mathlesson.trigonometry.TriangleProperty.*;

public final class Triangle {

    private final EnumSet<TriangleProperty> properties;

    private final double sideA;
    private final double sideB;
    private final double sideC;

    private final double angleA;
    private final double angleB;
    private final double angleC;

    Triangle(TriangleBuilder builder) throws NotATriangleException {
        this.properties = builder.getProperties();

        checkForConflictingProperties();

        this.sideA = builder.getSideA();
        this.sideB = builder.getSideB();
        this.sideC = builder.getSideC();

        checkEquilateralProperties();
        checkIsoscelesProperties();
        checkScaleneProperties();

        this.angleA = builder.getAngleA();
        this.angleB = builder.getAngleB();
        this.angleC = builder.getAngleC();

        checkAcuteProperties();
        checkObtuseProperties();
        checkRightProperties();
        checkObliqueProperties();
    }

    private void checkForConflictingProperties() throws NotATriangleException {
        if (isRight() && isOblique()) {
            throw new NotATriangleException("Cannot be a right and oblique triangle.");
        }

        if (isRight() && isObtuse()) {
            throw new NotATriangleException("Cannot be a right and obtuse triangle.");
        }

        if (isRight() && isAcute()) {
            throw new NotATriangleException("Cannot be a right and acute triangle.");
        }

        if (isRight() && isEquilateral()) {
            throw new NotATriangleException("Cannot be a right and equilateral triangle.");
        }

        if (isAcute() && !isOblique()) {
            throw new NotATriangleException(
                    "Cannot be an acute triangle without being an oblique triangle.");
        }

        if (isObtuse() && !isOblique()) {
            throw new NotATriangleException(
                    "Cannot be an obtuse triangle without being an oblique triangle.");
        }

        if (isEquilateral() && !isIsosceles()) {
            throw new NotATriangleException(
                    "Cannot be an equilateral triangle without being an isosceles triangle.");
        }

        if (isEquilateral() && !isAcute()) {
            throw new NotATriangleException(
                    "Cannot be an equilateral triangle without being an acute triangle.");
        }

        if (isEquilateral() && isObtuse()) {
            throw new NotATriangleException("Cannot be an equilateral and obtuse triangle");
        }

        if (isScalene() && isEquilateral()) {
            throw new NotATriangleException("Cannot be a scalene and equilateral triangle.");
        }

        if (isScalene() && isIsosceles()) {
            throw new NotATriangleException("Cannot be a scalene and isosceles triangle.");
        }

        if (isAcute() && isObtuse()) {
            throw new NotATriangleException("Cannot be an obtuse and acute triangle.");
        }
    }

    private void checkEquilateralProperties() throws NotATriangleException {
        if (FloatingPointUtil.compareDoubleValueWithThreshold(sideA, sideB) == 0
                && FloatingPointUtil.compareDoubleValueWithThreshold(sideB, sideC) == 0) {

            if (isRight()) {
                throw new NotATriangleException(
                        "All sides equal but showing right triangle.");
            }

            if (isObtuse()) {
                throw new NotATriangleException(
                        "All sides equal but showing obtuse triangle.");
            }

            if (!isEquilateral()) {
                throw new NotATriangleException(
                        "All sides equal but not showing equilateral triangle.");
            }

            if (!isIsosceles()) {
                throw new NotATriangleException(
                        "All sides equal but not showing isosceles triangle.");
            }

            if (isScalene()) {
                throw new NotATriangleException(
                        "All sides equal but showing scalene triangle");
            }

            if (!isAcute()) {
                throw new NotATriangleException(
                        "All sides equal but not showing acute triangle");
            }

            if (!isOblique()) {
                throw new NotATriangleException(
                        "All sides equal but not showing oblique triangle.");
            }
        }
    }

    private void checkIsoscelesProperties() throws NotATriangleException {
        if (FloatingPointUtil.compareDoubleValueWithThreshold(sideA, sideB) == 0
                || FloatingPointUtil.compareDoubleValueWithThreshold(sideB, sideC) == 0
                || FloatingPointUtil.compareDoubleValueWithThreshold(sideC, sideA) == 0) {

            if (!isIsosceles()) {
                throw new NotATriangleException("Two sides equal but not showing isosceles.");
            }

            if (isScalene()) {
                throw new NotATriangleException("Two sides equal but showing scalene.");
            }
        }
    }

    private void checkScaleneProperties() throws NotATriangleException {
        if (FloatingPointUtil.compareDoubleValueWithThreshold(sideA, sideB) != 0
                && FloatingPointUtil.compareDoubleValueWithThreshold(sideB, sideC) != 0
                && FloatingPointUtil.compareDoubleValueWithThreshold(sideC, sideA) != 0) {

            if (!isScalene()) {
                throw new NotATriangleException("No sides equal but not showing scalene.");
            }

            if (isEquilateral()) {
                throw new NotATriangleException("No sides equal but showing equilateral.");
            }

            if (isIsosceles()) {
                throw new NotATriangleException("No sides equal but showing isosceles");
            }
        }
    }

    private void checkAcuteProperties() throws NotATriangleException {
        if (FloatingPointUtil.compareDoubleValueWithThreshold(angleA, 90.0) == -1
                && FloatingPointUtil.compareDoubleValueWithThreshold(angleB, 90.0) == -1
                && FloatingPointUtil.compareDoubleValueWithThreshold(angleC, 90.0) == -1) {

            if (!isAcute()) {
                throw new NotATriangleException("All angles less than 90 degrees but not showing acute.");
            }

            if (isObtuse()) {
                throw new NotATriangleException("All angles less than 90 degrees but showing obtuse.");
            }

            if (!isOblique()) {
                throw new NotATriangleException("All angles less than 90 degrees but not showing oblique.");
            }

            if (isRight()) {
                throw new NotATriangleException("All angles less than 90 degrees but showing right.");
            }
        }
    }

    private void checkObtuseProperties() throws NotATriangleException {
        if (FloatingPointUtil.compareDoubleValueWithThreshold(angleA, 90.0) == 1
                || FloatingPointUtil.compareDoubleValueWithThreshold(angleB, 90.0) == 1
                || FloatingPointUtil.compareDoubleValueWithThreshold(angleC, 90.0) == 1) {

            if (!isObtuse()) {
                throw new NotATriangleException("One angle over 90 degrees but not showing obtuse.");
            }

            if (isAcute()) {
                throw new NotATriangleException("One angle over 90 degrees but showing acute.");
            }

            if (isRight()) {
                throw new NotATriangleException("One angle over 90 degrees but showing right.");
            }

            if (!isOblique()) {
                throw new NotATriangleException("One angle over 90 degrees but showing oblique.");
            }
        }
    }

    private void checkRightProperties() throws NotATriangleException {
        if (FloatingPointUtil.compareDoubleValueWithThreshold(angleA, 90.0) == 0
                || FloatingPointUtil.compareDoubleValueWithThreshold(angleB, 90.0) == 0
                || FloatingPointUtil.compareDoubleValueWithThreshold(angleC, 90.0) == 0) {

            if (!isRight()) {
                throw new NotATriangleException("One angle 90 degrees but not showing right.");
            }

            if (isOblique()) {
                throw new NotATriangleException("One angle 90 degrees but showing oblique.");
            }

            if (isEquilateral()) {
                throw new NotATriangleException("One angle 90 degrees but showing equilateral.");
            }

            if (isAcute()) {
                throw new NotATriangleException("One angle 90 degrees but showing acute.");
            }

            if (isObtuse()) {
                throw new NotATriangleException("One angle 90 degrees but showing obtuse.");
            }
        }
    }

    private void checkObliqueProperties() throws NotATriangleException {
        if (FloatingPointUtil.compareDoubleValueWithThreshold(angleA, 90.0) != 0
                && FloatingPointUtil.compareDoubleValueWithThreshold(angleB, 90.0) != 0
                && FloatingPointUtil.compareDoubleValueWithThreshold(angleC, 90.0) != 0) {

            if (!isOblique()) {
                throw new NotATriangleException("No right angle but not showing oblique.");
            }

            if (isRight()) {
                throw new NotATriangleException("No right angle but showing right.");
            }

            if (!isAcute() && !isObtuse()) {
                throw new NotATriangleException(
                        "No right angle but not showing either acute or obtuse.");
            }
        }
    }

    private boolean isRight() {
        return properties.contains(RIGHT);
    }

    private boolean isAcute() {
        return properties.contains(ACUTE);
    }

    private boolean isOblique() {
        return properties.contains(OBLIQUE);
    }

    private boolean isObtuse() {
        return properties.contains(OBTUSE);
    }

    private boolean isEquilateral() {
        return properties.contains(EQUILATERAL);
    }

    private boolean isIsosceles() {
        return properties.contains(ISOSCELES);
    }

    private boolean isScalene() {
        return properties.contains(SCALENE);
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public double getAngleA() {
        return angleA;
    }

    public double getAngleB() {
        return angleB;
    }

    public double getAngleC() {
        return angleC;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Properties: ");

        for (TriangleProperty property : properties) {
            sb.append(property).append(" ");
        }

        sb.append("\n")
            .append("sideA: ").append(sideA).append("\n")
            .append("sideB: ").append(sideB).append("\n")
            .append("sideC: ").append(sideC).append("\n")
            .append("angleA: ").append(angleA).append("\n")
            .append("angleB: ").append(angleB).append("\n")
            .append("angleC: ").append(angleC).append("\n");

        return sb.toString();
    }
}
