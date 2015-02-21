package com.acharluk.matrix;

import javax.swing.*;

/**
 * Created by ACharLuk on 19/02/2015.
 */
public class MatrixUtil {

    /*
    public static Matrix read() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Matrix rows: ");
        int row = scanner.nextInt();

        System.out.print("Matrix columns: ");
        int col = scanner.nextInt();

        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Matrix: ");
        String s = scanner1.nextLine();

        String[] ss = s.split(" ");

        int[][] mat = new int[row][col];

        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = Integer.parseInt(ss[k].trim());
                k++;
            }
        }
        return new Matrix(mat);
    }
    */

    public static String print2(Matrix mat) {
        String result = "";
        for (int i = 0; i < mat.getRow(); i++) {
            for (int j = 0; j < mat.getCol(); j++) {
                result += mat.getMatrix()[i][j] + " ";
            }
            result+="\n";
        }
        return result;
    }

    public static Matrix getMatrix(JTextArea ta) {
        int row = ta.getLineCount();
        int col = ta.getText().replaceAll("\\s+","").length() / ta.getLineCount();

        String[] s = ta.getText().replaceAll("\n", " ").split(" ");
        int[][] mat = new int[row][col];
        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = Integer.parseInt(s[k]);
                k++;
            }
        }

        return new Matrix(mat);
    }

}
