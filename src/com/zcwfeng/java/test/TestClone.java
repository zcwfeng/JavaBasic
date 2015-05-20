package com.zcwfeng.java.test;

/**
 * Description: <br/>
 * Copyright (C), 2005-2015,David <br/>
 * Thies program is protected by copyright David. <br/>
 * Program name <br/>
 * Date:2015年4月29日
 * 
 * @author David zcwfeng@126.com
 * @version 1.0
 *
 */
public class TestClone {
	public static void main(String[] args) throws CloneNotSupportedException {
		//测试浅拷贝，更改了拷贝的值不会影响浅拷贝的原始值
		UserCloneMode user = new UserCloneMode("zhangsan","lisi");
		UserCloneMode userClone = user.clone();
		//改变值之前
		System.out.println("user:"+user);
		System.out.println("user clone:"+userClone);
		System.out.println(user == userClone);
		//改变值之后
		userClone.getUser().setName("wangwu");
		System.out.println("user:"+user);
		System.out.println("user clone:"+userClone);
		System.out.println(user == userClone);
		
		System.out.println("-------------------------");
	
		//测试深拷贝，改变值前后，另一份也跟着改变
		UserDeepCloneMode userDeep = new UserDeepCloneMode("zhangsan","lisi");
		UserDeepCloneMode userDeepClone = userDeep.clone();
		//改变值之前
		System.out.println("userDeep:"+userDeep);
		System.out.println("userDeep clone:"+userDeepClone);
		System.out.println(userDeep == userDeepClone);
		//改变值之后
		userDeepClone.setName("wangwu");
		System.out.println("userDeep:"+userDeep);
		System.out.println("userDeep clone:"+userDeepClone);
		System.out.println(userDeep == userDeepClone);
	
	}
}
