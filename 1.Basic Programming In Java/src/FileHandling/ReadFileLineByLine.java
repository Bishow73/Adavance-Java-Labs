package FileHandling;

import java.io.*;


public class ReadFileLineByLine {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\User\\eclipse-workspace\\Lab_Assignment_1\\src\\FileHandling\\Input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
