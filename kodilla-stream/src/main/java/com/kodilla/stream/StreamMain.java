package com.kodilla.stream;

import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;
import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args){
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        System.out.println("Text beautification");
        poemBeautifier.beautify("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", (string -> string.toUpperCase()));
        poemBeautifier.beautify("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", (string -> string.toLowerCase()));
        poemBeautifier.beautify("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", (string -> "ABC " + string + " ABC"));
        poemBeautifier.beautify("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", (string -> {
            char[] c = string.toCharArray();
            String result = "";
            for (int i = 0; i < c.length; i++) {
                result += c[i] + "_";
            }
            return result;
            }));
        poemBeautifier.beautify("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", (string -> {
            char[] c = string.toCharArray();
            String result = "";
            for (int i = 0; i < c.length; i++) {
                if (i%2==0){
                    String a ="";
                    a += c[i];
                    result += a.toUpperCase();
                } else {
                    String a ="";
                    a += c[i];
                    result += a.toLowerCase();
                }
            }
            return result;
        }));
    }
}
