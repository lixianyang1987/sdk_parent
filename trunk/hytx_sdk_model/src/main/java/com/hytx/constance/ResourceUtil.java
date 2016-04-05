package com.hytx.constance;

import java.util.Locale;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.hytx.util.AppContextUtil;

public class ResourceUtil {
	private static ReloadableResourceBundleMessageSource messageSource = (ReloadableResourceBundleMessageSource) AppContextUtil
			.getBean("messageSource");

	public static String getKey(String key) {
		return messageSource.getMessage(key, null, Locale.getDefault());
	}

	/***
	 * 获取清除缓存的url
	 * 
	 * @return
	 * @author houzz
	 * @date 2015年6月11日
	 */
	public static String getCleanCacheUrl() {
		return getKey("cache.clean.url");
	}

	public static String getChannelId() {
		return getKey("channelid");
	}

	public static String getZqrdChannelId() {
		return getKey("ZqrdChannelId");
	}

	public static String getZqrdChannelIdTo() {
		return getKey("ZqrdChannelIdTo");
	}

	public static String getDxltChannelIdTo() {
		return getKey("dxlt");
	}

	public static String getChannelIdM16() {
		// TODO Auto-generated method stub
		return getKey("M16");
	}

	public static String getChannelIdM19() {
		// TODO Auto-generated method stub
		return getKey("M19");
	}

	public static String getZqrdChannelIdTh() {
		// TODO Auto-generated method stub
		return getKey("ZqrdChannelIdTh");
	}

	public static String getZqrdChannelIdFo() {
		// TODO Auto-generated method stub
		return getKey("ZqrdChannelIdFo");
	}

	public static String getSyskmmChannelId() {
		// TODO Auto-generated method stub
		return getKey("syskmm");
	}

	public static String getChannelappId(String str) {
		// TODO Auto-generated method stub
		return getKey(str);
	}

}
