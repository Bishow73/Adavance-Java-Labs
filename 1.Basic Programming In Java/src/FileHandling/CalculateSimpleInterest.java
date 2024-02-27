package FileHandling;

import java.io.*;


public class CalculateSimpleInterest {
    public static void main(String[] args) {
        String sourceFileName = "C:\\Users\\User\\eclipse-workspace\\Lab_Assignment_1\\src\\FileHandling\\Record.txt";
        String destinationFileName = "C:\\Users\\User\\eclipse-workspace\\Lab_Assignment_1\\src\\FileHandling\\CalculatedRecord.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFileName));
             FileWriter writer = new FileWriter(destinationFileName)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0];
                    double principal = Double.parseDouble(parts[1]);
                    double rate = Double.parseDouble(parts[2]);
                    double time = Double.parseDouble(parts[3]);

                    
                    double simpleInterest = (principal * rate * time) / 100.0;

                    
                    writer.write(name + "," + principal + "," + rate + "," + time + "," + simpleInterest + "\n");
                }
            }

            System.out.println("Simple interest calculation and writing to completed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
