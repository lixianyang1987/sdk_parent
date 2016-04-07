package com.hytx.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public final class StringUtil {

	/***
	 * 功能描述：将以逗号分隔的字符串转化成Integer集合
	 * 
	 * @param ids
	 * @author houzz
	 * @since 2015-01-03
	 * @return
	 */
	public static List<Integer> changeStringIdsToIntegerList(String ids) {
		List<Integer> idList = new ArrayList<Integer>();
		if (StringUtils.isEmpty(ids)) {
			return idList;
		}
		try {
			String idsArr[] = ids.split(",");
			for (String id : idsArr) {
				idList.add(Integer.parseInt(id));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idList;
	}

	/****
	 * 格式化字符串成某长度的字符串，长度不够时左边补0
	 * 
	 * @param s
	 * @param len
	 * @return
	 * @author houzz
	 * @date 2015年6月1日
	 */
	public static String format(String s, int len) {
		if (s == null || s.length() >= len) {
			return s;
		}
		for (int i = 0, l = len - s.length(); i < l; i++) {
			s = "0" + s;
		}
		return s;
	}

	/***
	 * 将带标记的字符串转化成最终的值字符串，标记格式形如{0}
	 * 
	 * @param content
	 * @param args
	 * @return
	 * @author houzz
	 * @date 2015年6月5日
	 */
	public static String formatContent(String content, Object... args) {
		if (content == null) {
			return null;
		}
		return MessageFormat.format(content, args);
	}

	public static boolean validMobile(String mobile) {
		// String regex = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
		if (mobile == null) {
			return false;
		}
		if (mobile.startsWith("+86")) {
			mobile = mobile.substring(3);
		}
		if (mobile.length() != 11) {
			return false;
		}
		String regex = "^1\\d{10}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mobile);
		return m.matches();
	}

}
