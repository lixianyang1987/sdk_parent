package com.hytx.service.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hytx.constance.BaseContance;
import com.hytx.dto.client.BaseReqDto;
import com.hytx.model.baseConf.Operate;
import com.hytx.model.client.ReqSms;
import com.hytx.model.client.ReqSmsCommand;

/****
 * 根据动态指令获取指令内容
 * 
 * @author houzz
 */
@Service("dynamicOperateServiceImpl")
public class DynamicOperateServiceImpl implements IDynamicOperateService {
	@Autowired
	@Qualifier("dynamicOperateMobileSysj")
	private IDynamicOperate dynamicOperateMobileSysj;
	@Autowired
	@Qualifier("dynamicOperateTelecom")
	private IDynamicOperate dynamicOperateTelecom;
	@Autowired
	@Qualifier("dynamicOperateTtfTykj")
	private IDynamicOperate dynamicOperateTtfTykj;
	@Autowired
	@Qualifier("dynamicOperateSzqcMMQl")
	private IDynamicOperate dynamicOperateSzqcMMQl;
	@Autowired
	@Qualifier("dynamicOperateSzxty")
	private IDynamicOperate dynamicOperateSzxty;
	@Autowired
	@Qualifier("dynamicOperateTykj")
	private IDynamicOperate dynamicOperateTykj;
	@Autowired
	@Qualifier("dynamicOperateSk")
	private IDynamicOperate dynamicOperateSk;
	@Autowired
	@Qualifier("dynamicOperateGymm")
	private IDynamicOperate dynamicOperateGymm;
	@Autowired
	@Qualifier("dynamicOperateFkdsmm")
	private IDynamicOperate dynamicOperateFkdsmm;
	@Autowired
	@Qualifier("dynamicOperateHhaimm")
	private IDynamicOperate dynamicOperateHhaimm;
	@Autowired
	@Qualifier("dynamicOperateUnionYouJia")
	private IDynamicOperate dynamicOperateUnionYouJia;

	private Map<String, IDynamicOperate> dynamicOpMap;

	public synchronized void initMap() {
		if (dynamicOpMap == null) {
			dynamicOpMap = new HashMap<String, IDynamicOperate>();
			dynamicOpMap.put(BaseContance.INTERFACE_TELECOM,
					dynamicOperateTelecom);
			dynamicOpMap.put(BaseContance.INTERFACE_MOBILE_SYSJ,
					dynamicOperateMobileSysj);// 移动手游世纪动态指令接口
			dynamicOpMap.put(BaseContance.INTERFACE_TTF_TYKJ,
					dynamicOperateTtfTykj);// 通天富天翼空间
			dynamicOpMap.put(BaseContance.INTERFACE_SZQC_MMQL,
					dynamicOperateSzqcMMQl);// 深圳启程MM 强联网
			dynamicOpMap.put(BaseContance.INTERFACE_SZXTY, dynamicOperateSzxty);// 深圳星天元动态指令接口
			dynamicOpMap.put(BaseContance.INTERFACE_SK, dynamicOperateSk);// 刷卡动态指令接口
			dynamicOpMap.put(BaseContance.INTERFACE_HHMM, dynamicOperateHhaimm);// 瀚海MM动态指令接口
			dynamicOpMap.put(BaseContance.INTERFACE_FKDS, dynamicOperateFkdsmm);// 疯狂的士动态指令接口
			dynamicOpMap.put(BaseContance.INTERFACE_NJGY, dynamicOperateGymm);// 南京果园MM动态指令接口
			dynamicOpMap.put(BaseContance.INTERFACE_UNION_YOUJIA,
					dynamicOperateUnionYouJia);// 联通优嘉动态指令接口

		}
	}

	@Override
	public ReqSmsCommand changeOperateToCommand(ReqSms smsReq,
			BaseReqDto baseReqDto, Operate dynaOperate) {
		String mark = dynaOperate.getOpCode();
		if (mark == null) {
			return null;
		}
		initMap();
		IDynamicOperate dynamicOperateService = dynamicOpMap.get(dynaOperate
				.getOpCode());
		if (dynamicOperateService != null) {
			return dynamicOperateService.getReqSmsCommand(smsReq, baseReqDto,
					dynaOperate);
		}
		return null;
	}

}
