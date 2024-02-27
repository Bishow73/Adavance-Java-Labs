package Lab_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StudentRecordsForm extends JFrame {

    private JTextField firstNameField, lastNameField, ageField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private ButtonGroup genderGroup;
    private JComboBox<String> facultyComboBox, semesterComboBox;
    private JTextArea remarksTextArea;

    public StudentRecordsForm() {
        setTitle("Student Records Form - Bhaktapur Multiple Campus");
        setSize(550, 460);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        ageField = new JTextField(5);

        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        String[] faculties = {"Science", "Management", "Arts"};
        facultyComboBox = new JComboBox<>(faculties);

        String[] semesters = {"First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh", "Eighth"};
        semesterComboBox = new JComboBox<>(semesters);

        remarksTextArea = new JTextArea(5, 20);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("First Name:"), gbc);

        gbc.gridx = 1;
        add(firstNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Last Name:"), gbc);

        gbc.gridx = 1;
        add(lastNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Age:"), gbc);

        gbc.gridx = 1;
        add(ageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Gender:"), gbc);

        JPanel genderPanel = new JPanel();
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);

        gbc.gridx = 1;
        add(genderPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Faculty:"), gbc);

        gbc.gridx = 1;
        add(facultyComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Semester:"), gbc);

        gbc.gridx = 1;
        add(semesterComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(new JLabel("Remarks:"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        add(new JScrollPane(remarksTextArea), gbc);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveAndExit();
            }
        });

        createMenuBar();
        createToolBar();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem resetMenuItem = new JMenuItem("Reset");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFormToFile();
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
                saveAndExit();
            }
        });

        fileMenu.add(saveMenuItem);
        fileMenu.add(resetMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);
    }

    private void createToolBar() {
        JToolBar toolBar = new JToolBar();

        JButton saveButton = new JButton("Save");
        JButton resetButton = new JButton("Reset");
        JButton exitButton = new JButton("Exit");

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFormToFile();
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
                saveAndExit();
            }
        });

        toolBar.addSeparator();
        toolBar.add(saveButton);
        toolBar.add(resetButton);
        toolBar.add(exitButton);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        add(toolBar, gbc);
    }


    private void saveFormToFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                writer.write("First Name: " + firstNameField.getText() + "\n");
                writer.write("Last Name: " + lastNameField.getText() + "\n");
                writer.write("Age: " + ageField.getText() + "\n");
                writer.write("Gender: " + (maleRadioButton.isSelected() ? "Male" : "Female") + "\n");
                writer.write("Faculty: " + facultyComboBox.getSelectedItem() + "\n");
                writer.write("Semester: " + semesterComboBox.getSelectedItem() + "\n");
                writer.write("Remarks: " + remarksTextArea.getText());

                JOptionPane.showMessageDialog(this, "Form saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Additional debugging
                System.out.println("File saved to: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving form", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }



    private void resetForm() {
        firstNameField.setText("");
        lastNameField.setText("");
        ageField.setText("");
        genderGroup.clearSelection();
        facultyComboBox.setSelectedIndex(0);
        semesterComboBox.setSelectedIndex(0);
        remarksTextArea.setText("");
    }

    private void saveAndExit() {
        int choice = JOptionPane.showConfirmDialog(this, "Do you want to save the form before exiting?",
                "Save and Exit", JOptionPane.YES_NO_CANCEL_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            saveFormToFile();
        } else if (choice == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
        // If the user chooses cancel, do nothing
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentRecordsForm::new);
    }
}

