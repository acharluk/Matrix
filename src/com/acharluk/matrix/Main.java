package com.acharluk.matrix;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
    }

    //Multiply matrix a with matrix b
    //Returns an int[][] result
    public static int[][] multiply(int[][] a, int[][] b) {
        int result[][] = new int[a.length][b.length];
        //Calcs here
        return result;
    }

    //Print matrix with format
    public static void print(int[][] a) {
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    //Read matrix from user input and save it
    public static int[][] readMatrix() {
        Scanner sc = new Scanner(System.in);
        //Transform input String to int[][]
    }

}
