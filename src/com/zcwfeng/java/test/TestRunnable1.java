package com.zcwfeng.java.test;

/**
 * Description: 线程join方法的测试<br/>
 * Copyright (C), 2005-2015,David <br/>
 * Thies program is protected by copyright David. <br/>
 * 测试线程的执行顺序 <br/>
 * 如果你有三个线程，分别为T1,T2,T3,如何让线程T2在线程T1之后执行，在线程T3之前执行。<br/>
 * 答案是：使用线程的join方法，该方法的作用是“等待线程执行结束”，即join()方法后面的代码块都要等待现场执行结束后才能执行。<br/>
 * Date:2015年4月30日
 * 
 * @author David zcwfeng@126.com
 * @version 1.0
 *
 */
public class TestRunnable1 {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runner());
		Thread t2 = new Thread(new Runner());
		Thread t3 = new Thread(new Runner());
		t1.start();
		t1.sleep(5000);
		t1.join();

		t2.start();
		t2.sleep(1000);
		t2.join();
		t3.start();
		t3.join();

	}

}

class Runner implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "");

	}
}
