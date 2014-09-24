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
                System.out.println(textArea1.getText());
                ma = textArea1.getText();
                mb = textArea2.getText();
                //Main.print(Main.multiply(readMatrixFromGUI(ma),readMatrixFromGUI(mb)));
                textArea3.setText(Main.multiply(readMatrixFromGUI(ma),readMatrixFromGUI(mb)).toString());
            }
        });
    }

    public int[][] readMatrixFromGUI(String m) {

        int sizeX = (int) Math.sqrt(m.length());
        int sizeY = sizeX;

        //Create matrix
        int[][] matrix = new int[sizeX][sizeY];

        System.out.print("Enter matrix: ");

        //Check if the input string starts with a space
        while (m.startsWith(" ")) {
            m = m.substring(1);
        }

        String[] nums = m.split(" ");

        int k = 0;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                matrix[i][j] = Integer.parseInt(nums[k]);
                k++;
            }
        }
        return matrix;
    }

}
