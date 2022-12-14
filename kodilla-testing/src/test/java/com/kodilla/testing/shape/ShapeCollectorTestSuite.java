package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

public class ShapeCollectorTestSuite {


    @Nested
    @DisplayName("1. adding/removing tests")
    class testAddRemove {

        @DisplayName("1.1. Checking the addition of shape")
        @Test
        void addFigure () {
            //Given
            Shape shape1 = new Rectangle(4.0, 2.0);
            ShapeCollector collector = new ShapeCollector();

            //When
            collector.addFigure(shape1);

            //Then
            Assertions.assertEquals(1, collector.getShapesList().size());
        }

        @DisplayName("1.2. Checking shape deletion")
        @Test
        void removeFigure () {
            //Given
            Shape shape1 = new Rectangle(4.0, 2.0);
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(shape1);

            //When
            collector.removeFigure(shape1);

            //Then
            Assertions.assertEquals(0, collector.getShapesList().size());
        }
    }

    @Nested
    @DisplayName("2. operating on shapes tests")
    class testOperations {

        @DisplayName("2.1. Checking the possibility to recover single shape")
        @Test
        void getFigure() {
            //Given
            Shape shape1 = new Rectangle(4.0, 2.0);
            Shape shape2 = new Triangle(6.0, 2.0);
            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(shape1);
            collector.addFigure(shape2);

            //When
            Shape received = collector.getFigure(0);

            //Then
            Assertions.assertEquals(shape1, received);
        }

        @DisplayName("2.2. Checking the display of all shapes.")
        @Test
        void showFigures() {
            //Given
            Shape shape1 = new Rectangle(4.0, 2.0);
            Shape shape2 = new Triangle(6.0, 2.0);
            Shape shape3 = new Circle(5.0);

            ShapeCollector collector = new ShapeCollector();
            collector.addFigure(shape1);
            collector.addFigure(shape2);
            collector.addFigure(shape3);

            //When
            String expected = shape1.toString() + "; " + shape2.toString() + "; " + shape3.toString() + ";";
            String received = collector.showFigures();

            //Then
            Assertions.assertEquals(expected, received);
        }
    }
}
