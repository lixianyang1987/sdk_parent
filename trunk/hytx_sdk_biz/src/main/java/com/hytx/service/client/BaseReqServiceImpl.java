package com.hytx.service.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.hytx.cache.ThreadLocalCache;
import com.hytx.constance.BaseContance;
import com.hytx.dao.baseConf.ori.AppMapper;
import com.hytx.dao.baseConf.ori.AppServerMapper;
import com.hytx.dao.baseConf.ori.ChannelAppMapper;
import com.hytx.dao.baseConf.ori.OperateKeywordMapper;
import com.hytx.dao.baseConf.ori.OperateMapper;
import com.hytx.dao.baseConf.ori.PayPointMapper;
import com.hytx.dao.baseConf.ori.ProvinceRefMapper;
import com.hytx.dao.client.ex.ReqSmsCommandMapperEx;
import com.hytx.dao.client.ex.ReqSmsMapperEx;
import com.hytx.dao.client.ori.IpInfoMapper;
import com.hytx.dao.client.ori.ReqSmsCommandMapper;
import com.hytx.dto.client.AppConsumerDto;
import com.hytx.model.baseConf.App;
import com.hytx.model.baseConf.AppExample;
import com.hytx.model.baseConf.AppServer;
import com.hytx.model.baseConf.AppServerExample;
import com.hytx.model.baseConf.ChannelApp;
import com.hytx.model.baseConf.ChannelAppExample;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.baseConf.OperateExample;
import com.hytx.model.baseConf.OperateKeyword;
import com.hytx.model.baseConf.OperateKeywordExample;
import com.hytx.model.baseConf.PayPoint;
import com.hytx.model.baseConf.PayPointExample;
import com.hytx.model.baseConf.ProvinceRef;
import com.hytx.model.baseConf.ProvinceRefExample;
import com.hytx.model.client.IpInfo;
import com.hytx.model.client.IpInfoExample;
import com.hytx.model.client.ReqSmsCommand;
import com.hytx.service.baseConf.IChannelAppOperateService;
import com.hytx.service.baseConf.IChannelAppPayPointService;
import com.hytx.service.list.IUserFilterListService;
import com.hytx.util.AppContextUtil;

@Service("baseReqServiceImpl")
public class BaseReqServiceImpl implements IBaseReqService {
	private Logger logger = LoggerFactory.getLogger(BaseReqServiceImpl.class);
	@Autowired
	private ChannelAppMapper channelAppMapper;
	@Autowired
	private ProvinceRefMapper provinceRefMapper;
	@Autowired
	private ReqSmsMapperEx reqSmsMapperEx;
	@Autowired
	private PayPointMapper payPointMapper;
	@Autowired
	private OperateMapper operateMapper;
	@Autowired
	private OperateKeywordMapper operateKeywordMapper;
	@Autowired
	private IpInfoMapper ipInfoMapper;
	@Autowired
	private AppMapper appMapper;
	@Autowired
	private AppServerMapper appServerMapper;

	@Autowired
	private ReqSmsCommandMapper reqSmsCommandMapper;

	@Autowired
	private ReqSmsCommandMapperEx reqSmsCommandMapperEx;
	@Autowired
	private IUserFilterListService userFilterListService;
	@Autowired
	private IChannelAppOperateService channelAppOperateService;
	@Autowired
	private IChannelAppPayPointService channelAppPayPointService;

	private String dayStr = DateFormatUtils.format(new Date(), "yyyy-MM-dd");;
	private Map<String, Long> channelAppLimitMap = new ConcurrentHashMap<String, Long>();
	private Map<String, Long> appLimitMap = new ConcurrentHashMap<String, Long>();

