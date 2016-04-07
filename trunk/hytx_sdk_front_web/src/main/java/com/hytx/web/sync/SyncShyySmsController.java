package com.hytx.web.sync;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sync")
public class SyncShyySmsController {
	Logger logger = LoggerFactory.getLogger("SYNC_LOG");

	/****
	 * 上海幽宇订单同步接口,包括移动小额支付 *
	 * 
	 * @param request
	 * @return
	 * @author lxy
	 * @date 2015年8月31日
	 */
	@RequestMapping(value = "shyysms")
	@ResponseBody
	public String shyySync(HttpServletRequest request) {
		String status = "failure";
		logger.info("上海幽宇发送验证码开始，订单信息为：\n{}", request.getQueryString());

		String verifycode = request.getParameter("verifycode");
		String imsi = request.getParameter("imsi");
		try {
			if (verifycode != "" && verifycode != null && imsi != ""
					&& imsi != null) {
				StringBuilder sb = new StringBuilder();
				sb.append("&verifycode=").append(verifycode).append("&imsi=")
						.append(imsi);
				String url = "http://113.11.195.115:8012/sms/receivesms.aspx?servicetype=3"
						+ sb.toString();
				HttpClient client = new HttpClient();
				client.getParams().setContentCharset("UTF-8");
				GetMethod method = new GetMethod(url);
				client.executeMethod(method);
				System.out.println(method.getStatusCode());
				method.getResponseBodyAsString();
				status = "ok";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("上海幽宇发送验证码状态为：{}", status);
		return status;
	}
}
