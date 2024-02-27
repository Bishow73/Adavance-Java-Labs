package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class EchoClient {
public static void main(String[] args) {
try (Scanner scanner = new Scanner(System.in);
DatagramSocket socket = new DatagramSocket()){
InetAddress serverAddress = InetAddress.getByName("localhost");
int serverPort = 9876;
while (true) {
// Get user input
System.out.print("Enter a message to send to the server (type 'exit' to quit): ");
String message = scanner.nextLine();
if ("exit".equalsIgnoreCase(message)) {
break;
}
// Convert the message to bytes
byte[] sendData = message.getBytes();
// Send packet to the server
DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
socket.send(sendPacket);
// Receive the echoed message from the server
byte[] receiveData = new byte[1024];
DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
socket.receive(receivePacket);
String echoedMessage = new String(receivePacket.getData(), 0,receivePacket.getLength());
System.out.println("Received from server: " + echoedMessage);
}
} catch (Exception e) {
e.printStackTrace();
}
}
}