	public Long getChannelAppDayLimit(Integer channelId, Integer appId,
			Integer provinceId) {
		String key = channelId + "-" + appId + "-" + provinceId;
		synchronized (dayStr) {
			String nowDay = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
			if (dayStr == null || !dayStr.equals(nowDay)) {
				channelAppLimitMap.clear();
				appLimitMap.clear();
				dayStr = nowDay;
			}
		}
		Long total = channelAppLimitMap.get(key);
		if (total == null) {
			total = reqSmsMapperEx.selectDayChannelAppConsumer(provinceId,
					channelId, appId, dayStr);
			if (total == null) {
				total = 0L;
			}
		}
		return total;
	}

	public Long appendChannelAppDayLimit(Integer channelId, Integer appId,
			Integer provinceId, long addNum) {
		String key = channelId + "-" + appId + "-" + provinceId;
		synchronized (dayStr) {
			String nowDay = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
			if (dayStr == null || !dayStr.equals(nowDay)) {
				channelAppLimitMap.clear();
				appLimitMap.clear();
				dayStr = nowDay;
			}
		}
		Long total = channelAppLimitMap.get(key);
		if (total == null) {
			total = reqSmsMapperEx.selectDayChannelAppConsumer(provinceId,
					channelId, appId, dayStr);
			if (total == null) {
				total = 0L;
			}
		}
		total = total + addNum;
		channelAppLimitMap.put(key, total);
		return total;
	}

	public Long getAppDayLimit(Integer appId, Integer provinceId) {
		String key = appId + "-" + provinceId;
		synchronized (dayStr) {
			String nowDay = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
			if (dayStr == null || !dayStr.equals(nowDay)) {
				channelAppLimitMap.clear();
				appLimitMap.clear();
				dayStr = nowDay;
			}
		}
		Long total = appLimitMap.get(key);
		if (total == null) {
			total = reqSmsMapperEx.selectDayAppConsumer(provinceId, appId,
					dayStr);
			if (total == null) {
				total = 0L;
			}
		}
		return total;
	}

	public Long appendAppDayLimit(Integer appId, Integer provinceId, long addNum) {
		String key = appId + "-" + provinceId;
		synchronized (dayStr) {
			String nowDay = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
			if (dayStr == null || !dayStr.equals(nowDay)) {
				channelAppLimitMap.clear();
				appLimitMap.clear();
				dayStr = nowDay;
			}
		}
		Long total = appLimitMap.get(key);
		if (total == null) {
			total = reqSmsMapperEx.selectDayAppConsumer(provinceId, appId,
					dayStr);
			if (total == null) {
				total = 0L;
			}
		}
		total = total + addNum;
		appLimitMap.put(key, total);
		return total;
	}

	public Long getDayUserAppConsumer(String imsi, Integer appId) {
		String dateStr = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
		String name = "getDayUserAppConsumer";
		String key = "getDayUserAppConsumer_" + imsi + "_" + appId + "_"
				+ dateStr;
		Long consumer = 0L;
		CacheManager cacheManager = (CacheManager) AppContextUtil
				.getBean("cacheManager");
		Cache cache = cacheManager.getCache(name);
		if (cache != null) {
			ValueWrapper valueWrapper = cache.get(key);
			if (valueWrapper != null) {
				Object obj = valueWrapper.get();
				consumer = (Long) obj;
			} else {
				List<AppConsumerDto> list = reqSmsMapperEx
						.selectUserAppsDayConsumer(imsi, dateStr);
				if (list != null && !list.isEmpty()) {
					for (AppConsumerDto dto : list) {
						String keyTemp = "getDayUserAppConsumer_" + imsi + "_"
								+ dto.getAppId() + "_" + dateStr;
						cache.put(keyTemp, dto.getConsumer());
						if (dto.getAppId().equals(appId)) {
							consumer = dto.getConsumer();
						}
					}
				}
			}
		} else {
			consumer = reqSmsMapperEx.selectDayUserAppConsumer(imsi, appId,
					dateStr);
		}
		return consumer;
	}

