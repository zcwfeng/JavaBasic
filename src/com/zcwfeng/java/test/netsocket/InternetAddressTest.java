package com.zcwfeng.java.test.netsocket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;

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
public class InternetAddressTest {

	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getByName("mv.yinyuetai.com");
			System.out.println(ip.getHostAddress());
			System.out.println(ip.getHostName());
			// 判断是否可以到
			System.out.println(ip.isReachable(5000));
			System.out.println(ip.getCanonicalHostName());
			
			System.out.println(ip.getLoopbackAddress());
			InetAddress local = InetAddress.getByAddress(new byte[] { 127, 0,
					0, 1 });
			System.out.println(local.isReachable(5000));
			//获得全限定名
			System.out.println(local.getCanonicalHostName());
			String mEncode = URLEncoder.encode("你好吗","UTF-8");
			System.out.println(mEncode);
			System.out.println(URLDecoder.decode(mEncode,"UTF-8"));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
