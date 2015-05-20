package com.zcwfeng.java.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
public class java8TestLambda {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

		// other jdk
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});
		/**
		 * java 8 lambda
		 */ 
		Collections.sort(names, (String a, String b) -> {
			return b.compareTo(a);
		});
		/**
		 * java 8 优化
		 */
		Collections.sort(names, (String a, String b) -> b.compareTo(a));
		
	}
}
