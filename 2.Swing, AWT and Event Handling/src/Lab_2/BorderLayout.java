package Lab_2;

import javax.swing.*;

public class BorderLayout extends JFrame {

    public BorderLayout() {
        // Set up the frame
        setTitle("BorderLayout Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create buttons
        JButton northButton = new JButton("TOP");
        JButton southButton = new JButton("BOTTOM");
        JButton eastButton = new JButton("RIGHT");
        JButton westButton = new JButton("LEFT");
        JButton centerButton = new JButton("CENTER");

        // Set up BorderLayout
        setLayout(new java.awt.BorderLayout());

        // Add buttons to the frame with specified regions
        add(northButton, java.awt.BorderLayout.NORTH);
        add(southButton, java.awt.BorderLayout.SOUTH);
        add(eastButton, java.awt.BorderLayout.EAST);
        add(westButton, java.awt.BorderLayout.WEST);
        add(centerButton, java.awt.BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BorderLayout().setVisible(true);
            }
        });
    }
}