	public Long getMonthUserAppConsumer(String imsi, Integer appId) {
		String dateStr = DateFormatUtils.format(new Date(), "yyyy-MM");
		String name = "getMonthUserAppConsumer";
		String key = "getMonthUserAppConsumer_" + imsi + "_" + appId + "_"
				+ dateStr;
		Long consumer = 0L;
		CacheManager cacheManager = (CacheManager) AppContextUtil
				.getBean("cacheManager");
		Cache cache = cacheManager.getCache(name);
		if (cache != null) {
			ValueWrapper valueWrapper = cache.get(key);
			if (valueWrapper != null) {
				Object obj = valueWrapper.get();
				consumer = (Long) obj;
			} else {
				List<AppConsumerDto> list = reqSmsMapperEx
						.selectUserAppsMonthConsumer(imsi, dateStr);
				if (list != null && !list.isEmpty()) {
					for (AppConsumerDto dto : list) {
						String keyTemp = "getMonthUserAppConsumer_" + imsi
								+ "_" + dto.getAppId() + "_" + dateStr;
						cache.put(keyTemp, dto.getConsumer());
						if (dto.getAppId().equals(appId)) {
							consumer = dto.getConsumer();
						}
					}
				}
			}
		} else {
			consumer = reqSmsMapperEx.selectMonthUserAppConsumer(imsi, appId,
					dateStr);
		}
		return consumer;
	}

	public void addDayUserAppConsumer(String imsi, Integer appId, long addNum) {
		String dateStr = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
		String name = "getDayUserAppConsumer";
		String key = "getDayUserAppConsumer_" + imsi + "_" + appId + "_"
				+ dateStr;
		CacheManager cacheManager = (CacheManager) AppContextUtil
				.getBean("cacheManager");
		Cache cache = cacheManager.getCache(name);
		if (cache != null) {
			ValueWrapper valueWrapper = cache.get(key);
			if (valueWrapper != null) {
				Object consumer = valueWrapper.get();
				cache.put(key, ((Long) consumer) + addNum);
			}
		}
	}

	public void addMonthUserAppConsumer(String imsi, Integer appId, long addNum) {
		String dateStr = DateFormatUtils.format(new Date(), "yyyy-MM");
		String name = "getMonthUserAppConsumer";
		String key = "getMonthUserAppConsumer_" + imsi + "_" + appId + "_"
				+ dateStr;
		CacheManager cacheManager = (CacheManager) AppContextUtil
				.getBean("cacheManager");
		Cache cache = cacheManager.getCache(name);
		if (cache != null) {
			ValueWrapper valueWrapper = cache.get(key);
			if (valueWrapper != null) {
				Object consumer = valueWrapper.get();
				cache.put(key, ((Long) consumer) + addNum);
			}
		}
	}

