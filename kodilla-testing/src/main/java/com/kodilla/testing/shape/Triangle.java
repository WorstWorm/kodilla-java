package com.kodilla.testing.shape;

public class Triangle implements Shape {

    private double base;
    private double height;

    @Override
    public String toString() {
        return getShapeName() + "{base= " + base + "; height= " + height + "; area= " + getField() + '}';
    }

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public double getField() {
        return (base*height)/2;
    }
}
