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

    public Matrix multiply(Matrix mat) throws Exception {
        if (col != mat.row) {
            throw new Exception("Matrices cannot be multiplied");
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
    }

    public Matrix add(Matrix mat) throws Exception {
        if (col != mat.col || row != mat.row) {
            throw new Exception("Matrices cannot be multiplied");
        } else {
            Matrix result = new Matrix(row, col);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    result.matrix[i][j] = matrix[i][j] + mat.matrix[i][j];
                }
            }
            return result;
        }
    }

    public int determinant() {
        int result = 0;
        if (row == 2 && col == 2) {
          result = matrix[0][0] * matrix[1][1] -
                  matrix[0][1] * matrix[1][0];
        } else if (row == 3 && col == 3) {
            result = matrix[0][0] * matrix[1][1] * matrix[2][2] +
                    matrix[0][2] * matrix[1][0] * matrix[2][1] +
                    matrix[0][1] * matrix[1][2] * matrix[2][0] -
                    matrix[0][2] * matrix[1][1] * matrix[2][0] -
                    matrix[0][0] * matrix[1][2] * matrix[2][1] -
                    matrix[0][1] * matrix[1][0] * matrix[2][2];
        }
        return result;
    }

    public void clear() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
    }

}
