package com.hytx.web.sync;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.client.SdkInfo;
import com.hytx.service.client.ISdkInfoService;

@Controller
@RequestMapping("/sync")
public class SyncSkdInfoController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");
	@Autowired
	private ISdkInfoService sdkInfoService;

	@RequestMapping(value = "sdkInfo")
	@ResponseBody
	public String sjdySync(HttpServletRequest request) {
		String status = "failure";
		logger.info("sdk信息同步开始，信息为：\n{}", request.getQueryString());
		try {
			String phoneNum = request.getParameter("telephone_num");
			/*sdk发送过来的短信内容，数据格式为：imsi+","+"iccid"+","+imei*/
			String smsTxt = request.getParameter("sms_txt");
			String smsPort = request.getParameter("sms_port");
			smsPort = new String(smsPort.getBytes("iso8859-1"), "UTF-8");
			String date = request.getParameter("date");
			logger.info("获取的参数为phoneNum：{} smsTxt：{} smsPort：{} date：{}",
					phoneNum, smsTxt, smsPort, date);
			if (StringUtils.isBlank(phoneNum)) {
				return "failure";
			}
			if (StringUtils.isBlank(smsTxt)) {
				return "failure";
			}
			String infos[] = smsTxt.split(",");
			if (infos.length != 3) {
				return "failure";
			}
			SdkInfo sdkInfo = sdkInfoService.selectByPrimaryKey(infos[0]);
			if (sdkInfo != null) {
				return "ok";
			}
			sdkInfo = new SdkInfo();
			sdkInfo.setDateTime(date);
			sdkInfo.setImsi(infos[0]);
			sdkInfo.setIccid(infos[1]);
			sdkInfo.setImei(infos[2]);
			sdkInfo.setSmsPort(smsPort);
			sdkInfo.setMobile(Long.parseLong(phoneNum));
			sdkInfoService.insert(sdkInfo);
			status = "ok";
		} catch (Exception e) {
			e.printStackTrace();
			status = "failure";
		}
		logger.info("sdk信息同步状态为：{}", status);
		return status;
	}
}
