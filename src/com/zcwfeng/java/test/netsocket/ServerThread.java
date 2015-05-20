package com.zcwfeng.java.test.netsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Description:<br/>
 * Copyright (C), 2005-2015,David<br/>
 * Thies program is protected by copyright<br/>
 * David. Program name<br/>
 * Date:2015年5月20日<br/>
 * 
 * @author David zcwfeng@126.com<br/>
 * @version 1.0
 *
 */
public class ServerThread implements Runnable {
	Socket s = null;
	BufferedReader br = null;

	public ServerThread(Socket s) throws IOException {
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}

	@Override
	public void run() {
		String content = null;
		try {
			while ((content = readFromClient()) != null) {
				for (Socket s : MyServer.socketList) {
					PrintStream ps = new PrintStream(s.getOutputStream());
					ps.println(content);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String readFromClient() {
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			MyServer.socketList.remove(s);
		}
		return null;
	}

}
