package Database;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudentCRUD extends JFrame {
    private JTextField idField, nameField, districtField,ageField;
    private JButton addButton, updateButton, deleteButton, fetchButton, showAllButton;
    private Connection connection;
    private DefaultTableModel tableModel;
    private JTable table;

    public StudentCRUD() {
        initializeUI();
        initDatabase();
    }

    private void initializeUI() {
        setTitle("CRUD Application");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(7,2));
        

        idField = new JTextField();
        idField.setBounds(50,100,200,200);
        nameField = new JTextField();
 nameField.setBounds(50,150,200,30);
        ageField = new JTextField();
ageField.setBounds(50,200,200,30);
        districtField =new JTextField();
districtField.setBounds(50,250,200,30);
        

        addButton = new JButton("Add");
    addButton.setBounds(50,300,200,30);
        updateButton = new JButton("Update");
   updateButton.setBounds(50,300,200,30);
        deleteButton = new JButton("Delete");
     deleteButton.setBounds(50,350,200,30);
        fetchButton = new JButton("Fetch");
      fetchButton.setBounds(50,350,200,30);
        showAllButton = new JButton("Show All");
showAllButton.setBounds(50,100,350,30);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

        fetchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchStudent();
            }
        });

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllData();
            }
        });

        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("District:"));
        panel.add(districtField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);
        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(fetchButton);
        panel.add(showAllButton);

        add(panel);
        setVisible(true);
    }

    private void initDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Student";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void addStudent() {

        try {
        	int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String district = districtField.getText();
            int age = Integer.parseInt(ageField.getText());
            
            String query = "INSERT INTO Student (id, name, district,age) VALUES( ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
            	statement.setInt(1, id);
            	statement.setString(2, name);
                
                statement.setString(3, district);
                statement.setInt(4, age);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Student added successfully");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error adding person");
        }
        // ... (same as before)
    }

    private void updateStudent() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String district = districtField.getText();
            int age = Integer.parseInt(ageField.getText());

            String query = "UPDATE Student SET name=?, district=?, age=? WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
               
               statement.setString(1, name);
                statement.setString(2, district);
                statement.setInt(3, age);
                statement.setInt(4,id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Student updated successfully");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating person");
        }
        // ... (same as before)
    }

  private void deleteStudent() {
        try {
            int id = Integer.parseInt(idField.getText());

            String query = "DELETE FROM Student WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.executeUpdate();
                JOptionPane.showMessageDialog(this, "Student deleted successfully");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error deleting person");
        }
        // ... (same as before)
    }

  private void fetchStudent() {
        try {
            int id = Integer.parseInt(idField.getText());

            String query = "SELECT * FROM Student WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String name = resultSet.getString("name");
                        String district = resultSet.getString("district");
                        int age = resultSet.getInt("age");
                        nameField.setText(name);
                       districtField.setText(district);
                        ageField.setText(String.valueOf(age));
                    } else {
                        JOptionPane.showMessageDialog(this, "Person not found");
                    }
                }
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching person");
        }
        // ... (same as before)
    }

    private void showAllData() {
        JFrame tableFrame = new JFrame("All Students");
        tableFrame.setSize(400, 300);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("District");
        tableModel.addColumn("Age");

        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        tableFrame.add(scrollPane);

        fetchAllData();

        tableFrame.setVisible(true);
    }

    private void fetchAllData() {
        try {
            String query = "SELECT * FROM Student";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String district = resultSet.getString("district");
                    int age = resultSet.getInt("age");
                    tableModel.addRow(new Object[]{id, name, district, age});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data");
        }
    }
    


    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StudentCRUD();
            }
        });
    }

}


