package Lab_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridBagLayoutSimpleInterest extends JFrame {

    private JTextField principalField;
    private JTextField rateField;
    private JTextField timeField;
    private JTextField resultField;

    public GridBagLayoutSimpleInterest() {
        // Set up the frame
        setTitle("Simple Interest Calculator (GridBagLayout)");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel principalLabel = new JLabel("Principal Amount:");
        principalField = new JTextField(10);

        JLabel rateLabel = new JLabel("Interest Rate (%):");
        rateField = new JTextField(10);

        JLabel timeLabel = new JLabel("Time (Years):");
        timeField = new JTextField(10);

        JButton calculateButton = new JButton("Calculate Interest");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateSimpleInterest();
            }
        });

        JLabel resultLabel = new JLabel("Simple Interest:");
        resultField = new JTextField(10);
        resultField.setEditable(false);

        // Set up GridBagLayout
        setLayout(new java.awt.GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 2, 10, 10);

        // Add components to the frame with GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(principalLabel, gbc);

        gbc.gridx = 1;
        add(principalField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(rateLabel, gbc);

        gbc.gridx = 1;
        add(rateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(timeLabel, gbc);

        gbc.gridx = 1;
        add(timeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(calculateButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(resultLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(resultField, gbc);
    }

    private void calculateSimpleInterest() {
        try {
            double principal = Double.parseDouble(principalField.getText());
            double rate = Double.parseDouble(rateField.getText());
            double time = Double.parseDouble(timeField.getText());

            double simpleInterest = (principal * rate * time) / 100;
            resultField.setText(String.valueOf(simpleInterest));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GridBagLayoutSimpleInterest().setVisible(true);
            }
        });
    }
}