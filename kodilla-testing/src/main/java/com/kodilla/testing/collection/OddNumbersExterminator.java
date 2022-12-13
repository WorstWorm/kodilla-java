package com.kodilla.testing.collection;

import java.util.LinkedList;
import java.util.List;

public class OddNumbersExterminator {
    static public List<Integer> exterminate(List<Integer> numbers){
        List<Integer> result = new LinkedList<Integer>();
        for(Integer i : numbers){
            if(i%2==0){
                result.add(i);
            }
        }
        return result;
    }
}
