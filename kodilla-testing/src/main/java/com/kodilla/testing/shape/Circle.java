package com.kodilla.testing.shape;

public class Circle implements Shape {
    private double radius;

    @Override
    public String toString() {
        return getShapeName() + "{radius= " + radius + "; area= " + getField() + '}';
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public double getField() {
        return Math.PI*radius*radius;
    }
}
