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
public class TestThreadGroup {
	public static void main(String[] args) {
		// 获取主线程的线程组，这是默认的线程组
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		System.out.println("主线程组的名字：" + mainGroup.getName());
		System.out.println("主线程组是否为后台线程：" + mainGroup.isDaemon());

		ThreadGroup tg = new ThreadGroup("新建线程组");
		tg.setDaemon(true);
		System.out.println("tg程组的名字：" + tg.getName());
		System.out.println("tg程组是否为后台线程：" + tg.isDaemon());

		MThreadOfGroup tt = new MThreadOfGroup(tg, "tg的线组");
		tt.start();
		new MThreadOfGroup(tg,"tg租的线程乙").start();
	}
}
