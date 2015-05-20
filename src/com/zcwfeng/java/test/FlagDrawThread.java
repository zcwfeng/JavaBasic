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
public class FlagDrawThread extends Thread {
//	private Account3 account;
	private Account4 account;
	private double drawAmount;

	public FlagDrawThread(String name, Account4 account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++)
			// 同步代码块
			account.drawMoney(drawAmount);
	}
}
