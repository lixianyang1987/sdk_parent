package com.hytx.util;

import java.net.URLDecoder;

/***
 * 此类用于将应用id和渠道id进行简单加密成定长字符串，并根据给定加密串解析出应用id和渠道id
 * 
 * @author houzz
 */
public class ChannelAppKeyUtil {
	/**
	 * 渠道id基数
	 */
	private static final int CHANNEL_ID_BASE = 770000;
	/**
	 * 加解密码参照字母表
	 */
	private static final char charArray[] = new char[] { '0', '1', '2', '3',
			'4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
			'h', 'i', 'k', 'x', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
			'v', 'w' };

	/***
	 * 根据应用id和渠道id进行加密
	 * 
	 * @param appId
	 * @param channelId
	 * @return
	 * @throws Exception
	 */
	public static String createChannelAppKey(int appId, int channelId)
			throws Exception {
		if (channelId > CHANNEL_ID_BASE) {
			channelId = channelId - CHANNEL_ID_BASE;
		}
		return encryKeyStr(appId) + encryKeyStr(channelId);
	}

	/**
	 * 将int值转成长度为3的加密字符串，int值必须在0到32767的范围内
	 * 
	 * @param n
	 * @return
	 * @throws Exception
	 */
	public static String encryKeyStr(int n) throws Exception {
		if (n < 0 || n > 32767) {
			throw new Exception("加密数值不在可接受范围内，正常应该在0到32767之间");
		}
		char ch[] = new char[3];
		for (int i = 0; i < 3; i++) {
			int m = n & 0x1f;
			ch[i] = charArray[m];
			n = n >> 5;
		}
		return new String(ch);
	}

	/**
	 * 解密字符串成整型值
	 * 
	 * @param s
	 * @return
	 * @throws Exception
	 */
	public static int decryKeyStr(String s) throws Exception {
		if (s == null || s.length() != 3) {
			throw new Exception("解密字符串长度必须是3");
		}
		int n = 0;
		char ch[] = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			int index = getCharInArrayIndex(ch[i]);
			if (index > -1) {
				n = n | (index << (i * 5));
			} else {
				throw new Exception("解密字符串失败，此字符串不能解密");
			}
		}
		return n;
	}

	/***
	 * 解密码渠道包key成对应用应用id和渠道id
	 * 
	 * @param s
	 * @return 返回长度为2的整形数组,下标0表示应用id,下标1表示渠道id
	 * @throws Exception
	 */
	public static int[] decryChannelAppKey(String s) throws Exception {
		if (s == null || s.length() != 6) {
			throw new Exception("解密字符串长度必须是6");
		}
		int result[] = new int[2];
		result[0] = decryKeyStr(s.substring(0, 3));
		result[1] = decryKeyStr(s.substring(3)) + CHANNEL_ID_BASE;
		return result;
	}

	/**
	 * 获取给定字符在参照字母表中的下标
	 * 
	 * @param c
	 * @return
	 */
	public static int getCharInArrayIndex(char c) {
		int index = -1;
		for (int i = 0; i < charArray.length; i++) {
			if (c == charArray[i]) {
				index = i;
				break;
			}
		}
		return index;
	}

	public static void main(String[] args) throws Exception {
		/*String key=createChannelAppKey(180, 771871);
		System.out.println(key);
		int result[]=decryChannelAppKey(key);
		System.out.print("appId:"+result[0]+ "  渠道id:"+result[1]);*/
		String s = "%e5%8c%97%e4%ba%ac%2c%e5%8c%97%e4%ba%ac";
		System.out.println(URLDecoder.decode(s, "UTF-8"));
	}

}
