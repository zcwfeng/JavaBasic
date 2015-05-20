package com.zcwfeng.java.test;

/**
 * Description:测试线程Group <br/>
 * Copyright (C), 2005-2015,David <br/>
 * Thies program is protected by copyright David. <br/>
 * Program name <br/>
 * Date:2015年4月30日
 * 
 * @author David zcwfeng@126.com
 * @version 1.0
 *
 */
public class MThreadOfGroup extends Thread {

	public MThreadOfGroup(String name) {
		super(name);
	}

	public MThreadOfGroup(ThreadGroup group, String name) {
		super(group, name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(getName() + ":线程i变量" + i);
		}
	}
}
