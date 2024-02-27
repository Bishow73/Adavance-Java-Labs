package Database;

import java.sql.*;

public class StudentData {
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/student";
        String user = "root";
        String password = "";

        try {
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, user, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // SQL query to select students from Kathmandu district
            String sqlQuery = "SELECT * FROM student WHERE district = 'Kathmandu'";

            // Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // Iterate through the result set and print the names of students
            System.out.println("Students living in Kathmandu district:");
            System.out.println(" ID \t Name \t\t  District \t Age \t");
            while (resultSet.next()) {
            	 String id = resultSet.getInt("ID") + "\t";
                 System.out.print(id);
            	 
                String name = resultSet.getString("name") +"\t";
                System.out.print(name);
                
                String district = resultSet.getString("District") +"\t";
                System.out.print(district); 
                
                String Age = resultSet.getInt("Age")+"\n";
                System.out.print(Age);
            }

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
