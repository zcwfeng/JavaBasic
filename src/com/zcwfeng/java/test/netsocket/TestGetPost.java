package com.zcwfeng.java.test.netsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

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
public class TestGetPost {

	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader bf = null;
		String urlName = url + "?" + param;
		try {
			URL realUrl = new URL(urlName);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "keep-alive");
			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:38.0) Gecko/20100101 Firefox/38.0");
			conn.connect();
			Map<String, List<String>> map = conn.getHeaderFields();

			for (String key : map.keySet()) {
				System.out.println(key + "---->" + map.get(key));
			}

			bf = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = bf.readLine()) != null) {
				result += "\n" + line;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bf != null) {
				try {
					bf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static String sendPost(String url, String param) {
		String result = "";
		PrintWriter out = null;
		BufferedReader bf = null;
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "keep-alive");
			conn.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:38.0) Gecko/20100101 Firefox/38.0");
			conn.setDoOutput(true);
			conn.setDoInput(true);

			out = new PrintWriter(conn.getOutputStream());
			// 发送参数
			out.print(param);
			out.flush();
			bf = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = bf.readLine()) != null) {
				result += "\n" + line;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
				if (bf != null)
					bf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s = TestGetPost.sendGet(
				"http://blog.csdn.net/tjy1985/article/details/7893247", null);
		System.out.println(s);
		String s1 = TestGetPost
				.sendPost(
						"http://baike.baidu.com/link",
						"url=NvbjOHw-70YYeKdNfExBl4owaDO1IGZK9-6nCFSaf9-HGfPaK6BAtUAT5O7BdvW1AhaTgDh1AcZQdyGXw_3VOK");
		System.out.println(s1);
	}
}
