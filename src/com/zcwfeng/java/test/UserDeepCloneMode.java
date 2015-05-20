package com.zcwfeng.java.test;

import javax.security.auth.Subject;

/**
 * 深度拷贝
 * 
 * @author david
 *
 */
class UserDeepCloneMode implements Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1124471364473551269L;
	String name;
	
	UserModel mClone;
	
	public UserDeepCloneMode(String s,String sub) {
		name = s;
		mClone =new UserModel(sub);
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

	@Override
	public UserDeepCloneMode clone() throws CloneNotSupportedException {
		UserDeepCloneMode user = new UserDeepCloneMode(name, mClone.getName());
		return user;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
}