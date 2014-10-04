package com.acharluk.matrix;

import java.util.Scanner;

/**
 * Created by ACharLuk on 25/09/2014.
 */
public class Matrix {

    private int[][] matrix;
    private int size;

    public Matrix(int[] mat, int mSize) {
        size = mSize;
        matrix = new int[size][size];
        clear();
        int k = 0;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1; j++) {
                matrix[i][j] = mat[k];
                k++;
            }
        }
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public static Matrix read() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Matrix size: ");
        int size = scanner.nextInt();
        System.out.print("Matrix: ");
        String s = scanner.next();
        String[] ss = s.split(" ");
        int[] mat = new int[size];

        for (int i = 0; i < s.length(); i++) {
            mat[i] = Integer.parseInt(ss[i]);
        }
        Matrix m = new Matrix(mat, size);

        return m;
    }

    public Matrix multiply(Matrix mat) {
        Matrix result = new Matrix(new int[size], size);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int res = 0;

                for (int k = 0; k < matrix[i].length; k++) {
                    res += matrix[i][k] * mat.matrix[k][j];
                }
                result.matrix[i][j] = res;
                System.out.println("result[" + i + "][" + j + "] = " + result.matrix[i][j]);
            }
        }
        return result;
    }

    public void print() {
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void clear() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
    }

}
