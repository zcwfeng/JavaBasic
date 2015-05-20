package com.zcwfeng.java.test;

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
public class TestThread1 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("Thread name:" + getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		TestThread1 mThread = new TestThread1();
		mThread.setDaemon(true);
		for (int i = 0; i < 5; i++) {
			System.out.println("Main Thread" + "" + i);
		}
		mThread.start();
		

	}
}
