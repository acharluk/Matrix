package com.acharluk.matrix;

import java.util.Scanner;

public class Main {

    static boolean DEBUG = false;

    public static void main(String[] args) {
        print(multiply(readMatrix(),readMatrix()));
    }

    //Multiply matrix a with matrix b
    //Returns an int[][] result
    public static int[][] multiply(int[][] a, int[][] b) {
        int result[][] = new int[a.length][b[0].length];

        if (a.length == b[0].length) {
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
        } else {
            System.out.println("Matrices are incompatibles");
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
        //Scanners
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        //Ask for size of the matrix
        int sizeX, sizeY;

        System.out.print("X size: ");
        sizeX = sc1.nextInt();

        System.out.print("Y size: ");
        sizeY = sc1.nextInt();

        //Create matrix
        int[][] matrix = new int[sizeX][sizeY];

        System.out.print("Enter matrix: ");

        //Input matrix as a string
        String str = sc.nextLine();

        //Check if the input string starts with a space
        while (str.startsWith(" ")) {
            if (DEBUG) System.out.println("String starts with ' ', ignoring");
            str = str.substring(1);
        }

        String[] nums = str.split(" ");

        int k = 0;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                matrix[i][j] = Integer.parseInt(nums[k]);
                if (DEBUG) System.out.println("matrix[" + i + "][" + j + "] = " + nums[k]);
                k++;
            }
        }
        return matrix;
    }

}
