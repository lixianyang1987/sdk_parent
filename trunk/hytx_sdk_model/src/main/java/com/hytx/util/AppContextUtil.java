package com.hytx.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AppContextUtil implements ApplicationContextAware {
	/*****
	 * 静态全局变量
	 */
	static ApplicationContext applicationContext;

	/**
	 * get，set方法
	 */
	public synchronized void setApplicationContext(
			ApplicationContext applicationContext) throws BeansException {
		AppContextUtil.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}

}
