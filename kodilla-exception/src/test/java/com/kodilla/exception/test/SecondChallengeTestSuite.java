package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    void testGreaterOrEqualTwo() {
        //given
        SecondChallenge second = new SecondChallenge();
        assertThrows(Exception.class, () -> second.probablyIWillThrowException(3.0, 1.0));

    }

    @Test
    void testLessOne() {
        //given
        SecondChallenge second = new SecondChallenge();
        assertThrows(Exception.class, () -> second.probablyIWillThrowException(0.5, 1.0));
    }

    @Test
    void testEqualOneAndHalf() {
        //given
        SecondChallenge second = new SecondChallenge();
        assertThrows(Exception.class, () -> second.probablyIWillThrowException(1.5, 1.5));
    }

    @Test
    void testValid() {
        //given
        SecondChallenge second = new SecondChallenge();
        assertDoesNotThrow(() -> second.probablyIWillThrowException(1.5, 1.0));
    }
}