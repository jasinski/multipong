import java.io.*;
import java.net.*;
import java.util.ArrayList;

class Main {
	
	public static void main(String args[]) throws Exception {

		
		
		ArrayList<Client> clients = new ArrayList();

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
			
			// Get clients IP address & port
			Client latestClient = new Client();
			latestClient.ip = receivePacket.getAddress();
			latestClient.port = receivePacket.getPort();
			if (clients.contains(latestClient)) {
				clients.get(clients.indexOf(latestClient)).latestPacket = receivePacket;
			} else {
				clients.add(latestClient);
			}
			
			
			for (Client client: clients) {
				System.out.print("Sending to CLIENT: " + client.ip + ":" + client.port);
				int port = receivePacket.getPort();
				sendData = clientData.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, client.ip, client.port);
				serverSocket.send(sendPacket);
			}
			System.out.println();
		}

	}
}
