package Lab_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StudentRecordForm extends JFrame {

    private JTextField firstNameField, lastNameField, ageField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private JComboBox<String> facultyComboBox, semesterComboBox;
    private JTextArea remarksArea;

    public StudentRecordForm() {
        // Set up the frame
        setTitle("Student Record Form");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        firstNameField = new JTextField(15);
        lastNameField = new JTextField(15);
        ageField = new JTextField(5);

        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        String[] faculties = {"Science", "Management", "Arts"};
        facultyComboBox = new JComboBox<>(faculties);

        String[] semesters = {"First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh", "Eighth"};
        semesterComboBox = new JComboBox<>(semesters);

        remarksArea = new JTextArea(5,10);
        JScrollPane remarksScrollPane = new JScrollPane(remarksArea);

        // Create menus
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem resetMenuItem = new JMenuItem("Reset");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        fileMenu.add(saveMenuItem);
        fileMenu.add(resetMenuItem);
        fileMenu.add(exitMenuItem);

        // Create toolbars
        JToolBar toolBar = new JToolBar();
        add(toolBar, java.awt.BorderLayout.PAGE_START);

        JButton saveButton = new JButton("Save");
        JButton resetButton = new JButton("Reset");
        JButton exitButton = new JButton("Exit");

        toolBar.add(saveButton);
        toolBar.add(resetButton);
        toolBar.add(exitButton);

        // Add components to the layout
        setLayout(new GridLayout(15,15,15,15));

        add(new JLabel("The Table"));
        add(new JLabel("First Name:"));
        add(firstNameField);
        add(new JLabel("Last Name:"));
        add(lastNameField);
        add(new JLabel("Age:"));
        add(ageField);
        add(new JLabel("Gender:"));
        add(new JPanel()); // Placeholder for radio buttons
        add(maleRadioButton);
        add(femaleRadioButton);
        add(new JLabel("Faculty:"));
        add(facultyComboBox);
        add(new JLabel("Semester:"));
        add(semesterComboBox);
        add(new JLabel("Remarks:"));
        add(remarksScrollPane);

        // Add action listeners to menu items and buttons
        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        resetMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });

        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile(); // Save before exiting
                System.exit(0);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile(); // Save before exiting
                System.exit(0);
            }
        });
    }

    private void saveToFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileChooser.getSelectedFile()))) {
                writer.write("First Name: " + firstNameField.getText() + "\n");
                writer.write("Last Name: " + lastNameField.getText() + "\n");
                writer.write("Age: " + ageField.getText() + "\n");
                writer.write("Gender: " + (maleRadioButton.isSelected() ? "Male" : "Female") + "\n");
                writer.write("Faculty: " + facultyComboBox.getSelectedItem() + "\n");
                writer.write("Semester: " + semesterComboBox.getSelectedItem() + "\n");
                writer.write("Remarks: " + remarksArea.getText() + "\n");

                JOptionPane.showMessageDialog(this, "Record saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving record.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void resetForm() {
        firstNameField.setText("");
        lastNameField.setText("");
        ageField.setText("");
        maleRadioButton.setSelected(false);
        femaleRadioButton.setSelected(false);
        facultyComboBox.setSelectedIndex(0);
        semesterComboBox.setSelectedIndex(0);
        remarksArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentRecordForm form = new StudentRecordForm();
            form.setVisible(true);
        });
    }
}
