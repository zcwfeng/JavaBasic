package com.zcwfeng.java.test.netsocket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;


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
public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(30000);
		while(true) {
			Socket s = ss.accept();
			PrintStream ps = new PrintStream(s.getOutputStream());
			ps.print("你收到了服务器的信息");
			ps.close();
			s.close();
		}
	}
}


