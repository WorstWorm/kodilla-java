package com.kodilla.testing.shape;

public class Rectangle implements Shape {

    private double sideA;
    private double sideB;

    @Override
    public String toString() {
        return getShapeName() + "{side A= " + sideA + "; side B= " + sideB + "; area= " + getField() + '}';
    }

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public String getShapeName() {
        return "Rectangle";
    }

    @Override
    public double getField() {
        return sideA*sideB;
    }
}
