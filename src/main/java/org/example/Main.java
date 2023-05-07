package org.example;
public class Main {
    public static void main(String[] args) {

        double[][] testMatrix = helper.generateRandomBandMatrix(8, 1);
//        helper.printMatrix(testMatrix);
        mySparseMatrixDS1 m1 = new mySparseMatrixDS1();
        m1.become(testMatrix);
        m1.print();
        double[] b = {0, 1, 0, 0, 0, 1, 1, 0};
        double[] solution = m1.GEPP(b);
        System.out.println();
        m1.print();
        int N = solution.length;
        System.out.println("\n Solution : ");
        for (int i = 0; i < N; i++)
            System.out.printf("%.3f ", solution[i]);
        System.out.println();
    }
}