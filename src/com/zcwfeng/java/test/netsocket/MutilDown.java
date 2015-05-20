package com.zcwfeng.java.test.netsocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MutilDown {
	public static void main(String[] args) {
		final int DOWN_THREAD_NUM = 4;
		final String OUT_FILE_NAME = "test.mp4";

		InputStream[] isArr = new InputStream[DOWN_THREAD_NUM];
		RandomAccessFile[] outArr = new RandomAccessFile[DOWN_THREAD_NUM];

		try {
//			URL url = new URL("http://images.csdn.net/20150519/201.jpg");
			URL url = new URL("http://hc.yinyuetai.com/uploads/videos/common/6135014D6A237CF1368D3F4F699E0864.flv?sc=09dd8641fb4462a4");
			isArr[0] = url.openStream();
			long fileLen = getFileLength(url);
			System.out.println("资源大小" + fileLen);
			outArr[0] = new RandomAccessFile(OUT_FILE_NAME, "rw");
			// 创建一个与下载资源大小相同的空文件
			for (int i = 0; i < fileLen; i++) {
				outArr[0].write(0);
			}
			// 每个线程下载的字节数
			long numPerThread = fileLen / DOWN_THREAD_NUM;
			long left = fileLen % DOWN_THREAD_NUM;
			for (int i = 0; i < DOWN_THREAD_NUM; i++) {
				if (i != 0) {
					isArr[i] = url.openStream();
					outArr[i] = new RandomAccessFile(OUT_FILE_NAME, "rw");
				}
				if (i == DOWN_THREAD_NUM - 1) {
					new DownloadThread(i * numPerThread, (i + 1) * numPerThread
							+ left, isArr[i], outArr[i]).start();;
				} else {
					new DownloadThread(i * numPerThread,
							(i + 1) * numPerThread, isArr[i], outArr[i]).start();
				}
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	private static long getFileLength(URL url) throws IOException {
		long length = 0;
		URLConnection conn = url.openConnection();
		long size = conn.getContentLength();
		length = size;
		return length;
	}
}