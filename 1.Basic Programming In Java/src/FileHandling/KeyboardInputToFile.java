package FileHandling;

import java.io.*;
import java.util.Scanner;

public class KeyboardInputToFile {
	public static void main(String[] args) {
        String fileName = "C:\\Users\\User\\eclipse-workspace\\Lab_Assignment_1\\src\\FileHandling\\Output.txt";
        boolean continueWriting = true;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Enter lines to write to the file. Type 'quit' to exit.");

            while (continueWriting) {
                String line = reader.readLine();
                if (line.equalsIgnoreCase("quit")) {
                    continueWriting = false;
                } else {
                    writer.write(line);
                    writer.newLine(); // Add a newline character to separate lines in the file
                }
            }

            System.out.println("Lines written to the file successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
