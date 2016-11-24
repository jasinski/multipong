import java.io.*;
import java.net.*;
import java.util.ArrayList;

class Main {

	public static void main(String args[]) throws Exception {

		ArrayList<InetAddress> ips = new ArrayList();

		DatagramSocket serverSocket = new DatagramSocket(9876);
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		int i = 2;
		while (true) {
			System.out.println("Waiting for client");
			// Receive packet from client (s)
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			String clientData = new String( receivePacket.getData());
			System.out.println(clientData);
			
			// Get clients IP address
			InetAddress IPAddress = receivePacket.getAddress();
			if (!ips.contains(IPAddress)) {
				ips.add(IPAddress);
			}
			
			
			for (InetAddress address : ips) {
				System.out.println("HOSTS CONNECTED");
				int port = receivePacket.getPort();
				sendData = clientData.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);
				serverSocket.send(sendPacket);
			}
		}

	}
}
