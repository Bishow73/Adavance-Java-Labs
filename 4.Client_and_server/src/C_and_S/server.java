package C_and_S;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class server {
public static void main(String[] args) {
try (ServerSocket serverSocket = new ServerSocket(12345)) {
System.out.println("Server is listening on port 12345...");
while (true) {
try 
(Socket clientSocket = serverSocket.accept();
ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream())) {
// Receive radius from client
double radius = objectInputStream.readDouble();
System.out.println("Received radius from client: " + radius);
// Calculate area
double area = Math.PI * Math.pow(radius, 2);
// Send computed area back to the client
objectOutputStream.writeDouble(area);
objectOutputStream.flush();
System.out.println("Computed area sent to client: " + area);
}
}
} catch (IOException e) {
e.printStackTrace();
}
}
}
