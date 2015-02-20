package com.acharluk.matrix;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ACharLuk on 24/09/2014.
 */
public class MatrixGUI extends JFrame {
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JButton exitButton;
    private JButton calculateButton;
    private JPanel panel;
    private JButton addButton;
    private JButton determinantButton;

    public MatrixGUI() {
        super("Matrix calculator");
        setContentPane(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Matrix matrix1 = getMatrix1();
                Matrix matrix2 = getMatrix2();

                Matrix result = null;
                try {
                    result = matrix1.multiply(matrix2);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                textArea2.setText(MatrixUtil.print2(result));
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Matrix matrix1 = getMatrix1();
                Matrix matrix2 = getMatrix2();

                Matrix result = null;
                try {
                    result = matrix1.add(matrix2);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                textArea2.setText(MatrixUtil.print2(result));
            }
        });

        determinantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea2.setText(String.valueOf(getMatrix1().determinant()));
            }
        });
    }

    public Matrix getMatrix1() {
        int row1 = textArea1.getLineCount();
        int col1 = textArea1.getText().replaceAll("\\s+","").length() / textArea1.getLineCount();

        String[] s1 = textArea1.getText().replaceAll("\n", " ").split(" ");
        int[][] mat1 = new int[row1][col1];
        int k = 0;
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                mat1[i][j] = Integer.parseInt(s1[k]);
                k++;
            }
        }

        return new Matrix(mat1);
    }

    public Matrix getMatrix2() {
        int row2 = textArea3.getLineCount();
        int col2 = textArea3.getText().replaceAll("\\s+","").length() / textArea3.getLineCount();

        String[] s2 = textArea3.getText().replaceAll("\n", " ").split(" ");
        int[][] mat2 = new int[row2][col2];
        int k2 = 0;
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                mat2[i][j] = Integer.parseInt(s2[k2]);
                k2++;
            }
        }
        return new Matrix(mat2);
    }
}
