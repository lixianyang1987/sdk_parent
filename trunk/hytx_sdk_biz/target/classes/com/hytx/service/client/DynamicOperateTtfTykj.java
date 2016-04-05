package com.hytx.service.client;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hytx.constance.BaseContance;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;
import com.hytx.model.sync.SyncTtf;
import com.hytx.service.sync.ISyncTtfReqService;
import com.hytx.util.StringUtil;

@Service("dynamicOperateTtfTykj")
public class DynamicOperateTtfTykj implements IDynamicOperate {
	private Logger logger = LoggerFactory.getLogger("CLIENT_LOG");
	@Autowired
	private ISyncTtfReqService syncTtfReqService;
	@Autowired
	private IReqSmsService reqSmsService;

	@Override
	public ReqSmsCommand getReqSmsCommand(ReqSms smsReq, BaseReqDto baseReqDto,
			Operate dynaOperate) {
		Integer feeValue = dynaOperate.getPrice() == null
				|| dynaOperate.getPrice() < 1 ? smsReq.getFeeValue()
				: dynaOperate.getPrice();
		// TODO Auto-generated method stub
		SyncTtf syncttf = new SyncTtf();
		syncttf.setCpid(1172);
		syncttf.setAppid(Long.parseLong("117200001"));
		syncttf.setOpid(Short.parseShort("3"));
		syncttf.setImsi(Long.parseLong(smsReq.getImsi()));
		syncttf.setFee(feeValue.shortValue());
		Integer serialNum = reqSmsService.getNextSerialNum();
		syncttf.setExdata(StringUtil.format(serialNum + "", 7));
		syncttf.setChannelid("");
		String moContent = syncTtfReqService.syncTtfreq(syncttf);
		if (StringUtils.isEmpty(moContent)) {
			return null;
		}
		ReqSmsCommand command = new ReqSmsCommand();
		command.setAppId(dynaOperate.getAppId());
		command.setFeeValue(feeValue);
		command.setOperateId(dynaOperate.getId());
		command.setOrderId(smsReq.getOrderId());
		command.setPayPointId(smsReq.getPayPointId());
		command.setMoContent(moContent);
		command.setUpdateDt(new Date());
		command.setSendStatus(BaseContance.INIT_STATUS);
		command.setMoNum(dynaOperate.getFeeCode());
		command.setSerialNum(serialNum);
		command.setProvinceId(baseReqDto.getProvinceId());
		return command;
	}

}
