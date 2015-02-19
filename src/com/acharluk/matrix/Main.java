package com.acharluk.matrix;

public class Main {

    public static void main(String[] args) {
        new MatrixGUI();

        //new Main();
    }

    public Main() {
        Matrix m1 = Matrix.read();
        Matrix m2 = Matrix.read();
        Matrix res = m1.multiply(m2);
        res.print();
    }

}
