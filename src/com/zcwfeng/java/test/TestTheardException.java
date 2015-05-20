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
public class TestTheardException {
	public static void main(String[] args) {
		Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
		int a = 5/0;
	}
}

class MyExHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t + "线程出现了异常" + e);
	}
	
	

}
