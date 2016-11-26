package com.multipong;

import java.net.DatagramPacket;
import java.net.InetAddress;

class Client {
	public InetAddress ip;
	public int port;
	public DatagramPacket latestPacket;
	
	@Override
	public boolean equals(Object object) {
		boolean retVal = false;
		if (object instanceof Client){
			Client ptr = (Client) object;
			if (!ptr.ip.equals(this.ip)) return false;
			return true;
		}
		return retVal;
	}
	
}
