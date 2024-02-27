package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class EchoServer {
public static void main(String[] args) {
try (DatagramSocket socket = new DatagramSocket(9876)) {
System.out.println("UDP Echo Server is running on port 9876...");
while (true) {
byte[] receiveData = new byte[1024];
// Receive packet from the client
DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
socket.receive(receivePacket);
String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
System.out.println("Received from client: " + receivedMessage);
// Send the received data back to the client
DatagramPacket sendPacket = new DatagramPacket(receivePacket.getData(), receivePacket.getLength(), receivePacket.getAddress(), receivePacket.getPort());
socket.send(sendPacket);
System.out.println("Sent back to client: " + receivedMessage);
}
} catch (Exception e) {
e.printStackTrace();
}
}
}
