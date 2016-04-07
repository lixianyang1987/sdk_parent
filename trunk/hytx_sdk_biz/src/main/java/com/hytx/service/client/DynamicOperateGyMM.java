package com.hytx.service.client;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.cache.ThreadLocalCache;
import com.hytx.constance.BaseContance;
import com.hytx.dao.sync.ori.SyncProvinceZjhyMapper;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.baseConf.Province;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;
import com.hytx.model.sync.SyncProvinceZjhyExample;
import com.hytx.service.baseConf.IProvinceService;
import com.hytx.service.sync.ISyncSzqcReqService;

@Service("dynamicOperateGymm")
public class DynamicOperateGyMM implements IDynamicOperate {
	private Logger logger = LoggerFactory.getLogger("CLIENT_LOG");
	@Autowired
	private ISyncSzqcReqService syncSzqcReqService;
	@Autowired
	private IReqSmsService reqSmsService;
	@Autowired
	private IProvinceService provinceService;
	@Autowired
	private SyncProvinceZjhyMapper provincezjhy;

	/**
	 * 获取MM动态指令
	 * */
	@Override
	public ReqSmsCommand getReqSmsCommand(ReqSms smsReq, BaseReqDto baseReqDto,
			Operate dynaOperate) {
		//
		Integer feeValue = dynaOperate.getPrice() == null
				|| dynaOperate.getPrice() < 1 ? smsReq.getFeeValue()
				: dynaOperate.getPrice();

		String brand = "";
		String phoneType = "";
		String[] ua = smsReq.getUa().split(",");
		String[] phoneua = ua[0].split(" ");
		String osbuild = ua[1];
		if (phoneua.length == 1) {
			phoneType = phoneua[0];
		} else {
			brand = phoneua[0];
			phoneType = phoneua[1];
		}
		if (baseReqDto.getProvinceId() == null) {
			return null;
		}
		Province p = provinceService.selectByPrimaryKey(baseReqDto
				.getProvinceId());
		String province = p.getProvinceName();
		SyncProvinceZjhyExample example = new SyncProvinceZjhyExample();
		example.createCriteria().andProvincenameEqualTo(province);
		int provinceid = provincezjhy.selectByExample(example).get(0)
				.getProvinceid();
		StringBuilder sb = new StringBuilder();
		/**
		 *
		 *
		 * &phoneType=E700&brand=Coolpad&osbuild=21&fee=1000&cpid=a695fa32
		 * channelOrderId=10062813&msg=zxtd100915
		 * 
		 * */

		sb.append("http://14.17.74.121:9900/sppayv2.do?").append("imsi=")
				.append(baseReqDto.getImsi()).append("&imei=")
				.append(baseReqDto.getImei()).append("&fee=").append("1000")
				.append("&phoneType=").append(phoneType).append("&province=")
				.append(provinceid).append("&operator=").append(1)
				.append("&brand=").append(brand).append("&cpid=")
				.append("a695fa32").append("&channelOrderId=")
				.append("10062813").append("&osbuild=").append(osbuild)
				.append("&ip=").append(smsReq.getIp());
		String content = "";
		ReqSmsCommand command = new ReqSmsCommand();
		try {
			HttpClient client = new HttpClient();
			client.getParams().setContentCharset("UTF-8");
			GetMethod method = new GetMethod(sb.toString());
			client.executeMethod(method);
			content = method.getResponseBodyAsString();

			logger.info("动态请求返回：");
			logger.info(content);

			if (!StringUtils.isBlank(content)) {
				JSONObject jsonObject = JSONObject.fromObject(content);
				int status = Integer.parseInt(jsonObject.getString("result"));
				String smsmsg = jsonObject.getString("smsmsg");
				String smsport = jsonObject.getString("smsport");
				int rc = jsonObject.getInt("rc");

				if (rc == 0) {
					if (status == 1) {
						// 计费成功
						Map<String, Object> map = ThreadLocalCache.metas.get();
						if (map == null) {
							map = new HashMap<String, Object>();
						}
						map.put("hasOrderd", true);
						ThreadLocalCache.metas.set(map);
						return null;
					} else if (status == 0) {
						// 获取指令
						byte[] s = Base64.decodeBase64(smsmsg);
						command.setAppId(dynaOperate.getAppId());
						command.setFeeValue(feeValue);
						command.setOperateId(dynaOperate.getId());
						command.setOrderId(smsReq.getOrderId());
						command.setPayPointId(smsReq.getPayPointId());
						command.setMoContent(new String(s, "utf-8"));
						command.setUpdateDt(new Date());
						command.setSendStatus(BaseContance.INIT_STATUS);
						command.setMoNum(smsport);
						command.setSerialNum(-1);
						command.setProvinceId(baseReqDto.getProvinceId());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}

		return command;
	}

}
