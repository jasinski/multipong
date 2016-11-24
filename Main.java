import java.io.*;

import java.net.*;

class Main {

	public static void main(String args[]) throws Exception {

		Test test = new Test();

		DatagramSocket serverSocket = new DatagramSocket(9876);
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		int i = 2;
		while (true) {
			System.out.println("Waiting for client");
			// Receive packet from client (s)
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			String sentence = new String( receivePacket.getData());
			System.out.println("RECEIVED BOOOOM: (" + test.value + ")" + sentence);
			
			// Get clients IP address
			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			String capitalizedSentence = sentence.toUpperCase();
			sendData = capitalizedSentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
			serverSocket.send(sendPacket);
		}

	}
}
