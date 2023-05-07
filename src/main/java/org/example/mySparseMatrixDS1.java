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
    public void GENP(double[] b) {

    }

    public double[] GEPP(double[] b) {
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

            // pivot within A and B
            // for each row after current
            for (int i = k + 1; i < N; i++){
                double factor = getElement(i, k) / getElement(k,k);
                b[i] -= factor * b[k];
                // for each column in row
                for (int j = k; j < N; j++){
                    setElement(i, j, getElement(i,j) - (factor * getElement(k, j)));
                }
            }
        }
        double[] solution = new double[N];
        for (int i = N - 1; i >= 0; i--){
            double sum = 0.0;
            for (int j = i + 1; j < N; j++){
                sum += getElement(i,j) * solution[j];
            }
            solution[i] = (b[i] - sum) / getElement(i, i);
        }
        return solution;
    }
}