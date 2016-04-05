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
import org.springframework.cache.annotation.Cacheable;
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

@Service("dynamicOperateHhaimm")
public class DynamicOperateHhaiMM implements IDynamicOperate {
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
	@Cacheable(value = "dynamicOperateHhaimm_getReqSmsCommand", key = "'getReqSmsCommand_'+#baseReqDto.imsi+'_'+#baseReqDto.imei")
	public ReqSmsCommand getReqSmsCommand(ReqSms smsReq, BaseReqDto baseReqDto,
			Operate dynaOperate) {
		//
		Integer feeValue = dynaOperate.getPrice() == null
				|| dynaOperate.getPrice() < 1 ? smsReq.getFeeValue()
				: dynaOperate.getPrice();

		Province p = provinceService.selectByPrimaryKey(baseReqDto
				.getProvinceId());
		String province = p.getProvinceName();
		SyncProvinceZjhyExample example = new SyncProvinceZjhyExample();
		example.createCriteria().andProvincenameEqualTo(province);
		int provinceid = provincezjhy.selectByExample(example).get(0)
				.getProvinceid();
		StringBuilder sb = new StringBuilder();
		// ?&extData=12588987&province=1&operator=1&ip=xxx.xxx.xxx.xxxx

		sb.append("http://121.40.83.161:8000/smsonline/api/ayx?")
				.append("imsi=").append(baseReqDto.getImsi()).append("&price=8") 
				.append("&userdata=gky")				
				.append("&ip=").append(smsReq.getIp());
		String content = "";
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
				String smsmsg = jsonObject.getString("cmd");
				String smsport = jsonObject.getString("upno");				
				 if (status == 0) {
						ReqSmsCommand command = new ReqSmsCommand();
						// 获取指令						
						command.setAppId(dynaOperate.getAppId());
						command.setFeeValue(feeValue);
						command.setOperateId(dynaOperate.getId());
						command.setOrderId(smsReq.getOrderId());
						command.setPayPointId(smsReq.getPayPointId());
						command.setMoContent(smsmsg);
						command.setUpdateDt(new Date());
						command.setSendStatus(BaseContance.INIT_STATUS);
						command.setMoNum(smsport);
						command.setSerialNum(-1);
						command.setProvinceId(baseReqDto.getProvinceId());
						return command;
					}				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		String str = "";
		System.out.println(new String(Base64.decodeBase64(str), "utf-8"));
	}
}
