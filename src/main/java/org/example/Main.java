package org.example;

import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
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
        tests.add(new HypothesisTest("H1_A1_diff_A2_TG_DS1", tries -> {
            var results = new HashMap<Integer, Double>();
            for(int i=0; i<tries; i++){
                double[][] testMatrix = helper.generateMatrix(10,10);
                var m = new mySparseMatrixDS1();
                m.become(testMatrix);
                double[] x = helper.generateRandomVector(10);
                double[] b = helper.matrixVectorMultiply(testMatrix, x);
                var solvedX = m.GENP(b);
                var avgErrGENP = helper.meanError(x, solvedX);
                m.become(testMatrix);
                solvedX = m.GEPP(b);
                var avgErrGEPP = helper.meanError(x, solvedX);
                var avgErr = avgErrGEPP - avgErrGENP;
                results.put(i, avgErr);
            }
            return results;
        }));

        tests.add(new HypothesisTest("H1_A1_diff_A2_TG_DS2", tries -> {
            var results = new HashMap<Integer, Double>();
            for(int i=0; i<tries; i++){
                double[][] testMatrix = helper.generateMatrix(10,10);
                var m = new mySparseMatrixDS2();
                m.become(testMatrix);
                double[] x = helper.generateRandomVector(10);
                double[] b = helper.matrixVectorMultiply(testMatrix, x);
                var solvedX = m.GENP(b);
                var avgErrGENP = helper.meanError(x, solvedX);
                m.become(testMatrix);
                solvedX = m.GEPP(b);
                var avgErrGEPP = helper.meanError(x, solvedX);
                var avgErr = avgErrGEPP - avgErrGENP;
                results.put(i, avgErr);
            }
            return results;
        }));

        tests.add(new HypothesisTest("H1_A1_diff_A2_TW_DS1", tries -> {
            var results = new HashMap<Integer, Double>();
            for(int i=0; i<tries; i++){
                double[][] testMatrix = helper.generateRandomBandMatrix(10,10, 3);
                var m = new mySparseMatrixDS1();
                m.become(testMatrix);
                double[] x = helper.generateRandomVector(10);
                double[] b = helper.matrixVectorMultiply(testMatrix, x);
                var solvedX = m.GENP(b);
                var avgErrGENP = helper.meanError(x, solvedX);
                m.become(testMatrix);
                solvedX = m.GEPP(b);
                var avgErrGEPP = helper.meanError(x, solvedX);
                var avgErr = avgErrGEPP - avgErrGENP;
                results.put(i, avgErr);
            }
            return results;
        }));

        tests.add(new HypothesisTest("H1_A1_diff_A2_TW_DS2", tries -> {
            var results = new HashMap<Integer, Double>();
            for(int i=0; i<tries; i++){
                double[][] testMatrix = helper.generateRandomBandMatrix(10,10, 3);
                var m = new mySparseMatrixDS2();
                m.become(testMatrix);
                double[] x = helper.generateRandomVector(10);
                double[] b = helper.matrixVectorMultiply(testMatrix, x);
                var solvedX = m.GENP(b);
                var avgErrGENP = helper.meanError(x, solvedX);
                m.become(testMatrix);
                solvedX = m.GEPP(b);
                var avgErrGEPP = helper.meanError(x, solvedX);
                var avgErr = avgErrGEPP - avgErrGENP;
                results.put(i, avgErr);
            }
            return results;
        }));

        tests.add(new HypothesisTest("H1_A1_diff_A1_TW2_DS1", tries -> {
            var results = new HashMap<Integer, Double>();
            for(int i=0; i<tries; i++){
                double[][] testMatrix = helper.generateSparseBandMatrix(10,10, 3);
                var m = new mySparseMatrixDS1();
                m.become(testMatrix);
                double[] x = helper.generateRandomVector(10);
                double[] b = helper.matrixVectorMultiply(testMatrix, x);
                var solvedX = m.GENP(b);
                var avgErrGENP = helper.meanError(x, solvedX);
                m.become(testMatrix);
                solvedX = m.GEPP(b);
                var avgErrGEPP = helper.meanError(x, solvedX);
                var avgErr = avgErrGEPP - avgErrGENP;
                results.put(i, avgErr);
            }
            return results;
        }));

        tests.add(new HypothesisTest("H1_A1_diff_A1_TW2_DS2", tries -> {
            var results = new HashMap<Integer, Double>();
            for(int i=0; i<tries; i++){
                double[][] testMatrix = helper.generateSparseBandMatrix(10,10, 3);
                var m = new mySparseMatrixDS2();
                m.become(testMatrix);
                double[] x = helper.generateRandomVector(10);
                double[] b = helper.matrixVectorMultiply(testMatrix, x);
                var solvedX = m.GENP(b);
                var avgErrGENP = helper.meanError(x, solvedX);
                m.become(testMatrix);
                solvedX = m.GEPP(b);
                var avgErrGEPP = helper.meanError(x, solvedX);
                var avgErr = avgErrGEPP - avgErrGENP;
                results.put(i, avgErr);
            }
            return results;
        }));

        tests.add(new HypothesisTest("H2_A1_TG_DS1_10", tries -> {
            var results = new HashMap<Integer, Double>();
            for(int i=0; i<tries; i++){
                double[][] testMatrix = helper.generateMatrix(10,10);
                var m = new mySparseMatrixDS1();
                m.become(testMatrix);
                double[] x = helper.generateRandomVector(10);
                double[] b = helper.matrixVectorMultiply(testMatrix, x);
                var solvedX = m.GENP(b);
                var avgErr = helper.meanError(x, solvedX);
                results.put(i, avgErr);
            }
            return results;
        }));

        tests.add(new HypothesisTest("H2_A1_TG_DS1_20", tries -> {
            var results = new HashMap<Integer, Double>();
            for(int i=0; i<tries; i++){
                double[][] testMatrix = helper.generateMatrix(20,20);
                var m = new mySparseMatrixDS1();
                m.become(testMatrix);
                double[] x = helper.generateRandomVector(20);
                double[] b = helper.matrixVectorMultiply(testMatrix, x);
                var solvedX = m.GENP(b);
                var avgErr = helper.meanError(x, solvedX);
                results.put(i, avgErr);
            }
            return results;
        }));

        tests.add(new HypothesisTest("H2_A1_TG_DS1_40", tries -> {
            var results = new HashMap<Integer, Double>();
            for(int i=0; i<tries; i++){
                double[][] testMatrix = helper.generateMatrix(40,40);
                var m = new mySparseMatrixDS1();
                m.become(testMatrix);
                double[] x = helper.generateRandomVector(40);
                double[] b = helper.matrixVectorMultiply(testMatrix, x);
                var solvedX = m.GENP(b);
                var avgErr = helper.meanError(x, solvedX);
                results.put(i, avgErr);
            }
            return results;
        }));

        tests.add(new HypothesisTest("H2_A1_TG_DS1_80", tries -> {
            var results = new HashMap<Integer, Double>();
            for(int i=0; i<tries; i++){
                double[][] testMatrix = helper.generateMatrix(80,80);
                var m = new mySparseMatrixDS1();
                m.become(testMatrix);
                double[] x = helper.generateRandomVector(80);
                double[] b = helper.matrixVectorMultiply(testMatrix, x);
                var solvedX = m.GENP(b);
                var avgErr = helper.meanError(x, solvedX);
                results.put(i, avgErr);
            }
            return results;
        }));




        var tester = new HypothesisTester(tests);
        var results = tester.doTests(1000);
        var json = new JSONObject(results);
        try {
            FileWriter writer = new FileWriter("results.json");
            writer.write(json.toString());
            writer.close();
            System.out.println("Successfully wrote to file " + "results.json");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
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