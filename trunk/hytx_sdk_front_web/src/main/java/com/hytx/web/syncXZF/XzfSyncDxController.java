package com.hytx.web.syncXZF;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;


import net.sf.json.JSONObject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import com.hytx.model.syncXzf.XzfSyncDx;

import com.hytx.service.syncXzf.ISyncXzfDxService;

import com.hytx.web.client.BaseReqController;

/*****
 * 此类用于sdk客户端请求短信指令及同步指令发送状态
 * 
 * @author houzz
 *
 */
@Controller
@RequestMapping("/sync/xzf")
public class XzfSyncDxController extends BaseReqController {
	private static final Logger logger = LoggerFactory.getLogger("CLIENT_LOG");

	@Autowired
	private ISyncXzfDxService syncXzfDxService;

	/*****
	 * 信支付接口
	 * 
	 * @param smsReq
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "reqxzfdx", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String XzfSyncDxreq(
			 @RequestBody String smsReq, HttpServletRequest request) {
		logger.info("短串请求返回数据为：{}",smsReq);
		try{	
		JSONObject jsonObject = JSONObject.fromObject(smsReq);
		String cpparam = jsonObject.getString("cpparam") != null ? jsonObject
				.getString("cpparam") : "";
		String cpfee = jsonObject.getString("cpfee") != null ? jsonObject
				.getString("cpfee") : "";
		String statu = jsonObject.getString("status") != null ? jsonObject
				.getString("status") : "";
				
				XzfSyncDx xzfSyncDx = new XzfSyncDx();
				xzfSyncDx.setUuid(UUID.randomUUID().toString());
				xzfSyncDx.setCpfee(cpfee);
				xzfSyncDx.setCpparam(cpparam.substring(4));
				if(statu.equals("0")){
					statu="DELIVRD";
				}
				xzfSyncDx.setStatus(statu);
				syncXzfDxService.addSyncXzf(xzfSyncDx);

	
		}catch (Exception exception){
			return "1";
		}

		return "0";
	}

}
