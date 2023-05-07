package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        double[][] testMatrix = helper.generateRandomBandMatrix(9, 9, 1);
//        helper.printMatrix(testMatrix);
        mySparseMatrixDS1 m1 = new mySparseMatrixDS1();
        mySparseMatrixDS2 m2 = new mySparseMatrixDS2();
        m1.become(testMatrix);
        m1.print();
        double[] X = helper.generateRandomVector(9);
        double[] b = helper.matrixVectorMultiply(testMatrix, X);
        double[] solution = m1.GEPP(b);
        System.out.println();
        m1.print();
        System.out.println();
        System.out.println(Arrays.toString(solution));
        System.out.println(Arrays.toString(X));
        System.out.println("\n\n");

        m2.become(testMatrix);
        m2.print();
        solution = m2.GEPP(b);
        System.out.println();
        m2.print();
        System.out.println();
        System.out.println(Arrays.toString(solution));

        var tests = new ArrayList<HypothesisTest>();
        tests.add(new HypothesisTest("H1_A1_TG_DS1", tries -> {
            var m = new mySparseMatrixDS1();
            m.become(helper.generateMatrix(10, 10));
            m.print();
            return new HashMap<Integer, Double>();
        }));

        var tester = new HypothesisTester(tests);
    }
}