package com.acharluk.matrix;

import java.util.Scanner;

public class Main {

    public static boolean DEBUG = true;

    public static void main(String[] args) {
        //new MatrixGUI();
        //print(multiply(readMatrix(),readMatrix()));

        new Main();
    }

    public Main() {
        Matrix m1 = Matrix.read();
        Matrix m2 = Matrix.read();
        Matrix res = m1.multiply(m2);
        res.print();
    }

}
