package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage(){
        //GIVEN
        int[] arr = {1,2,3,4,9,8,7,6};

        //WHEN
        double result = ArrayOperations.getAvarage(arr);

        //THEN
        double expected = 5.0;
        assertEquals(expected, result);
    }
}
