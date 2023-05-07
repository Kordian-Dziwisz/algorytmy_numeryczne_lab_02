package org.example;

import java.util.Arrays;

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
        System.out.println("\n\n");

        m2.become(testMatrix);
        m2.print();
        solution = m2.GEPP(b);
        System.out.println();
        m2.print();
        System.out.println();
        System.out.println(Arrays.toString(solution));
    }
}