package com.ashish;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
 
public class AdvancedCalculator { 
    public static void main(String[] args) { 
        // Create the main frame 
        JFrame frame = new JFrame("Advanced Calculator"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(400, 500); 
        frame.setLayout(null); 
 
        // Create a display area 
        JTextField displayField = new JTextField(); 
        displayField.setBounds(20, 20, 340, 50); 
        displayField.setFont(new Font("Arial", Font.BOLD, 24)); 
        displayField.setHorizontalAlignment(JTextField.RIGHT); 
        displayField.setEditable(false); 
        frame.add(displayField); 
 
        // Button labels for calculator 
        String[] buttonLabels = { 
            "7", "8", "9", "/", 
            "4", "5", "6", "*", 
            "1", "2", "3", "-", 
            "0", ".", "=", "+" 
        }; 
 
        // Create buttons 
        JButton[] buttons = new JButton[buttonLabels.length]; 
        int x = 20, y = 90; 
        for (int i = 0; i < buttonLabels.length; i++) { 
            buttons[i] = new JButton(buttonLabels[i]); 
            buttons[i].setBounds(x, y, 80, 50); 
            buttons[i].setFont(new Font("Arial", Font.BOLD, 18)); 
            frame.add(buttons[i]); 
            x += 90; 
            if ((i + 1) % 4 == 0) { 
                x = 20; 
                y += 60; 
            } 
        } 
 
        // Action listeners for calculator logic 
        final StringBuilder currentInput = new StringBuilder(); 
        final double[] result = {0}; 
        final String[] operator = {""}; 
        final boolean[] isResultDisplayed = {false}; 
 
        for (JButton button : buttons) { 
            button.addActionListener(new ActionListener() { 
                @Override 
                public void actionPerformed(ActionEvent e) { 
                    String text = button.getText(); 
 
                    if (isResultDisplayed[0] && "0123456789.".contains(text)) { 
                        // Clear display if a number is entered after result 
                        currentInput.setLength(0); 
                        isResultDisplayed[0] = false; 
                    } 
 
                    if ("0123456789.".contains(text)) { 
                        currentInput.append(text); 
                        displayField.setText(currentInput.toString()); 
                    } else if ("+-*/".contains(text)) { 
                        if (currentInput.length() > 0) { 
                            if (!isResultDisplayed[0]) { 
                                result[0] = Double.parseDouble(currentInput.toString()); 
                            } 
                            currentInput.setLength(0); 
                        } 
                        operator[0] = text; 
                        displayField.setText(displayField.getText() + " " + operator[0] + " "); 
                        isResultDisplayed[0] = false; 
                    } else if ("=".equals(text)) { 
                        if (currentInput.length() > 0 && !operator[0].isEmpty()) { 
                            double secondOperand = Double.parseDouble(currentInput.toString()); 
                            switch (operator[0]) { 
                                case "+": 
                                    result[0] += secondOperand; 
                                    break; 
                                case "-": 
                                    result[0] -= secondOperand; 
                                    break; 
                                case "*": 
                                    result[0] *= secondOperand; 
                                    break; 
                                case "/": 
                                    if (secondOperand != 0) { 
                                        result[0] /= secondOperand; 
                                    } else { 
                                        displayField.setText("Error"); 
                                        currentInput.setLength(0); 
                                        operator[0] = ""; 
                                        return; 
                                    } 
                                    break; 
                            } 
                            displayField.setText(String.valueOf(result[0])); 
                            currentInput.setLength(0); 
                            operator[0] = ""; 
                            isResultDisplayed[0] = true; 
                        } 
                    } 
                } 
            }); 
        } 
 
        // Make the frame visible 
        frame.setVisible(true); 
    } 
} 