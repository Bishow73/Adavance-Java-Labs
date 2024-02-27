package Rectangle_area;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server_Rectangle {
public static void main(String[] args) {
try (ServerSocket ss = new ServerSocket(23456)) {
System.out.println("Server is listening on port 23456...");
while (true) {
try (Socket cs = ss.accept();
ObjectInputStream objectInputStream = new ObjectInputStream(cs.getInputStream());
ObjectOutputStream objectOutputStream = new ObjectOutputStream(cs.getOutputStream())) {
// Receive length and breadth from client
double length = objectInputStream.readDouble();
double breadth = objectInputStream.readDouble();
System.out.println("Received length from client: " + length);
System.out.println("Received breadth from client: " + breadth);
// Calculate area
double area = length * breadth;
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
