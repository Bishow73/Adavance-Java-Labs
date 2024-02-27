package Lab_Assignment_1;
import java.util.Scanner;

public class area_of_shape {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choose a shape to calculate its area:");
        System.out.println("1. Circle");
        System.out.println("2. Square");
        System.out.println("3. Rectangle");
        System.out.println("4. Sphere");
        System.out.print("Enter your choice (1/2/3/4): ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                System.out.print("Enter the radius of the circle: ");
                double radius = scanner.nextDouble();
                double circleArea = Math.PI * radius * radius;
                System.out.println("Area of the circle: " + circleArea);
                break;
                
            case 2:
                System.out.print("Enter the side length of the square: ");
                double sideLength = scanner.nextDouble();
                double squareArea = sideLength * sideLength;
                System.out.println("Area of the square: " + squareArea);
                break;
                
            case 3:
                System.out.print("Enter the length of the rectangle: ");
                double length = scanner.nextDouble();
                System.out.print("Enter the width of the rectangle: ");
                double width = scanner.nextDouble();
                double rectangleArea = length * width;
                System.out.println("Area of the rectangle: " + rectangleArea);
                break;
                
            case 4:
                System.out.print("Enter the radius of the sphere: ");
                double sphereRadius = scanner.nextDouble();
                double sphereArea = 4 * Math.PI * sphereRadius * sphereRadius;
                System.out.println("Surface area of the sphere: " + sphereArea);
                break;
                
            default:
                System.out.println("Invalid choice!");
        }
        
        scanner.close();
    }
}