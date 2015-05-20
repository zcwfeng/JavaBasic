package com.zcwfeng.java.test.netsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
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
public class Client {
	public static void main(String[] args) throws UnknownHostException,
			IOException {

		// Socket socket = new Socket("127.0.0.1", 30000);
		// socket.setSoTimeout(1000);

		// 创建一个无连接的socket，然后在连接
		Socket socket = new Socket();
		socket.connect(new InetSocketAddress("127.0.0.1",30000), 10000);

		BufferedReader br = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		String line = br.readLine();
		System.out.println("来自服务器信息：" + line);

		br.close();
		socket.close();
		
	}
}
