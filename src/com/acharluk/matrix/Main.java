package com.acharluk.matrix;

import java.util.Scanner;

public class Main {

    static boolean DEBUG = true;

    public static void main(String[] args) {
        print(multiply(readMatrix(),readMatrix()));
    }

    //Multiply matrix a with matrix b
    //Returns an int[][] result
    public static int[][] multiply(int[][] a, int[][] b) {
        int result[][] = new int[a.length][b.length];

        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[i].length; j++)
                result[i][j] = 0;

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                int res = 0;

                for (int k = 0; k < a[i].length; k++) {
                    res += a[i][k] * b[k][j];
                }
                result[i][j] = res;
                if (DEBUG) System.out.println("result[" + i + "][" + j + "] = " + result[i][j]);
            }
        }

        return result;
    }

    //Print matrix with format
    public static void print(int[][] a) {
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Read matrix from user input and save it
    public static int[][] readMatrix() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter matrix: ");

        //Transform input String to int[][]
        String str = sc.nextLine();
        String[] nums = str.split(" ");

        int size = (int) Math.sqrt(nums.length);
        int[][] matrix = new int[size][size];

        int k = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = Integer.parseInt(nums[k]);
                if (DEBUG) System.out.println("matrix[" + i + "][" + j + "] = " + nums[k]);
                k++;
            }
        }
        return matrix;
    }

}
