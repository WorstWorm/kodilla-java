package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if(result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("Test - pierwszy test jednostkowy:");

        if(Calculator.add(3,4)==7) {
            System.out.println("adding test - passed");
        } else {
            System.out.println("adding test - failed");
        }

        if(Calculator.subtract(6,2)==4) {
            System.out.println("adding test - passed");
        } else {
            System.out.println("adding test - failed");
        }
    }
}
