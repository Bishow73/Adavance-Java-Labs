package C_and_S;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
public class client {
public static void main(String[] args) {
try (Scanner scanner = new Scanner(System.in);
Socket socket = new Socket("localhost", 12345);
ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())) {
// Get radius from user
System.out.print("Enter the radius of the circle: ");
double radius = scanner.nextDouble();
// Send radius to the server
objectOutputStream.writeDouble(radius);
objectOutputStream.flush();
System.out.println("Radius sent to server: " + radius);
// Receive computed area from the server
double area = objectInputStream.readDouble();
System.out.println("Received computed area from server: " + area);
// Display the result
System.out.println("The area of the circle with radius " + radius + " is: " + area);
} catch (IOException e) {
e.printStackTrace();
}
}
}
