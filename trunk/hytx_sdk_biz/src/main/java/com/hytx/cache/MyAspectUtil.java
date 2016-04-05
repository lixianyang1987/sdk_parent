package com.hytx.cache;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hytx.constance.ResourceUtil;

public class MyAspectUtil {
	private static Logger logger = LoggerFactory.getLogger(MyAspect.class);
	private static volatile Set<String> set = Collections
			.synchronizedSet(new HashSet<String>());
	private static String CLEAN_CACHE_URL = ResourceUtil.getCleanCacheUrl();

	private static volatile boolean running = false;

	public synchronized static void cleanCacheByName(String... names) {
		logger.info("需要清除缓存为：{}", names);
		if (names == null) {
			return;
		}
		for (String name : names) {
			set.add(name);
		}
		if (!running) {
			running = true;
			Thread t = new Thread(new MyRunnable());
			try {
				t.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			t.start();
		}
	}

	private static class MyRunnable implements Runnable {
		private Set<String> localSet = new HashSet<String>();

		@Override
		public void run() {
			while (true) {
				HttpClient client = new HttpClient();
				client.getParams().setContentCharset("UTF-8");
				String name = "";
				localSet.addAll(set);
				set.clear();
				for (String s : localSet) {
					if (name.length() > 0) {
						name = name + "," + s;
					} else {
						name = s;
					}
				}
				PostMethod method = new PostMethod(CLEAN_CACHE_URL + "?name="
						+ name);
				logger.info("发起请缓存请求，本次请求清除的缓存为：{}", name);
				try {
					client.executeMethod(method);
					if (method.getStatusCode() == HttpStatus.SC_OK) {
						String content = method.getResponseBodyAsString();
						if (content.equals("true")) {
							logger.info("缓存为{}清除成功", name);
							// 如果没有要清除的缓存时退出循环，否则继续处理
							if (set.isEmpty()) {
								break;
							}
							localSet.clear();
						}
					}
				} catch (HttpException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				logger.info("缓存为{}清除失败", name);
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			running = false;
		}
	}

}
