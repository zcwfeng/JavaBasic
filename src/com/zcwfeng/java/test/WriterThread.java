package com.zcwfeng.java.test;

import java.io.IOException;
import java.io.PipedWriter;

/**
 * Description: <br/>
 * Copyright (C), 2005-2015,David <br/>
 * Thies program is protected by copyright David. <br/>
 * Program name <br/>
 * Date:2015年4月30日
 * 
 * @author David zcwfeng@126.com
 * @version 1.0
 *
 */
public class WriterThread extends Thread {
	String[] books = new String[] { "book first", "book second", "book third",
			"book fourth" };

	private PipedWriter pw;

	private WriterThread() {
	}

	public WriterThread(PipedWriter pw) {
		this.pw = pw;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 100; i++) {
				pw.write(books[i%4]+"\n");
			}
		} catch (Exception e) {
		} finally {
			try {
				if(pw!=null)
					pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
