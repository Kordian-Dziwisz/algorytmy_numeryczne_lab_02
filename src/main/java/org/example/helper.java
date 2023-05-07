package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class helper {
    public static double[][] readMatrixFromCsv(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            int rows = 0;
            int cols = 0;

            // Determine number of rows and columns in matrix
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                cols = row.length;
                rows++;
            }

            // Allocate memory for matrix
            double[][] matrix = new double[rows][cols];

            // Read data from file into matrix
            br = new BufferedReader(new FileReader(filename));
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = Double.parseDouble(row[j]);
                }
                i++;
            }

            br.close();
            return matrix;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void saveMatrixToFile(double[][] matrix, String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            for (double[] row : matrix) {
                for (double element : row) {
                    fw.write(Double.toString(element));
                    fw.write(",");
                }
                fw.write("\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double[][] generateRandomBandMatrix(int n, int m, int b) {
        double[][] matrix = new double[n][m];
        Random rand = new Random();
        int valueRange = (int)Math.pow(2, 16); // zakres wartości
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Math.abs(i - j) <= b) {
                    matrix[i][j] = (rand.nextInt(valueRange * 2) - valueRange)/ Math.pow(2, 16);
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }

    public static double[] generateRandomVector(int n){
        double[] v = new double[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++){
            v[i] = (rand.nextInt((int)Math.pow(2, 16) * 2) - (int)Math.pow(2, 16))/ Math.pow(2, 16);
        }

        return v;
    }

    public static double[] matrixVectorMultiply(double[][] A, double[] X){
        double[] res = new double[X.length];

        for(int i = 0; i < A.length; i++){
            double sum = 0;
            for (int j = 0; j < X.length; j++){
                sum += A[i][j] * X[j];
            }
            res[i] = sum;
        }

        return res;
    }

    public static double[][] generateMatrix(int n, int m){
        double[][] matrix = new double[n][m];
        Random rand = new Random();
        int valueRange = (int)Math.pow(2, 16); // zakres wartości
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = (rand.nextInt(valueRange * 2) - valueRange)/ Math.pow(2, 16);
            }
        }
        return matrix;
    }

    public static double[][] generateSparseBandMatrix(int n, int m, int b){
        double[][] matrix = new double[n][m];
        Random rand = new Random();
        int valueRange = (int)Math.pow(2, 16); // zakres wartości
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Math.abs(i - j) <= b) {
                    matrix[i][j] = (rand.nextInt(valueRange * 2) - valueRange)/ Math.pow(2, 16);
                } else {
                    if(rand.nextInt(2)==1){
                        matrix[i][j] = (rand.nextInt(valueRange * 2) - valueRange)/ Math.pow(2, 16);
                    } else {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        return matrix;
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
