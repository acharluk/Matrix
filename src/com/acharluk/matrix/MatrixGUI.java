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
                System.out.println(textArea1.getText());
                System.out.println(textArea3.getText());
                print(Main.multiply(readMatrixFromGUI(ma), readMatrixFromGUI(mb)));
            }
        });
    }

    public int[][] readMatrixFromGUI(String m) {

        int sizeX = (int) Math.sqrt(m.length());
        int sizeY = sizeX;

        //Create matrix
        int[][] matrix = new int[sizeX][sizeY];

        String[] nums = m.split("");
        int[] numsInt = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int k = 0;
            if (nums[k] == "" || nums[k] == " " || nums[k] == "\n") {
                nums[k] = nums[k].substring(1);
            } else {
                try {
                    numsInt[i] = Integer.parseInt(nums[k]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                k++;
            }
        }
        int k = 0;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                    matrix[i][j] = numsInt[k];
                    k++;
            }
        }
        return matrix;
    }

    public void print(int[][] a) {
        String res = "";
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
                res = res.concat(a[i][j] + " ");
            }
            System.out.println();
            res = res.concat("\n");
        }
        System.out.println("RES: " + res);
        textArea2.setText(res);
    }

}
