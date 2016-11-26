package com.multipong;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import static org.junit.Assert.*;
//
public class ServerTest {

	Server server;
	
	public void test() {
		server = new Server();
		assertTrue(server.start());
	}
}
