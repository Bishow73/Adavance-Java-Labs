package Lab_2;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

public class MultiplyUsingSwing extends JFrame implements ActionListener {

JLabel l1 = new JLabel("First No:");

JTextField t1 = new JTextField(10);

JLabel l2 = new JLabel("Second No:");

JTextField t2 = new JTextField(10);
JButton b = new JButton("Add");
JTextField t3 = new JTextField(10);
String fno = "";

String sno = "";

public MultiplyUsingSwing() {

setLayout(new FlowLayout());

setSize(250, 250);

setVisible(true);

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

add(l1);

add(t1);

add(l2);

add(t2);

t3.setEditable(false);

add(t3);

add(b);

b.addActionListener(this);

}


public void actionPerformed(ActionEvent e) {

int f = Integer.parseInt(t1.getText());

int s = Integer.parseInt(t2.getText());

int r = f + s;

t3.setText("" + r);

}

public static void main(String[] args) {

new MultiplyUsingSwing();

} }