	@Cacheable(value = "selectChannelAppByKey", key = "'selectChannelAppByKey_'+#channelAppKey")
	public ChannelApp selectChannelAppByKey(String channelAppKey) {
		ChannelAppExample example = new ChannelAppExample();
		example.createCriteria().andKeyEqualTo(channelAppKey);
		List<ChannelApp> list = channelAppMapper.selectByExample(example);
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Cacheable(value = "selectOpenProvinceRef", key = "'selectOpenProvinceRef_'+#recordId+'_'+#refType")
	public List<ProvinceRef> selectOpenProvinceRef(Integer recordId,
			Integer refType) {
		ProvinceRefExample example = new ProvinceRefExample();
		example.createCriteria().andRecordIdEqualTo(recordId)
				.andRefTypeEqualTo(refType);
		return provinceRefMapper.selectByExample(example);
	}

	public long selectDayConsumer(String imsi) {
		String dateStr = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
		Long dayConsumer = reqSmsMapperEx.selectDayConsumer(imsi, dateStr);
		if (dayConsumer != null) {
			return dayConsumer;
		}
		return 0;
	}

	public long selectMonthConsumer(String imsi) {
		String monthStr = DateFormatUtils.format(new Date(), "yyyy-MM");
		Long monthConsumer = reqSmsMapperEx.selectMonthConsumer(imsi, monthStr);
		if (monthConsumer != null) {
			return monthConsumer;
		}
		return 0;
	}

	@Cacheable(value = "selectAllActivityStaticPayPoint", key = "'selectAllActivityStaticPayPoint_'+#serverType+'_'+#feeValue")
	public List<PayPoint> selectAllActivityStaticPayPoint(Integer serverType,
			Integer feeValue) {
		PayPointExample example = new PayPointExample();
		example.createCriteria().andStatusEqualTo(BaseContance.ACTIVICE_STATUS)
				.andServerTypeEqualTo(serverType)
				.andOpTypeEqualTo(BaseContance.OPERATE_TYPE_STATIC)
				.andFeeValueEqualTo(feeValue);
		return payPointMapper.selectByExample(example);
	}

	public List<PayPoint> selectChannelAppStaticActivityPayPoint(
			Integer channelAppId, Integer serverType, Integer feeValue) {
		List<PayPoint> list = selectAllActivityStaticPayPoint(serverType,
				feeValue);
		if (list == null || list.isEmpty()) {
			return list;
		}
		Set<Integer> idsSet = channelAppPayPointService
				.selectChannelAppPayPointIds(channelAppId);
		if (idsSet == null || idsSet.isEmpty()) {
			return new ArrayList<PayPoint>(0);
		}
		List<PayPoint> resultList = new ArrayList<PayPoint>();
		for (PayPoint p : list) {
			if (idsSet.contains(p.getId())) {
				resultList.add(p);
			}
		}
		return resultList;
	}

	@Cacheable(value = "selectAllActivityDynaPayPoint", key = "'selectAllActivityDynaPayPoint_'+#serverType")
	public List<PayPoint> selectAllActivityDynaPayPoint(Integer serverType) {
		PayPointExample example = new PayPointExample();
		example.createCriteria().andStatusEqualTo(BaseContance.ACTIVICE_STATUS)
				.andServerTypeEqualTo(serverType)
				.andOpTypeEqualTo(BaseContance.OPERATE_TYPE_DYNAMIC);
		return payPointMapper.selectByExample(example);
	}

	@Override
	public List<PayPoint> selectCaActivityDynaPayPoint(Integer channelAppId,
			Integer serverType) {
		List<PayPoint> list = selectAllActivityDynaPayPoint(serverType);
		if (list == null || list.isEmpty()) {
			return list;
		}
		Set<Integer> idsSet = channelAppPayPointService
				.selectChannelAppPayPointIds(channelAppId);
		if (idsSet == null || idsSet.isEmpty()) {
			return new ArrayList<PayPoint>(0);
		}
		List<PayPoint> resultList = new ArrayList<PayPoint>();
		for (PayPoint p : list) {
			if (idsSet.contains(p.getId())) {
				resultList.add(p);
			}
		}
		return resultList;
	}

	@Cacheable(value = "selectServerAppStaticOperates", key = "'selectServerAppStaticOperates_'+#serverType+'_'+#appId")
	public List<Operate> selectServerAppStaticOperates(Integer serverType,
			Integer appId) {
		OperateExample example = new OperateExample();
		example.createCriteria().andServerTypeEqualTo(serverType)
				.andOpTypeEqualTo(BaseContance.OPERATE_TYPE_STATIC)
				.andStatusEqualTo(BaseContance.ACTIVICE_STATUS)
				.andAppIdEqualTo(appId);
		return operateMapper.selectByExample(example);
	}

	@Cacheable(value = "selectServerStaticOperates", key = "'selectServerStaticOperates_'+#serverType")
	public List<Operate> selectServerStaticOperates(Integer serverType) {
		OperateExample example = new OperateExample();
		example.createCriteria().andServerTypeEqualTo(serverType)
				.andStatusEqualTo(BaseContance.ACTIVICE_STATUS)
				.andOpTypeEqualTo(BaseContance.OPERATE_TYPE_STATIC);
		return operateMapper.selectByExample(example);
	}

	@Override
	public List<Operate> selectCaServerStaticOperates(Integer channelAppId,
			Integer serverType) {
		List<Operate> list = selectServerStaticOperates(serverType);
		if (list == null || list.isEmpty()) {
			return list;
		}
		Set<Integer> idsSet = channelAppOperateService
				.selectChannelAppOperateIds(channelAppId);
		if (idsSet == null || idsSet.isEmpty()) {
			return new ArrayList<Operate>(0);
		}
		List<Operate> resultList = new ArrayList<Operate>();
		for (Operate op : list) {
			if (idsSet.contains(op.getId())) {
				resultList.add(op);
			}
		}
		return resultList;
	}

	@Cacheable(value = "selectServerDynaOperates", key = "'selectServerStaticOperates_'+#serverType")
	public List<Operate> selectServerDynaOperates(Integer serverType) {
		OperateExample example = new OperateExample();
		example.createCriteria().andServerTypeEqualTo(serverType)
				.andStatusEqualTo(BaseContance.ACTIVICE_STATUS)
				.andOpTypeEqualTo(BaseContance.OPERATE_TYPE_DYNAMIC);
		return operateMapper.selectByExample(example);
	}

	public List<Operate> selectCaServerDynaOperates(Integer channelAppId,
			Integer serverType) {
		List<Operate> list = selectServerDynaOperates(serverType);
		if (list == null || list.isEmpty()) {
			return list;
		}
		Set<Integer> idsSet = channelAppOperateService
				.selectChannelAppOperateIds(channelAppId);
		if (idsSet == null || idsSet.isEmpty()) {
			return new ArrayList<Operate>(0);
		}
		List<Operate> resultList = new ArrayList<Operate>();
		for (Operate op : list) {
			if (idsSet.contains(op.getId())) {
				resultList.add(op);
			}
		}
		return resultList;
	}

	/****
	 * 查询所有的屏蔽信息，以指令id为key，屏蔽信息列表为值组装成map返回
	 * 
	 * @return
	 * @author houzz
	 * @date 2015年6月4日
	 */
	@Cacheable(value = "selectAllOperateKeyword", key = "'selectAllOperateKeyword'")
	public Map<Integer, List<OperateKeyword>> selectAllOperateKeyword() {
		Map<Integer, List<OperateKeyword>> map = new HashMap<Integer, List<OperateKeyword>>();
		OperateKeywordExample example = new OperateKeywordExample();
		example.createCriteria().andStatusGreaterThan(
				BaseContance.NOT_ACTIVICE_STATUS);
		List<OperateKeyword> list = operateKeywordMapper
				.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			for (OperateKeyword ok : list) {
				List<OperateKeyword> listOpKey = map.get(ok.getOperateId());
				if (listOpKey == null) {
					listOpKey = new ArrayList<OperateKeyword>();
					listOpKey.add(ok);
					map.put(ok.getOperateId(), listOpKey);
				} else {
					listOpKey.add(ok);
				}
			}
		}
		return map;
	}

