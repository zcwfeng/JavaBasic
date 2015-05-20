package com.zcwfeng.java.test;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Description: <br/>
 * Copyright (C), 2005-2015,David <br/>
 * Thies program is protected by copyright David. <br/>
 * 继续深入weakhashmap <br/>
 * Date:2015年4月29日
 * 
 * @author David zcwfeng@126.com
 * @version 1.0
 *
 */
public class TestWeakHashMap2 {
	static Map wMap = new WeakHashMap();

	public static void init() {
		wMap.put("1", "ding");
		wMap.put("2", "job");
	}

	public static void testWeakHashMap() {

		System.out.println("first get:" + wMap.get("1"));
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("next get:" + wMap.get("1"));
	}

	public static void main(String[] args) {
		testWeakHashMap();
	}
	
	
//	上面例子， 第一次执行时要初始化，然后在5s内是不会清除的，大概在10几秒时会清除
//	第一次执行
//
//	first get:ding
//
//	next get:ding
//
//	过一会再执行：
//
//	first get:null
//	next get:null
//
//	这时候已经被清除
//	同样，没有调用任何赋值方法的情况下，在一段时间后 size 方法也可能返回较小的值，对于 isEmpty 方法，返回false，然后返回 true，对于给定的键，containsKey 方法返回 true 然后返回 false，对于给定的键，get 方法返回一个值，但接着返回 null，对于以前出现在映射中的键，put 方法返回 null，而 remove 方法返回 false，对于键集、值集、项集进行的检查，生成的元素数量越来越少。
//	 
//
//	 
//
//	注意：WeakHashMap并不是你啥也干他就能自动释放内部不用的对象的，而是在你访问它的内容的时候释放内部不用的对象。这两句话看似区别不大，但是有时候一个小小的区别就会要了命的。就是说你只put 了压根没有get过，这个值是永远都存在的
}
