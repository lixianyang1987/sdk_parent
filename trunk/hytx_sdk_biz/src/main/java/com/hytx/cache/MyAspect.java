package com.hytx.cache;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.hytx.service.baseConf.AppServerServiceImpl;
import com.hytx.service.baseConf.AppServiceImpl;
import com.hytx.service.baseConf.ChannelAppOperateServiceImpl;
import com.hytx.service.baseConf.ChannelAppPayPointServiceImpl;
import com.hytx.service.baseConf.ChannelAppServiceImpl;
import com.hytx.service.baseConf.DictServiceImpl;
import com.hytx.service.baseConf.OperateKeywordServiceImpl;
import com.hytx.service.baseConf.OperateServiceImpl;
import com.hytx.service.baseConf.PayPointOperateServiceImpl;
import com.hytx.service.baseConf.PayPointServiceImpl;
import com.hytx.service.baseConf.ProvinceServiceImpl;
import com.hytx.service.list.UserFilterListServiceImpl;

@Component
@Aspect
public class MyAspect {
	private static Logger logger = LoggerFactory.getLogger(MyAspect.class);

	@Pointcut("execution(* com.hytx.service.baseConf.*.update*(..))"
			+ "||execution(* com.hytx.service.baseConf.*.insert*(..))"
			+ "||execution(* com.hytx.service.baseConf.*.delete*(..))"
			+ "||execution(* com.hytx.service.baseConf.*.add*(..))")
	public void init() {

	}

	@After(value = "init()")
	public void afterAdvice(JoinPoint point) {
		logger.debug("@After：检查更新前端缓存");
		logger.debug("@After：目标方法为："
				+ point.getSignature().getDeclaringTypeName() + "."
				+ point.getSignature().getName());
		Object target = point.getTarget();
		/*
		MyClearCache myClearCache = target.getClass().getAnnotation(
				MyClearCache.class);
		if (myClearCache != null) {
			String cacheNames[] = myClearCache.value();
			if (cacheNames != null && cacheNames.length > 0) {
				MyAspectUtil.cleanCacheByName(cacheNames);
				return;
			}
		}*/

		if (target instanceof ChannelAppServiceImpl) {
			MyAspectUtil.cleanCacheByName("selectChannelAppByKey");
		} else if (target instanceof AppServiceImpl) {
			MyAspectUtil.cleanCacheByName("selectAllAppMap");
		} else if (target instanceof OperateServiceImpl) {
			MyAspectUtil.cleanCacheByName("selectServerStaticOperates",
					"selectServerAppStaticOperates",
					"selectServerDynaOperates", "selectOperateByPayPointIds",
					"selectActivityOperatesByAppId");

		} else if (target instanceof PayPointServiceImpl) {
			MyAspectUtil.cleanCacheByName("selectAllActivityStaticPayPoint",
					"selectAllActivityDynaPayPoint");
		} else if (target instanceof OperateKeywordServiceImpl) {
			MyAspectUtil.cleanCacheByName("selectAllOperateKeyword");
		} else if (target instanceof PayPointOperateServiceImpl) {
			MyAspectUtil.cleanCacheByName("selectOperateByPayPointIds");
		} else if (target instanceof ProvinceServiceImpl) {
			MyAspectUtil.cleanCacheByName("selectOpenProvinceRef",
					"findProvinceByName");
		} else if (target instanceof AppServerServiceImpl) {
			MyAspectUtil.cleanCacheByName("selectAllAppServers");
		} else if (target instanceof UserFilterListServiceImpl) {
			MyAspectUtil.cleanCacheByName("selectAllUserFilterList");
		} else if (target instanceof DictServiceImpl) {
			MyAspectUtil.cleanCacheByName("selectActiviteDictByKey");
		} else if (target instanceof ChannelAppPayPointServiceImpl) {
			MyAspectUtil.cleanCacheByName("selectChannelAppPayPointIds");
		} else if (target instanceof ChannelAppOperateServiceImpl) {
			MyAspectUtil.cleanCacheByName("selectChannelAppOperateIds");
		}
		logger.debug("@After：参数为：" + Arrays.toString(point.getArgs()));
		logger.debug("@After：被织入的目标对象为：" + point.getTarget());
	}

}
