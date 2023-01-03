package com.kodilla.exception.test;

public class ExceptionHandling extends Exception {
    public static void main(String [] args) {

        SecondChallenge second = new SecondChallenge();

        try {
            second.probablyIWillThrowException(2.0, 1.5);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}