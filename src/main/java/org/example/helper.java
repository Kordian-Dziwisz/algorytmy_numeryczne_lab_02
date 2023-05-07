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

    public static double[][] generateRandomMatrix(int n, int m, double density) {
        Random random = new Random();
        double[][] matrix = new double[n][m];

        // Fill matrix with zeros
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = 0.0;
            }
        }

        // Generate random non-zero elements
        int numNonZeros = (int) Math.round(density * n * m);
        for (int k = 0; k < numNonZeros; k++) {
            int i = random.nextInt(n);
            int j = random.nextInt(m);
            double value = random.nextDouble();
            matrix[i][j] = value;
        }

        return matrix;
    }

    public static double[][] generateRandomBandMatrix(int n, int bandwidth) {
        Random random = new Random();
        double[][] matrix = new double[n][n];

        // Fill matrix with zeros
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0.0;
            }
        }

        // Generate random non-zero elements within bandwidth
        for (int i = 0; i < n; i++) {
            for (int j = Math.max(0, i - bandwidth); j <= Math.min(n - 1, i + bandwidth); j++) {
                double value = random.nextDouble();
                matrix[i][j] = value;
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
