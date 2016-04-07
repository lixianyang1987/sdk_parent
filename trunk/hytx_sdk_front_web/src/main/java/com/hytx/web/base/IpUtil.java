package com.hytx.web.base;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

public class IpUtil {
	/****
	 * 统一获取ip的方法，为了满足以后使用nginx代理时的情况。
	 * 
	 * @param request
	 * @return
	 * @author houzz
	 * @date 2015年6月4日
	 */
	public static String getRealIp(HttpServletRequest request) {
		String host = request.getRemoteHost();
		if (!StringUtils.isEmpty(host)) {
			return host;
		}
		// 使用nginx时进行扩展
		return request.getRemoteAddr();
	}

	/****
	 * 获取ip的long值
	 * 
	 * @param ip
	 * @return
	 * @author houzz
	 * @date 2015年6月5日
	 */
	public static long getIpLongValue(String ip) {
		String ipArr[] = ip.split("\\.");
		long n = 0;
		n = (Long.parseLong(ipArr[0]) << 24) + (Long.parseLong(ipArr[1]) << 16)
				+ (Long.parseLong(ipArr[2]) << 8) + Long.parseLong(ipArr[3]);
		return n;
	}

	public static void main(String[] args) {
		System.out.println(getIpLongValue("106.38.204.180"));
	}
}
