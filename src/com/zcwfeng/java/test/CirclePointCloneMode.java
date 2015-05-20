package com.zcwfeng.java.test;

import java.io.Serializable;


/**
 * Description:
 * <br/>Copyright (C), 2005-2015,David
 * <br/>Thies program is protected by copyright David.
 * <br/>实现序列化接口，测试深拷贝
 * <br/>Date:2015年4月29日
 * @author David zcwfeng@126.com
 * @version 1.0
 *
 */
public class CirclePointCloneMode implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4814410797064215449L;
	int x;
	int y;
	String name;
	@Override
	public String toString() {
		return "CirclePoint [x=" + x + ", y=" + y + ", name=" + name + "]";
	}
	
}


