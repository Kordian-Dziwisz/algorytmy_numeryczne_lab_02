package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MatricesList {

    public ArrayList<double[][]> TgMatrices = new ArrayList<double[][]>();
    public ArrayList<double[][]> TwMatrices = new ArrayList<double[][]>();
    public ArrayList<double[][]> TwSparseMatrices = new ArrayList<double[][]>();

    public ArrayList<double[][]> ConstantMatrices = new ArrayList<double[][]>();

    public ArrayList<double[][]> ConstantBandMatrices = new ArrayList<double[][]>();

    public ArrayList<double[]> solutionVectors= new ArrayList<double[]>();

    public void GenerateConstant(int initialSize, int step, int maxSize, int numNonZero){
        ConstantMatrices.clear();
        for (int i = initialSize; i<= maxSize; i += step){
            ConstantMatrices.add(helper.generateNonZero(i, i, numNonZero));
        }
    }

    public void GenerateConstantBand(int initialSize, int step, int maxSize, int numNonZero){
        ConstantMatrices.clear();
        for (int i = initialSize; i<= maxSize; i += step){
            ConstantMatrices.add(helper.generateNonZeroBand(i, i, numNonZero));
        }
    }
    public void GenerateTg(int initialSize, int step, int maxSize){
        TgMatrices.clear();
        for (int i = initialSize; i <= maxSize; i += step){
            TgMatrices.add(helper.generateMatrix(i, i));
        }
    }

    public void GenerateTw(int initialSize, int step, int maxSize, int bandSize){
        TwMatrices.clear();
        for (int i = initialSize; i <= maxSize; i += step){
            TwMatrices.add(helper.generateRandomBandMatrix(i, i, bandSize));
        }
    }

    public void GenerateTwSparse(int initialSize, int step, int maxSize, int bandSize){
        TwSparseMatrices.clear();
        for (int i = initialSize; i <= maxSize; i += step){
            TwSparseMatrices.add(helper.generateSparseBandMatrix(i, i, bandSize));
        }
    }

    public void GenerateSolutionVectors(int initialSize, int step, int maxSize){
        solutionVectors.clear();
        for (int i = initialSize; i <= maxSize; i += step){
            solutionVectors.add(helper.generateRandomVector(i));
        }
    }
    public double[][] getTgMatrix(int index){
        return TgMatrices.get(index);
    }

    public double[][] getTwMatrix(int index){ return TwMatrices.get(index); }

    public double[][] getTwSparseMatrix(int index){
        return TwSparseMatrices.get(index);
    }

    public double[] getSolutionVector(int index){
        return solutionVectors.get(index);
    }

    public double[][] getConstantMatrix(int index) { return ConstantMatrices.get(index); }

    public double[][] getConstantBandMatrix(int index) { return ConstantBandMatrices.get(index); }

}
