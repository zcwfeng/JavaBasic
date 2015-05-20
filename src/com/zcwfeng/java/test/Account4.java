package com.zcwfeng.java.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:模拟银行取款，这个是银行取款的账户 <br/>
 * Copyright (C), 2005-2015,David <br/>
 * Thies program is protected by copyright David. <br/>
 * Program name <br/>
 * Date:2015年4月30日
 * 
 * @author David zcwfeng@126.com
 * @version 1.0
 *
 */
public class Account4 {
	private String accountNo;
	private double balance;
	private final Lock lock = new ReentrantLock();
	private final Condition cond = lock.newCondition();
	private boolean flag = false;

	public Account4() {
	}

	public Account4(String accountNo, double mBanlance) {
		this.accountNo = accountNo;
		this.balance = mBanlance;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		// final int prime = 31;
		// int result = 1;
		// result = prime * result
		// + ((accountNo == null) ? 0 : accountNo.hashCode());
		// long temp;
		// temp = Double.doubleToLongBits(balance);
		// result = prime * result + (int) (temp ^ (temp >>> 32));
		return accountNo.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// if (this == obj)
		// return true;
		// if (obj == null)
		// return false;
		// if (getClass() != obj.getClass())
		// return false;
		// Account other = (Account) obj;
		// if (accountNo == null) {
		// if (other.accountNo != null)
		// return false;
		// } else if (!accountNo.equals(other.accountNo))
		// return false;
		// if (Double.doubleToLongBits(balance) != Double
		// .doubleToLongBits(other.balance))
		// return false;
		// return true;
		if (obj != null && obj.getClass() == this.getClass()) {
			Account4 account = (Account4) obj;
			return account.getAccountNo().equals(this.getAccountNo());
		}
		return false;
	}

	public  void drawMoney(double drawAmount) {
		try {
			lock.lock();
			// 账户还没有人存入，取款阻塞
			if (!flag) {
				cond.await();
			} else {
				System.out.println(Thread.currentThread().getName() + ":成功取钞："
						+ drawAmount);

				// 修改金额
				setBalance(getBalance() - drawAmount);
				System.out.println("剩余金额：" + getBalance());
				flag = false;
				cond.signalAll();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

	public  void deposiMoney(double deposiAmount) {
		lock.lock();
		// flag表示账户有人存钱进去，存款阻塞
		try {
			
			if (flag) {
				cond.await();
			} else {
				System.out.println(Thread.currentThread().getName() + ":存款："
						+ deposiAmount);
				// 修改金额
				setBalance(getBalance() + deposiAmount);
				System.out.println("剩余金额：" + getBalance());
				flag = true;
				cond.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
