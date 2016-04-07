package com.hytx.web.cache;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cache")
public class UpdateCacheController {
	private static final Logger logger = LoggerFactory
			.getLogger(UpdateCacheController.class);
	@Autowired
	private CacheManager cacheManager;

	/****
	 * 清除所有缓存
	 * 
	 * @return
	 * @author houzz
	 * @date 2015年6月10日
	 */
	@RequestMapping(value = "cleanAll", produces = "application/json")
	@ResponseBody
	public Map<String, Object> cleanAllCache(HttpServletRequest request) {
		logger.info("清除所有缓存开始...");
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Collection<String> names = cacheManager.getCacheNames();
			if (names != null) {
				for (String name : names) {
					Cache cache = cacheManager.getCache(name);
					if (cache != null) {
						cache.clear();
					}
				}
			}
			map.put("status", true);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", false);
		}
		logger.info("清除所有缓存结束，清除状态为：{}", map.get("status"));
		return map;
	}

	/****
	 * 清除指定名称的缓存
	 * 
	 * @param name
	 *            缓存名称字符串，多个名称以逗号分隔连接在一起
	 * @return
	 * @author houzz
	 * @date 2015年6月10日
	 */
	@RequestMapping(value = "clean", produces = "application/json")
	@ResponseBody
	public boolean clean(@RequestParam("name") String name,
			HttpServletRequest request) {
		logger.info("清除指定缓存开始，清除的缓存名称有:{}", name);
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(name)) {
			return false;
		}
		String cacheNames[] = name.split(",");
		try {
			for (String cn : cacheNames) {
				Cache cache = cacheManager.getCache(cn);
				if (cache != null) {
					cache.clear();
				}
			}
			logger.info("缓存{}等清除成功", name);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
