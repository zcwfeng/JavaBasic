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
public class DrawThread extends Thread {
	private Account2 account;
//	private Account account;
	private double drawAmount;

//	public DrawThread(String name, Account account, double drawAmount) {
//		super(name);
//		this.account = account;
//		this.drawAmount = drawAmount;
//	}
	
	public DrawThread(String name, Account2 acc, double drawAmount) {
		super(name);
		this.account = acc;
		this.drawAmount = drawAmount;
	}

	@Override
	public void run() {
		
//		synchronized (account) {
//			if (account.getBalance() >= drawAmount) {
//				System.out.println(getName() + "成功取钞：" + drawAmount);
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//
//				// 修改金额
//				account.setBalance(account.getBalance() - drawAmount);
//				System.out.println("剩余金额：" + account.getBalance());
//			} else{
//				System.out.println("余额不足");
//			}
//		}
		// 同步代码块
		account.drawMoney(drawAmount);
	}
}
