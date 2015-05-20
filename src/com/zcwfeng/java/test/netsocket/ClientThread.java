package com.zcwfeng.java.test.netsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
public class ClientThread implements Runnable {
	private Socket s = null;
	public BufferedReader br = null;

	public ClientThread(Socket s) throws IOException {
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	}

	@Override
	public void run() {
		String content = null;
		try {
			while((content = br.readLine()) != null) {
				System.out.println(content);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
