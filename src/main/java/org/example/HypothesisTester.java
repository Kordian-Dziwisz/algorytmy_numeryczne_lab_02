package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HypothesisTester {
    private ArrayList<HypothesisTest> tests;
    public HypothesisTester(ArrayList<HypothesisTest> tests){
        this.tests = tests;
    }

    public HashMap<String, Map<Integer, Double>> doTests(Integer tries){
        var result = new HashMap<String, Map<Integer, Double>>();
        this.tests.forEach((test)->result.put(test.name, test.function.apply(tries)));
        return result;
    }
}
