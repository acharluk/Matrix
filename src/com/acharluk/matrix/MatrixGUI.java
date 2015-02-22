package com.acharluk.matrix;

import javax.swing.*;
import java.awt.*;
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
    private JButton substractButton;

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
                Matrix matrix1 = MatrixUtil.getMatrix(textArea1);
                Matrix matrix2 = MatrixUtil.getMatrix(textArea3);

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
                Matrix matrix1 = MatrixUtil.getMatrix(textArea1);
                Matrix matrix2 = MatrixUtil.getMatrix(textArea3);

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
                textArea2.setText(String.valueOf(MatrixUtil.getMatrix(textArea1).determinant()));
            }
        });
        substractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Matrix matrix1 = MatrixUtil.getMatrix(textArea1);
                Matrix matrix2 = MatrixUtil.getMatrix(textArea3);

                Matrix result = null;
                try {
                    result = matrix1.substract(matrix2);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                textArea2.setText(MatrixUtil.print2(result));
            }
        });
    }
}
