package com.multipong.server;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			new GameServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
