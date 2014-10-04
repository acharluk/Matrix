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
                /*
                ma = textArea1.getText();
                mb = textArea3.getText();
                System.out.println(textArea1.getText());
                System.out.println(textArea3.getText());
                */
            }
        });
    }
}
