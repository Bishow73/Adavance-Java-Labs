package FileHandling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterDuplication {
    public static void main(String[] args) {
        String sourceFileName = "C:\\Users\\User\\eclipse-workspace\\Lab_Assignment_1\\src\\FileHandling\\Input.txt";
        String destinationFileName = "C:\\Users\\User\\eclipse-workspace\\Lab_Assignment_1\\src\\FileHandling\\Duplicate.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFileName));
             FileWriter writer = new FileWriter(destinationFileName)) {

            int c;
            while ((c = reader.read()) != -1) {
                char character = (char) c;
                // Duplicate each character and write it twice to the destination file
                writer.write(character);
                writer.write(character);
            }

            System.out.println("Character duplication completed. Output written to " + destinationFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
