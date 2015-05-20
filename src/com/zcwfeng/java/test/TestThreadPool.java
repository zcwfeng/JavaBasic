package com.zcwfeng.java.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
public class TestThreadPool {
	public static void main(String[] args) {
		ExecutorService pool  = Executors.newFixedThreadPool(6);
		pool.submit(new TestMyThread());
		pool.submit(new TestMyThread());
		pool.shutdown();
	}
}

class TestMyThread implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "的变量" + i);
		}

	}

}
