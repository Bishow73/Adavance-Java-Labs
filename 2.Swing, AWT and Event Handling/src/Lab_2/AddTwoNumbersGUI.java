package Lab_2;


import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;


public class AddTwoNumbersGUI extends JFrame {
private JTextField num1TextField, num2TextField, resultTextField;
private JButton addButton;
public AddTwoNumbersGUI() {
	setTitle("add Two Numbers");
	setSize(400,200);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	
	num1TextField = new JTextField(10);
	num2TextField = new JTextField(10);
	resultTextField = new JTextField(10);
	resultTextField.setEditable(false);
	
	addButton = new JButton("Add");
	
	JPanel inputPanel = new JPanel(new FlowLayout());
	inputPanel.add(new JLabel("Number 1:"));
	inputPanel.add(num1TextField);
	inputPanel.add(new JLabel("Number 2:"));
	inputPanel.add(num2TextField);
	
	JPanel buttonPanel = new JPanel(new FlowLayout());
	buttonPanel.add(addButton);
	
	JPanel resultPanel = new JPanel(new FlowLayout());
	resultPanel.add(new JLabel("Result:"));
	resultPanel.add(resultTextField);
	
	Container contentPane = getContentPane();
	contentPane.setLayout(new BorderLayout());
	contentPane.add(inputPanel, BorderLayout.NORTH);
	contentPane.add(buttonPanel, BorderLayout.CENTER);
	contentPane.add(resultPanel, BorderLayout.SOUTH);
	
	setResizable(false);
}

public static void main(String[] args) {
	AddTwoNumbersGUI calculator = new AddTwoNumbersGUI();
	calculator.setVisible(true);
}
}
