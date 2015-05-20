package com.zcwfeng.java.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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
public class TestCallableThread {
	public static void main(String[] args) {
		// 创建Callable对象
		RtnThread callback = new RtnThread();
		FutureTask<Integer> task = new FutureTask<Integer>(callback);
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " 的循环变量" + i);
			if (i == 20) {
				new Thread(task, "有返回值的线程").start();
			}
		}

		try {
			System.out.println("子线程的返回" + task.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class RtnThread implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int i = 0;
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " 的循环变量" + i);
		}
		return i;
	}
}
