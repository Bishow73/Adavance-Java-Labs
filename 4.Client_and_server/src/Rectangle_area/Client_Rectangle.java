package Rectangle_area;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
public class Client_Rectangle {
public static void main(String[] args) {
try (Scanner scanner = new Scanner(System.in);
Socket s = new Socket("localhost", 23456);
ObjectOutputStream objectOutputStream = new ObjectOutputStream(s.getOutputStream());
ObjectInputStream objectInputStream = new ObjectInputStream(s.getInputStream())) {
// Get length and breadth from user
System.out.print("Enter the length of the rectangle: ");
double length = scanner.nextDouble();
System.out.print("Enter the breadth of the rectangle: ");
double breadth = scanner.nextDouble();
// Send length and breadth to the server
objectOutputStream.writeDouble(length);
objectOutputStream.writeDouble(breadth);
objectOutputStream.flush();
System.out.println("Length and breadth sent to server.");
// Receive computed area from the server
double area = objectInputStream.readDouble();
System.out.println("Received computed area from server: " + area);
// Display the result
System.out.println("The area of the rectangle with length " + length +
" and breadth " + breadth + " is: " + area);
} catch (IOException e) {
e.printStackTrace();
} } }
