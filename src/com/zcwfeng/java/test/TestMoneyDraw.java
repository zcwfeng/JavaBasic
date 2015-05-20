package com.zcwfeng.java.test;

/**
 * Description: <br/>
 * Copyright (C), 2005-2015,David <br/>
 * Thies program is protected by copyright David. <br/>
 * Program name <br/>
 * Date:2015年4月30日
 * 
 * @author David zcwfeng@126.com
 * @version 1.0
 *
 */
public class TestMoneyDraw {
	public static void main(String[] args) {
//		Account account = new Account("1234567",1000);
//		
//		// 同步资源
//		new DrawThread("甲", account, 800).start();
//		new DrawThread("乙", account, 800).start();
		
		
//		Account2 account2 = new Account2("1234567",1000);
//		
//		// 同步资源
//		new DrawThread("甲", account2, 800).start();
//		new DrawThread("乙", account2, 800).start();
	
//		Account3 account3 = new Account3("1234567",0);
//		
//		// 同步资源
//		
//		new FlagDrawThread("取钱者：", account3, 800).start();
//		new FlagDeposiThread("甲", account3, 800).start();
//		new FlagDeposiThread("已", account3, 800).start();
//		new FlagDeposiThread("丙", account3, 800).start();
		
		
		Account4 account  = new Account4("1234567",0.0);
		// 同步资源
		new FlagDrawThread("取钱者：", account, 800).start();
		new FlagDeposiThread("甲", account, 800).start();
		new FlagDeposiThread("已", account, 800).start();
		new FlagDeposiThread("丙", account, 800).start();
	}
}
