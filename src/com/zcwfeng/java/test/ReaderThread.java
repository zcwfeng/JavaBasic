package com.zcwfeng.java.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PipedReader;

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
public class ReaderThread extends Thread {
	private PipedReader pr;
	private BufferedReader br;

	public ReaderThread() {
	}

	public ReaderThread(PipedReader pr) {
		this.pr = pr;
		this.br = new BufferedReader(pr);
	}

	@Override
	public void run() {
		String buf = null;
		try {
			while((buf = br.readLine())!=null) {
				System.out.println(buf);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
