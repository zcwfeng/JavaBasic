package com.zcwfeng.java.test;

/**
 * Description: <br/>
 * Copyright (C), 2005-2015,David <br/>
 * Thies program is protected by copyright David. <br/>
 * 测试Clone的Model <br/>
 * Date:2015年4月29日
 * 
 * @author David zcwfeng@126.com
 * @version 1.0
 *
 */
public class UserModel {
	String name;

	public UserModel(String s) {
		name = s;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	int age;
}
