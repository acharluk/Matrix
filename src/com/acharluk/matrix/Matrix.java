package com.acharluk.matrix;

import java.util.Scanner;

/**
 * Created by ACharLuk on 25/09/2014.
 */
public class Matrix {

    private int[][] matrix;
    private int fil, col;

    public Matrix(int[] mat, int fil, int col) {
        this.fil = fil;
        this.col = col;
        matrix = new int[fil][col];
        clear();
        int k = 0;
        for (int i = 1; i < fil; i++) {
            for (int j = 1; j < col; j++) {
                matrix[i][j] = mat[k];
                k++;
            }
        }
    }

    public Matrix(int[][] mat) {
        fil = mat.length;
        col = mat[0].length;
        matrix = mat;
    }

    public Matrix(int fil, int col) {
        this.fil = fil;
        this.col = col;
        matrix = new int[fil][col];
        clear();
    }

    public void setSize(int fil, int col) {
        this.fil = fil;
        this.col = col;
    }

    public int getFil() {
        return fil;
    }

    public int getCol() {
        return col;
    }

    public static Matrix read() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Matrix fil: ");
        int fil = scanner.nextInt();

        System.out.print("Matrix col: ");
        int col = scanner.nextInt();

        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Matrix: ");
        String s = scanner1.nextLine();

        String[] ss = s.split(" ");

        int[][] mat = new int[fil][col];

        for (int i = 0; i < fil - 1; i++) {
            for (int j = 0; j < col - 1; j++) {
                mat[i][j] = Integer.parseInt(ss[i].trim());
                System.out.println(ss[i].trim());
            }
        }
        return new Matrix(mat);
    }

    public Matrix multiply(Matrix mat) {
        Matrix result = new Matrix(mat.fil, col);
        for (int i = 0; i < mat.fil; i++){
            for (int j = 0; j < col; j++) {
                result.matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < result.fil; i++) {
            for (int j = 0; j < result.col; j++) {
                int res = 0;
                for (int k = 0; k < col; k++) {
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
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String print2() {
        String result = null;
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result += matrix[i][j];
            }
            System.out.println();
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
