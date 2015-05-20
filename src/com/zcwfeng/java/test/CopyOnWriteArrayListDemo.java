package com.zcwfeng.java.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:<br/>
 * Copyright (C), 2005-2015,David<br/>
 * Thies program is protected by copyright<br/>
 * David. Program name<br/>
 * Date:2015年5月5日<br/>
 * 
 * @author David zcwfeng@126.com<br/>
 * @version 1.0
 *
 */
public class CopyOnWriteArrayListDemo {
	/**
	 * 读线程
	 * 
	 * @author wangjie
	 *
	 */
	private static class ReadTask implements Runnable {
		List<String> list;

		public ReadTask(List<String> list) {
			this.list = list;
		}

		public void run() {
			for (String str : list) {
				System.out.println(str);
			}
		}
	}

	/**
	 * 写线程
	 * 
	 * @author wangjie
	 *
	 */
	private static class WriteTask implements Runnable {
		List<String> list;

		int index;

		public WriteTask(List<String> list, int index) {
			this.list = list;
			this.index = index;
		}

		public void run() {
			list.remove(index);
			list.add(index, "write_" + index);
		}
	}

	public void run() {
		final int NUM = 10;
		// List<String> list = new ArrayList<String>();
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
		for (int i = 0; i < NUM; i++) {
			list.add("main_" + i);
		}
		ExecutorService executorService = Executors.newFixedThreadPool(NUM);
		for (int i = 0; i < NUM; i++) {
			executorService.execute(new ReadTask(list));
			executorService.execute(new WriteTask(list, i));
		}
		executorService.shutdown();
	}

	public static void main(String[] args) {
		new CopyOnWriteArrayListDemo().run();
	}
}