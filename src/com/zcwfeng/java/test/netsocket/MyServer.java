package com.zcwfeng.java.test.netsocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


/**
 * Description:<br/>
 * Copyright (C), 2005-2015,David<br/>
 * Thies program is protected by copyright<br/> David.
 * Program name<br/>
 * Date:2015年5月20日<br/>
 * @author David zcwfeng@126.com<br/>
 * @version 1.0
 *
 */
public class MyServer {
	public static ArrayList<Socket> socketList = new ArrayList<Socket>();
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(30000);
		while(true) {
			Socket s = ss.accept();
			socketList.add(s);
			new Thread(new ServerThread(s)).start();
		}
	}
}


