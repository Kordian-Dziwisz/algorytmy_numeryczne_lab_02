package org.example;

import java.util.HashMap;
import javafx.util.Pair;

public class mySparseMatrixDS1 implements GaussianElimination{
    private int rows; // liczba wierszy
    private int cols; // liczba kolumn
    private final HashMap<Pair<Integer, Integer>, Double> matrix; // słownik opisujący macierz

    // konstruktor
    public mySparseMatrixDS1() {
        matrix = new HashMap<Pair<Integer, Integer>, Double>();
    }

    public void become(double[][] A){
        matrix.clear();
        rows = A.length;
        cols = A[0].length;
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A[i].length; j++){
                setElement(i, j, A[i][j]);
            }
        }
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(getElement(i, j) + " ");
            }
            System.out.println();
        }
    }
    // metoda ustawiająca wartość elementu w macierzy
    public void setElement(int row, int col, double value) {
        Pair<Integer, Integer> key = new Pair<Integer, Integer>(row, col);
        if (value != 0) {
            matrix.put(key, value);
        } else {
            matrix.remove(key);
        }
    }

    // metoda zwracająca wartość elementu w macierzy
    public double getElement(int row, int col) {
        Pair<Integer, Integer> key = new Pair<Integer, Integer>(row, col);
        if (matrix.containsKey(key)) {
            return matrix.get(key);
        } else {
            return 0;
        }
    }

    public void swapRows(int row1, int row2){
        for (int j = 0; j < cols; j++){
            double temp = getElement(row1, j);
            setElement(row1, j, getElement(row2, j));
            setElement(row2, j, temp);
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
}