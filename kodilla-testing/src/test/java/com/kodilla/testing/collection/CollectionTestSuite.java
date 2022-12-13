package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@DisplayName("Collection Test Suite")
public class CollectionTestSuite {

    @BeforeEach
    public void before(TestInfo testInfo){
        System.out.println("Test Case: " + testInfo.getDisplayName() + " - started");
    }

    @AfterEach
    public void after(TestInfo testInfo){
        System.out.println("Test Case: " + testInfo.getDisplayName() + " - finished");
    }

    @DisplayName("Checks if the method returns an empty list when an empty list is entered")
    @Test
    void testOddNumbersExterminatorEmptyList(){
        //Given
        List<Integer> input = new LinkedList<Integer>();
        List<Integer> expected = new LinkedList<Integer>();

        //When
        List<Integer> output = OddNumbersExterminator.exterminate(input);

        //Then
        Assertions.assertIterableEquals(expected, output);

    }

    @DisplayName("Checks if the method returns a list of all even numbers when a valid list is entered")
    @Test
    void testOddNumbersExterminatorNormalList(){
        //Given
        List<Integer> input = Arrays.asList(2, 5, 1, 4, 3, 6, 7, 6);
        List<Integer> expected = Arrays.asList(2, 4, 6, 6);

        //When
        List<Integer> output = OddNumbersExterminator.exterminate(input);

        //Then
        Assertions.assertIterableEquals(expected, output);
    }
}
