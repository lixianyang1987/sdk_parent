package com.hytx.service.xzf;

import com.hytx.model.xzf.XzfFlowLog;
import com.hytx.model.xzf.XzfUser;
import com.hytx.model.xzf.XzfVcode;

public interface IXzfUserService {

	int insertVcode(XzfVcode record);

	boolean validVcode(String mobile, String vcode);

	XzfUser selectByPrimaryKey(String imei);

	int updateByPrimaryKeySelective(XzfUser record);

	int insert(XzfUser record);

	int insertFlowLog(XzfFlowLog record);

	boolean validUserIdCard(String name, String idCard);

	XzfUser selectXzfUserByMobile(String mobile);

	void repayment(String imei, Integer feeValue);

	void thirdPayCallBack(String imei, Integer feeValue);

}