	@Cacheable(value = "selectIpInfoByIp", key = "'selectIpInfoByIp_'+#ip")
	public IpInfo selectIpInfoByIp(long ip) {
		IpInfoExample example = new IpInfoExample();
		example.createCriteria().andStartIpNumLessThanOrEqualTo(ip)
				.andEndIpNumGreaterThanOrEqualTo(ip);
		List<IpInfo> list = ipInfoMapper.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	/****
	 * 验证渠道包计费是否超出省份限量,渠道包计费状态未打开也认为是超出限量
	 * 
	 * @param channelApp
	 * @param provinceId
	 *            省份id,为空时认为未超限量，返回true
	 * @param feeValue
	 *            本次消费金额
	 * @return 未超出限量回返true,否则返回false
	 */
	public boolean validChannelApp(ChannelApp channelApp, Integer provinceId,
			Integer feeValue) {
		if (provinceId == null) {
			return true;
		}
		if (channelApp.getFeeStatus() != BaseContance.ACTIVICE_STATUS) {
			return false;
		}
		List<ProvinceRef> provinceRefList = selectOpenProvinceRef(
				channelApp.getId(), BaseContance.PROVINCE_REF_TYPE_CHANNEL_APP);
		if (provinceRefList == null || provinceRefList.isEmpty()) {
			return true;
		}
		for (ProvinceRef p : provinceRefList) {
			if (p.getProvinceId().equals(provinceId)) {
				// 考虑限量问题
				if (p.getDayLimit() < 1) {
					return true;
				}
				Long appDayLimit = getChannelAppDayLimit(
						channelApp.getChannelId(), channelApp.getAppId(),
						provinceId);
				if (appDayLimit + feeValue > p.getDayLimit()) {
					return false;
				}
				return true;
			}
		}
		return false;
	}

	/***
	 * 检查某应用的省份日限量是否在允许范围内
	 * 
	 * @param appId
	 * @param provinceId
	 * @return 未超出返回true 否则返回false
	 * @author houzz
	 * @since 2015年5月27日
	 */
	public boolean checkAppProvinceLimit(Integer appId, Integer provinceId) {
		if (provinceId == null) {
			return true;
		}
		List<ProvinceRef> provinceRefList = selectOpenProvinceRef(appId,
				BaseContance.PROVINCE_REF_TYPE_APP);
		if (provinceRefList == null || provinceRefList.isEmpty()) {
			return false;
		}
		for (ProvinceRef p : provinceRefList) {
			if (p.getProvinceId().equals(provinceId)) {
				if (p.getDayLimit() < 1) {
					return true;
				}
				Long appDayLimit = getAppDayLimit(appId, provinceId);
				return p.getDayLimit() > appDayLimit;
			}
		}
		return false;
	}

	/*****
	 * 检查用户计费是否未超出某应用的用户日月限
	 * 
	 * @param imsi
	 * @param app
	 * @param feeValue
	 * @return 未超出返回true 否则返回false
	 * @author houzz
	 * @date 2015年6月23日
	 */
	public boolean checkUserAppLimit(String imsi, Integer serverType, App app,
			long feeValue) {
		if (feeValue <= 0) {
			return true;
		}
		Integer listType = userFilterListService.checkUserFilterType(imsi);
		if (listType != null) {
			// 白名单
			if (listType.equals(BaseContance.WHITE_LIST_TYPE)) {
				return true;
			}
			// 黑名单
			if (listType.equals(BaseContance.BLACK_LIST_TYPE)) {
				return false;
			}
		}
		Integer appId = app.getId();
		Map<Integer, Long> userAppDayConsumerMap = ThreadLocalCache.appDayConsumer
				.get();
		if (userAppDayConsumerMap == null) {
			userAppDayConsumerMap = new HashMap<Integer, Long>();
			ThreadLocalCache.appDayConsumer.set(userAppDayConsumerMap);
		}
		Map<Integer, Long> userAppMonthConsumerMap = ThreadLocalCache.appMonthConsumer
				.get();
		if (userAppMonthConsumerMap == null) {
			userAppMonthConsumerMap = new HashMap<Integer, Long>();
			ThreadLocalCache.appMonthConsumer.set(userAppMonthConsumerMap);
		}
		boolean resultDay = false;
		Integer dayLimit = getAppServer(app.getId(), serverType).getDayLimit();
		if (dayLimit == null || dayLimit < 1) {
			resultDay = true;
		} else {
			Long dayUserAppConsumer = userAppDayConsumerMap.get(appId);
			if (dayUserAppConsumer == null) {
				dayUserAppConsumer = getDayUserAppConsumer(imsi, app.getId());
				userAppDayConsumerMap.put(appId, dayUserAppConsumer);
			}
			resultDay = (dayLimit >= dayUserAppConsumer + feeValue);
		}
		if (!resultDay) {
			return false;
		}
		boolean resultMonth = false;
		Integer monthLimit = getAppServer(app.getId(), serverType)
				.getMonthLimit();
		if (monthLimit == null || monthLimit < 1) {
			resultMonth = true;
		} else {
			Long monthUserAppConsumer = userAppMonthConsumerMap.get(appId);
			if (monthUserAppConsumer == null) {
				monthUserAppConsumer = getDayUserAppConsumer(imsi, app.getId());
				userAppMonthConsumerMap.put(appId, monthUserAppConsumer);
			}
			resultMonth = (monthLimit >= monthUserAppConsumer + feeValue);
		}
		if (!resultMonth) {
			return false;
		}
		Long consumerDay = userAppDayConsumerMap.get(appId);
		if (consumerDay == null) {
			consumerDay = 0L;
		}
		userAppDayConsumerMap.put(appId, consumerDay + feeValue);
		Long consumerMonth = userAppDayConsumerMap.get(appId);
		if (consumerMonth == null) {
			consumerMonth = 0L;
		}
		userAppMonthConsumerMap.put(appId, consumerMonth + feeValue);
		return true;
	}

	/****
	 * 查询所有的应用信息，以应用id为key，应用实例为值组装成map返回
	 * 
	 * @return
	 * @author houzz
	 * @date 2015年6月4日
	 */
	@Cacheable(value = "selectAllAppMap", key = "'selectAllAppMap'")
	public Map<Integer, App> selectAllAppMap() {
		Map<Integer, App> map = new HashMap<Integer, App>();
		AppExample example = new AppExample();
		example.createCriteria().andStatusEqualTo(BaseContance.ACTIVICE_STATUS);
		List<App> list = appMapper.selectByExample(example);
		if (list != null && !list.isEmpty()) {
			for (App app : list) {
				map.put(app.getId(), app);
			}
		}
		return map;
	}

	public App selectAppById(Integer id) {
		Map<Integer, App> map = selectAllAppMap();
		if (map != null) {
			return map.get(id);
		}
		return null;
	}

	@Cacheable(value = "selectAllAppServers", key = "'selectAllAppServers'")
	public Map<String, AppServer> selectAllAppServers() {
		Map<String, AppServer> map = new HashMap<String, AppServer>();
		AppServerExample example = new AppServerExample();
		example.createCriteria().andStatusEqualTo(BaseContance.ACTIVICE_STATUS);
		example.setOrderByClause(" update_dt asc");
		List<AppServer> list = appServerMapper.selectByExample(example);
		if (list != null) {
			for (AppServer as : list) {
				map.put(as.getAppId() + "_" + as.getServerType(), as);
			}
		}
		return map;
	}

	public AppServer getAppServer(Integer appId, Integer serverType) {
		Map<String, AppServer> map = selectAllAppServers();
		AppServer as = map.get(appId + "_" + serverType);
		if (as == null) {
			as = new AppServer();
		}
		logger.info(
				"--------appId:{} serverType:{}---appServer-is null?{}----------",
				appId, serverType, as.getId() == null);
		return as;
	}

	public int updateReqSmsCommandByPrimaryKey(ReqSmsCommand rsc) {
		return reqSmsCommandMapper.updateByPrimaryKey(rsc);
	}

	@Override
	public List<ReqSmsCommand> selectNoSyncByOrderTime(Integer appId,
			Integer feeValue, String orderDt) {
		// 正常情况下订单的时间不可能大于当前时间，由于平台时间不一致，如果发现查询的订单时间大于当前平台的
		// 当前时间，则用当前平台的当前时间做为查询条件
		String nowDayStr = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
		if (nowDayStr.compareTo(orderDt) < 0) {
			orderDt = nowDayStr;
		}
		return reqSmsCommandMapperEx.selectNoSyncByOrderTime(appId, feeValue,
				orderDt);
	}

}
