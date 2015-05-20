package com.zcwfeng.java.test;

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
public class Java8FunctionInterfaceUser {
	public static void main(String[] args) {
		Java8FunctionInterface<String, Integer> converter = (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("123");
		System.out.println(converted); // 123
		
	}
}
