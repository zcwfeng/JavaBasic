package com.zcwfeng.java.test;

public class CopyTest {
	public static void main(String[] args) {
		// 原始对象
		Student stud = new Student("John", "Algebra");
		System.out.println("Original Object: " + stud.getName() + " - "
				+ stud.getSubj().getName());
		// 拷贝对象
		Student clonedStud = (Student) stud.clone();
		System.out.println("Cloned Object: " + clonedStud.getName() + " - "
				+ clonedStud.getSubj().getName());
		// 原始对象和拷贝对象是否一样：
		System.out.println("Is Original Object the same with Cloned Object: "
				+ (stud == clonedStud));
		// 原始对象和拷贝对象的name属性是否一样
		System.out
				.println("Is Original Object's field name the same with Cloned Object: "
						+ (stud.getName() == clonedStud.getName()));
		// 原始对象和拷贝对象的subj属性是否一样
		System.out
				.println("Is Original Object's field subj the same with Cloned Object: "
						+ (stud.getSubj() == clonedStud.getSubj()));
		stud.setName("Dan");
		stud.getSubj().setName("Physics");
		System.out.println("Original Object after it is updated: "
				+ stud.getName() + " - " + stud.getSubj().getName());
		System.out
				.println("Cloned Object after updating original object: "
						+ clonedStud.getName() + " - "
						+ clonedStud.getSubj().getName());
	}
}