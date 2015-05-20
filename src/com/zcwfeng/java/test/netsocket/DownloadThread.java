package com.zcwfeng.java.test.netsocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/**
 * Description:<br/>
 * Copyright (C), 2005-2015,David<br/>
 * Thies program is protected by copyright<br/>
 * David. Program name<br/>
 * Date:2015年5月19日<br/>
 * 
 * @author David zcwfeng@126.com<br/>
 * @version 1.0
 *
 */
public class DownloadThread extends Thread {
	private final int BUFF_LEN = 32;
	private InputStream is;
	private long start;
	private long end;
	private RandomAccessFile raf;

	public DownloadThread() {
	}

	public DownloadThread(long start, long end, InputStream is,
			RandomAccessFile raf) {
		System.out.println(start + "------------>" + end);
		this.is = is;
		this.start = start;
		this.end = end;
		this.raf = raf;
	}

	@Override
	public void run() {
		super.run();
		try {
			is.skip(start);
			raf.seek(start);
			byte[] buff = new byte[BUFF_LEN];
			long contentLen = end - start;
			long times = contentLen / BUFF_LEN + 4;// 定义最多几次读取
			int hasRead = 0;
			for (int i = 0; i < times; i++) {
				hasRead = is.read(buff);

				if (hasRead <= 0) {
					break;
				}
				raf.write(buff, 0, hasRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (raf != null) {
					raf.close();
				}
				if (is != null) {
					is.close();
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
