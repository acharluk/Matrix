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

    public String ma,mb;

    /*
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
                ma = textArea1.getText();
                mb = textArea3.getText();

                String[] sp1 = ma.split(" ");
                String[] sp2 = mb.split(" ");

                int[] num1 = new int[sp1.length];
                int[] num2 = new int[sp2.length];

                for (int i = 0; i < sp1.length; i++) {
                    num1[i] = Integer.parseInt(sp1[i]);
                }

                for (int i = 0; i < sp1.length; i++) {
                    num2[i] = Integer.parseInt(sp2[i]);
                }

                Matrix m1 = new Matrix(num1, (int) Math.sqrt(num1.length) / 2, (int) Math.sqrt(num1.length) / 2);
                Matrix m2 = new Matrix(num2, (int) Math.sqrt(num2.length) / 2, (int) Math.sqrt(num2.length) / 2);
                Matrix result = m1.multiply(m2);
                textArea2.setText(result.print2());
            }
        });
    }
    */

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

            }
        });
    }
}
