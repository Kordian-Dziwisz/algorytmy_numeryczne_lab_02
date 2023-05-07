package org.example;

import java.util.*;

public class mySparseMatrixDS2 implements GaussianElimination{
    private int rows; // liczba wierszy
    private int cols; // liczba kolumn
    private List<Map<Integer, Double>> matrix; // lista opisująca macierz

    // konstruktor
    public mySparseMatrixDS2() {
        matrix = new ArrayList<>();
    }

    public void become(double[][] A){
        matrix.clear();
        rows = A.length;
        cols = A[0].length;
        for (int i = 0; i < A.length; i++){
            matrix.add(new HashMap<Integer, Double>());
            for (int j = 0; j < A[i].length; j++){
                setElement(i, j, A[i][j]);
            }
        }
    }
    public double getElement(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("Invalid row or column index");
        }

        Map<Integer, Double> rowMap = matrix.get(row);
        return rowMap.getOrDefault(col, 0.0);
    }

    public void setElement(int row, int col, double value) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            throw new IndexOutOfBoundsException("Invalid row or column index");
        }

        Map<Integer, Double> rowMap = matrix.get(row);
        if (value != 0.0) {
            rowMap.put(col, value);
        }else{
            rowMap.remove(col);
        }
    }

    public void swapRows(int row1, int row2) {
        if (row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows) {
            throw new IllegalArgumentException("Invalid row indices");
        }

        // Swap rows in matrix
        Map<Integer, Double> tempRow = matrix.get(row1);
        matrix.set(row1, matrix.get(row2));
        matrix.set(row2, tempRow);
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            Map<Integer, Double> rowMap = this.matrix.get(i);
            for (int j = 0; j < cols; j++) {
                System.out.print(rowMap.getOrDefault(j, 0.0) + " ");
            }
            System.out.println();
        }
    }

    public double[] GENP(double[] toSolve) {
        double[] b = toSolve.clone();
        int N = b.length;
        // for each column
        for (int k = 0; k < N; k++){
            // for each row after current
            eliminate(b, N, k);
        }
        return solve(b, N);
    }

    public double[] GEPP(double[] toSolve) {
        double[] b = toSolve.clone();
        int N = b.length;
        // for each column
        for (int k = 0; k < N; k++){

            int max = k;
            // for each row
            for (int i = k; i < N; i++) {
                if (Math.abs(getElement(i, k)) > Math.abs(getElement(max, k))) {
                    max = i;
                }
            }
            // swap rows in A matrix
            swapRows(k, max);

            // swap values in b
            double t = b[k];
            b[k] = b[max];
            b[max] = t;

            // for each row after current
            eliminate(b, N, k);
        }
        return solve(b, N);
    }

    private void eliminate(double[] b, int n, int k) {
        for (int i = k + 1; i < n; i++){
            double factor = getElement(i, k) / getElement(k,k);
            b[i] -= factor * b[k];
            // for each column in row
            for (int j = k; j < n; j++){
                setElement(i, j, getElement(i,j) - (factor * getElement(k, j)));
            }
        }
    }

    private double[] solve(double[] b, int n) {
        double[] solution = new double[n];
        for (int i = n - 1; i >= 0; i--){
            double sum = 0.0;
            for (int j = i + 1; j < n; j++){
                sum += getElement(i,j) * solution[j];
            }
            solution[i] = (b[i] - sum) / getElement(i, i);
        }
        return solution;
    }

    public int getRows(){
        return rows;
    }

    public int getCols(){
        return cols;
    }
}