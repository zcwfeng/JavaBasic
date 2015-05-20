package com.zcwfeng.java.test;

/**
 * Description:Java 8允许我们给接口添加一个非抽象的方法实现，只需要使用
 * default关键字即可，这个特征又叫做扩展方法，默认方法sqrt将在子类上可以直接使用。<br/>
 * Copyright (C), 2005-2015,David<br/>
 * Thies program is protected by copyright<br/>
 * David. Program name<br/>
 * Date:2015年5月5日<br/>
 * 
 * 
 * @author David zcwfeng@126.com<br/>
 * @version 1.0
 *
 */
interface InterfaceTest {
	double calculate(int a);

	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}
