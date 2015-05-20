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
public class FlagDeposiThread extends Thread {
	
//	private Account3 account;
	private Account4 account;
	private double deposiAmount;

	public FlagDeposiThread(String name, Account4 account, double deposiAmount) {
		super(name);
		this.account = account;
		this.deposiAmount = deposiAmount;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			account.deposiMoney(deposiAmount);
		}
	}
}
