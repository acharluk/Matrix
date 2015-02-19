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

                /* Matrix 1 */
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

                /* Matrix 2 */
                int row2 = textArea3.getLineCount();
                int col2 = textArea3.getText().replaceAll("\\s+","").length() / textArea3.getLineCount();

                String[] s2 = textArea3.getText().replaceAll("\n", " ").split(" ");
                int[][] mat2 = new int[row1][col1];
                int k2 = 0;
                for (int i = 0; i < row2; i++) {
                    for (int j = 0; j < col2; j++) {
                        mat2[i][j] = Integer.parseInt(s2[k2]);
                        k2++;
                    }
                }

                /* Create matrices and multiply them */
                Matrix matrix1 = new Matrix(mat1);
                Matrix matrix2 = new Matrix(mat2);
                Matrix result = matrix1.multiply(matrix2);

                textArea2.setText(MatrixUtil.print2(result));
            }
        });
    }
}
