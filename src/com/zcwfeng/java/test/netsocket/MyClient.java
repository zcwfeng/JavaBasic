package com.zcwfeng.java.test.netsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

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
public class MyClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("127.0.0.1", 30000);
		new Thread(new ClientThread(s)).start();
		PrintStream ps = new PrintStream(s.getOutputStream());
		String line = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while((line = br.readLine()) != null) {
			ps.println(line);
		}
	}
}
