package org.example;

import java.util.*;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

//        double[][] testMatrix = helper.generateRandomBandMatrix(9, 9, 1);
//        helper.printMatrix(testMatrix);

        MatricesList allMatrices = new MatricesList();
        allMatrices.GenerateTg(3, 2, 300);
        allMatrices.GenerateSolutionVectors(3, 2, 300);

        var tests = new ArrayList<HypothesisTest>();
        tests.add(new HypothesisTest("H1_A1_TG_DS1", tries -> {
            var results = new HashMap<Integer, Double>();
            for(int i=0; i<tries; i++){
                double[][] testMatrix = allMatrices.getTgMatrix(i);
                var m = new mySparseMatrixDS1();
                m.become(testMatrix);
                double[] x = allMatrices.getSolutionVector(i);
                double[] b = helper.matrixVectorMultiply(testMatrix, x);
                var solvedX = m.GENP(b);
                var avgErr = helper.meanError(x, solvedX);
                results.put(i, avgErr);
            }
            return results;
        }));

        var tester = new HypothesisTester(tests);
        var results = tester.doTests(allMatrices.solutionVectors.size());
        createHistogram(results.get("H1_A1_TG_DS1").values());
    }
    private static void createHistogram(Collection<Double> values) {
        // Loop through the frequency array and print the histogram
        for (int i = 0; i < Collections.max(values); i++) {
            System.out.print(i + "-" + (i+1) + ": ");

            // Print "*" for each occurrence of the element
            for(var value : values){
                if(value >= i && value < i+1 ){
                    System.out.print("*");
                }
            }

            System.out.println(); // Move to the next line for the next element
        }
    }
}