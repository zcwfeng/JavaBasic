package com.zcwfeng.java.test;

/**
 * 测试浅拷贝
 * 
 * @author david
 *
 */
class UserCloneMode implements Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1124471364473551269L;
	String name;
	UserModel user;
	public UserCloneMode(String s,String subs) {
		name = s;
		user = new UserModel(subs);
	}
	public String getName() {
		return name;
	}

	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
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
	public UserCloneMode clone() throws CloneNotSupportedException {
		return (UserCloneMode) super.clone();
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
}