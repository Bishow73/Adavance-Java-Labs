package Lab_Assignment_1;

import java.util.Scanner;

public class add_two_numbers {
    public static int addNumbers(int a, int b) {
        return a + b;
    }

    //    public
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a:");
        int a = scn.nextInt();
        System.out.println("Enter b:");
        int b = scn.nextInt();
        System.out.println("The Sum is: "+ add_two_numbers.addNumbers(a, b));
    }
}