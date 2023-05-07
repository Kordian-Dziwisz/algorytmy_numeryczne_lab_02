package org.example;

import java.util.HashMap;
import java.util.List;

import java.util.ArrayList;

public class mySparseMatrixDS2 implements GaussianElimination{
    private int rows; // liczba wierszy
    private int cols; // liczba kolumn
    private List<List<Double>> matrix; // lista opisująca macierz

    // konstruktor
    public mySparseMatrixDS2(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new ArrayList<List<Double>>();
        for (int i = 0; i < rows; i++) {
            List<Double> row = new ArrayList<Double>();
            for (int j = 0; j < cols; j++) {
                row.add(0.0);
            }
            matrix.add(row);
        }
    }

    // metoda ustawiająca wartość elementu w macierzy
    public void setElement(int row, int col, double value) {
        if (value != 0) {
            matrix.get(row).set(col, value);
        }
    }

    // metoda zwracająca wartość elementu w macierzy
    public double getElement(int row, int col) {
        return matrix.get(row).get(col);
    }

    public void GENP(double[] b) {

    }

    public double[] GEPP(double[] b) {
        double[] res = {0.0, 1.0};
        return res;
    }
}