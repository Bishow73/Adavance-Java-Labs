package Lab_2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridLayoutSimpleInterest extends JFrame {

    private JTextField principalField;
    private JTextField rateField;
    private JTextField timeField;
    private JTextField resultField;

    public GridLayoutSimpleInterest() {
        // Set up the frame
        setTitle("Simple Interest Calculator (GridLayout)");
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

        // Set up GridLayout
        setLayout(new java.awt.GridLayout(5, 2, 10, 10));

        // Add components to the frame
        add(principalLabel);
        add(principalField);
        add(rateLabel);
        add(rateField);
        add(timeLabel);
        add(timeField);
        add(calculateButton);
        add(new JLabel()); // Empty cell for spacing
        add(resultLabel);
        add(resultField);
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
                new GridLayoutSimpleInterest().setVisible(true);
            }
        });
    }
}
