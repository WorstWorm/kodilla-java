package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ShapeCollector {

    private List<Shape> shapes = new ArrayList<>();

    public List<Shape> getShapesList() {
        return shapes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShapeCollector collector = (ShapeCollector) o;

        return Objects.equals(shapes, collector.shapes);
    }

    @Override
    public int hashCode() {
        return shapes != null ? shapes.hashCode() : 0;
    }

    public void addFigure(Shape shape){
        shapes.add(shape);
    }

    public void removeFigure(Shape shape){
        shapes.remove(shape);
    }

    public Shape getFigure(int n){
        return shapes.get(n);
    }

    public String showFigures(){
        String result = "";
        for(Shape s : shapes){
            result += s.toString();
            result += "; ";
        }
        result = result.trim();
        System.out.println(result);
        return result;
    }

}
