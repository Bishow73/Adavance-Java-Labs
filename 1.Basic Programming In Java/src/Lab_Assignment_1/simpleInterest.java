package Lab_Assignment_1;
import java.util.Scanner;

public class simpleInterest {
	public static double calculateSimpleInterest(double principal, double time, double rate) {
        double simpleInterest = (principal * time * rate) / 100;
        return simpleInterest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter the time period (in years): ");
        double time = scanner.nextDouble();

        System.out.print("Enter the rate of interest (in percentage): ");
        double rate = scanner.nextDouble();
        double simpleInterest = calculateSimpleInterest(principal, time, rate);

        System.out.println("Simple Interest: " + simpleInterest);

        scanner.close();
	}
}


