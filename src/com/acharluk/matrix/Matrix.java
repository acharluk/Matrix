package com.acharluk.matrix;

import java.util.Scanner;

/**
 * Created by ACharLuk on 25/09/2014.
 */
public class Matrix {

    private int[][] matrix;
    private int row, col;

    public Matrix(int[] mat, int row, int col) {
        this.row = row;
        this.col = col;
        matrix = new int[row][col];
        clear();
        int k = 0;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                matrix[i][j] = mat[k];
                k++;
            }
        }
    }

    public Matrix(int[][] mat) {
        row = mat.length;
        col = mat[0].length;
        matrix = mat;
    }

    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        matrix = new int[row][col];
        clear();
    }

    public void setSize(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public Matrix multiply(Matrix mat) {
        if (col != mat.row) {
            System.out.println("Not compatible");
        } else {
            Matrix result = new Matrix(row, mat.col);
            for (int i = 0; i < result.row; i++) {
                for (int j = 0; j < result.col; j++) {
                    for (int k = 0; k < col; k++) {
                        result.matrix[i][j] += matrix[i][k] * mat.matrix[k][j];
                    }
                    //System.out.println("result[" + i + "][" + j + "] = " + result.matrix[i][j]);
                }
            }
            return result;
        }
        return null;
    }

    public void clear() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
    }

}
