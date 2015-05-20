package com.zcwfeng.java.test.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Description:<br/>
 * Copyright (C), 2005-2015,David<br/>
 * Thies program is protected by copyright<br/>
 * David. Program name<br/>
 * Date:2015年5月13日<br/>
 * 
 * @author David zcwfeng@126.com<br/>
 * @version 1.0
 *
 */
public class FileUtils {

	public static void main(String[] args) {
		toRepaceFileNameByRule("G:/网络照片/灌篮高手仿真人照片", 0);
	}

	public static void toRepaceFileNameByRule(String filepath, int ruletype) {
		switch (ruletype) {
		case 1:

			break;

		default:
			replaceFileNameByNumFromZero(filepath);
			break;
		}
	}

	private static void replaceFileNameByNumFromZero(String filepath) {
		File file = new File(filepath);
		String child = filepath+"/child/";
		File dir = new File(child);
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		if (file.isDirectory()) {
			System.out.println(file.listFiles().length);
			for (int i = 0; i < file.listFiles().length; i++) {
				File childF = file.listFiles()[i];
				if (childF.isDirectory())
					continue;
				
				System.out.println(childF.getAbsolutePath());
				try {
					copyFile(childF, new File(filepath
							+ "/child/guanlangaoshou_" + i + ".jpg"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			new RuntimeException("你应该传入一个文件夹而不是文件");
		}
	}

	// 复制文件
	public static void copyFile(File sourceFile, File targetFile)
			throws IOException {
		BufferedInputStream inBuff = null;
		BufferedOutputStream outBuff = null;
		try {
			// 新建文件输入流并对它进行缓冲
			inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
			// 新建文件输出流并对它进行缓冲
			outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));
			// 缓冲数组
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuff.read(b)) != -1) {
				outBuff.write(b, 0, len);
			}
			// 刷新此缓冲的输出流
			outBuff.flush();
		} finally {
			// 关闭流
			if (inBuff != null)
				inBuff.close();
			if (outBuff != null)
				outBuff.close();
		}
	}
}
