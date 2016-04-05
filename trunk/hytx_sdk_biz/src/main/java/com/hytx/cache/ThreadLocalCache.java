package com.hytx.cache;

import java.util.List;
import java.util.Map;

import com.hytx.model.baseConf.OperateKeyword;

public class ThreadLocalCache {
	/** 动态指态获取的屏蔽信息 */
	public static ThreadLocal<Map<Integer, List<OperateKeyword>>> dynaOpKeyword = new ThreadLocal<Map<Integer, List<OperateKeyword>>>();
	/** 用户对应用的日消费 */
	public static ThreadLocal<Map<Integer, Long>> appDayConsumer = new ThreadLocal<Map<Integer, Long>>();
	/** 用户对应用的月消费 */
	public static ThreadLocal<Map<Integer, Long>> appMonthConsumer = new ThreadLocal<Map<Integer, Long>>();
	/** 存放一些参数值 */
	public static ThreadLocal<Map<String, Object>> metas = new ThreadLocal<Map<String, Object>>();

	public static void cleanAllThreadLocal() {
		appDayConsumer.remove();
		appMonthConsumer.remove();
		dynaOpKeyword.remove();
		metas.remove();
	}

	public static boolean hasOrderdMark() {
		Map<String, Object> metas = ThreadLocalCache.metas.get();
		if (metas != null && metas.get("hasOrderd") != null) {
			boolean hasOrderd = (boolean) metas.get("hasOrderd");
			if (hasOrderd) {
				return true;
			}
		}
		return false;
	}

}
