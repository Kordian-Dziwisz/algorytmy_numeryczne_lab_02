package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class HypothesisTester {
    private ArrayList<HypothesisTest> tests;
    public HypothesisTester(ArrayList<HypothesisTest> tests){
    }

    public HashMap<String, HypothesisTestFunctionResult> doTests(Integer tries){
        var result = new HashMap<String, HypothesisTestFunctionResult>();
        this.tests.forEach((test)->result.put(test.name, test.function.apply(tries)));
        return result;
    }
}
