package com.zcwfeng.java.test;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Description: 线程间通过管道流通信<br/>
 * Copyright (C), 2005-2015,David <br/>
 * Thies program is protected by copyright David. <br/>
 * Program name <br/>
 * Date:2015年4月30日
 * 
 * @author David zcwfeng@126.com
 * @version 1.0
 *
 */
public class TestPipedThreadConnect {
	public static void main(String[] args) {
		try {
			PipedReader pr = null;
			PipedWriter pw = null;
			pw = new PipedWriter();
			pr = new PipedReader();
			pw.connect(pr);
			
			new WriterThread(pw).start();;
			new ReaderThread(pr).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
