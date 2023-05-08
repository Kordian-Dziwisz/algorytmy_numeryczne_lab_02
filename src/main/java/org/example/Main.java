package org.example;

import org.apache.commons.math3.linear.*;
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
        allMatrices.GenerateTg(4, 3, 300);
        allMatrices.GenerateSolutionVectors(4, 3, 300);
        allMatrices.GenerateTw(4, 3, 300, 1);
        allMatrices.GenerateTwSparse(4, 3, 300, 1);



        var tests1 = new ArrayList<HypothesisTest>();
        tests1.add(new HypothesisTest("H1_A1_diff_A2_TG_DS1", tries -> {
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

        tests1.add(new HypothesisTest("H1_A1_diff_A2_TG_DS2", tries -> {
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

        tests1.add(new HypothesisTest("H1_A1_diff_A2_TW_DS1", tries -> {
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

        tests1.add(new HypothesisTest("H1_A1_diff_A2_TW_DS2", tries -> {
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

        tests1.add(new HypothesisTest("H1_A1_diff_A1_TW2_DS1", tries -> {
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

        tests1.add(new HypothesisTest("H1_A1_diff_A1_TW2_DS2", tries -> {
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

        var tests2 = new ArrayList<HypothesisTest>();
        tests2.add(new HypothesisTest("H2_A1_TG_DS1_10", tries -> {
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

        tests2.add(new HypothesisTest("H2_A1_TG_DS1_20", tries -> {
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

        tests2.add(new HypothesisTest("H2_A1_TG_DS1_40", tries -> {
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

        tests2.add(new HypothesisTest("H2_A1_TG_DS1_80", tries -> {
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

        var tests3 = new ArrayList<HypothesisTest>();
        tests3.add(new HypothesisTest("H3_A2_TG_DS1", tries -> {
            var results = new HashMap<Integer, Double>();
            for(int i=0; i<tries; i++){
                double[][] testMatrix = allMatrices.getTgMatrix(i);
                var m = new mySparseMatrixDS1();
                m.become(testMatrix);
                double[] x = allMatrices.getSolutionVector(i);
                double[] b = helper.matrixVectorMultiply(testMatrix, x);
                long startTime = System.nanoTime();
                var solvedX = m.GENP(b);
                long endTime = System.nanoTime();
                double duration = (endTime - startTime)/ 1000000000.0;
                results.put(b.length, duration);
            }
            return results;
        }));
//
        tests3.add(new HypothesisTest("H3_A2_TW_DS1", tries -> {
            var results = new HashMap<Integer, Double>();
            for(int i=0; i<tries; i++){
                double[][] testMatrix = allMatrices.getTwMatrix(i);
                var m = new mySparseMatrixDS1();
                m.become(testMatrix);
                double[] x = allMatrices.getSolutionVector(i);
                double[] b = helper.matrixVectorMultiply(testMatrix, x);
                long startTime = System.nanoTime();
                var solvedX = m.GENP(b);
                long endTime = System.nanoTime();
                double duration = (endTime - startTime)/ 1000000000.0;
                results.put(b.length, duration);
            }
            return results;
        }));

        tests3.add(new HypothesisTest("H3_A2_TW2_DS1", tries -> {
            var results = new HashMap<Integer, Double>();
            for(int i=0; i<tries; i++){
                double[][] testMatrix = allMatrices.getTwSparseMatrix(i);
                var m = new mySparseMatrixDS1();
                m.become(testMatrix);
                double[] x = allMatrices.getSolutionVector(i);
                double[] b = helper.matrixVectorMultiply(testMatrix, x);
                long startTime = System.nanoTime();
                var solvedX = m.GENP(b);
                long endTime = System.nanoTime();
                double duration = (endTime - startTime)/ 1000000000.0;
                results.put(b.length, duration);
            }
            return results;
        }));

        tests3.add(new HypothesisTest("H3_TW_OTHER", tries -> {
            var results = new HashMap<Integer, Double>();
            for(int i=0; i<tries; i++){
                double[][] testMatrix = allMatrices.getTwMatrix(i);
                RealMatrix m = new Array2DRowRealMatrix(testMatrix);
                RealVector b = new ArrayRealVector(helper.matrixVectorMultiply(testMatrix, allMatrices.getSolutionVector(i)));
                long startTime = System.nanoTime();
                DecompositionSolver solver = new LUDecomposition(m).getSolver();
                RealVector solution = solver.solve(b);
                long endTime = System.nanoTime();
                double duration = (endTime - startTime)/ 1000000000.0;
                results.put(testMatrix.length, duration);
            }
            return results;
        }));

        tests3.add(new HypothesisTest("H3_TW2_OTHER", tries -> {
            var results = new HashMap<Integer, Double>();
            for(int i=0; i<tries; i++){
                double[][] testMatrix = allMatrices.getTwSparseMatrix(i);
                RealMatrix m = new Array2DRowRealMatrix(testMatrix);
                RealVector b = new ArrayRealVector(helper.matrixVectorMultiply(testMatrix, allMatrices.getSolutionVector(i)));
                long startTime = System.nanoTime();
                DecompositionSolver solver = new LUDecomposition(m).getSolver();
                RealVector solution = solver.solve(b);
                long endTime = System.nanoTime();
                double duration = (endTime - startTime)/ 1000000000.0;
                results.put(testMatrix.length, duration);
            }
            return results;
        }));

        tests3.add(new HypothesisTest("H3_TG_OTHER", tries -> {
            var results = new HashMap<Integer, Double>();
            for(int i=0; i<tries; i++){
                double[][] testMatrix = allMatrices.getTgMatrix(i);
                RealMatrix m = new Array2DRowRealMatrix(testMatrix);
                RealVector b = new ArrayRealVector(helper.matrixVectorMultiply(testMatrix, allMatrices.getSolutionVector(i)));
                long startTime = System.nanoTime();
                DecompositionSolver solver = new LUDecomposition(m).getSolver();
                RealVector solution = solver.solve(b);
                long endTime = System.nanoTime();
                double duration = (endTime - startTime)/ 1000000000.0;
                results.put(testMatrix.length, duration);
            }
            return results;
        }));


        var tester = new HypothesisTester(tests1);
        var results = tester.doTests(1000);

        var json = new JSONObject(results);
        try {
            FileWriter writer = new FileWriter("results1.json");
            writer.write(json.toString());
            writer.close();
            System.out.println("Successfully wrote to file " + "results1.json");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        tester.tests = tests2;
        results = tester.doTests(10);
        json = new JSONObject(results);
        try {
            FileWriter writer = new FileWriter("results2.json");
            writer.write(json.toString());
            writer.close();
            System.out.println("Successfully wrote to file " + "results2.json");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        tester.tests = tests3;
        results = tester.doTests(allMatrices.solutionVectors.size());
        json = new JSONObject(results);
        try {
            FileWriter writer = new FileWriter("results3.json");
            writer.write(json.toString());
            writer.close();
            System.out.println("Successfully wrote to file " + "results3.json");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}