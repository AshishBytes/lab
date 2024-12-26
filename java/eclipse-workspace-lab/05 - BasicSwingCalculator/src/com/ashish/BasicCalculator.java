package com.ashish;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicCalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Basic Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JLabel label1 = new JLabel("Number 1:");
        label1.setBounds(20, 20, 80, 25);
        JTextField num1Field = new JTextField();
        num1Field.setBounds(100, 20, 100, 25);

        JLabel label2 = new JLabel("Number 2:");
        label2.setBounds(20, 60, 80, 25);
        JTextField num2Field = new JTextField();
        num2Field.setBounds(100, 60, 100, 25);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(20, 100, 80, 25);
        JTextField resultField = new JTextField();
        resultField.setBounds(100, 100, 100, 25);
        resultField.setEditable(false);

        JButton addButton = new JButton("Add");
        addButton.setBounds(220, 20, 100, 25);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    resultField.setText(String.valueOf(num1 + num2));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Enter valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setLayout(null);
        frame.add(label1);
        frame.add(num1Field);
        frame.add(label2);
        frame.add(num2Field);
        frame.add(resultLabel);
        frame.add(resultField);
        frame.add(addButton);
        frame.setVisible(true);
    }
}
