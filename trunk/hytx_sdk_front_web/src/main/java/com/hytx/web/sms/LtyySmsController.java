package com.hytx.web.sms;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.HttpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hytx.model.sms.SmsLtyy;
import com.hytx.service.sms.ISmsLtyyService;
import com.hytx.util.HttpClientUtil;
import com.hytx.util.StringUtil;
import com.hytx.web.base.IpUtil;

/***
 * 联通音乐给下游渠道提供的接口
 * 
 * @author houzz
 *
 */
@Controller
@RequestMapping("/sms/ltyy")
public class LtyySmsController {
	private static final String GET_VERIFYCODE_URL = "http://s.smilegames.cn:88/Sms/GetVerifyCode";
	private static final String SEND_VERIFYCODE_URL = "http://s.smilegames.cn:88/Sms/SendVerifyCode";
	private static final String CHANNEL_ID = "c100039";
	private static final String PRODUCT_ID = "p10006";
	private static final String ORDER_ID_PRE = "1111";// 到上游请求验证码里order_id参数前四位固定值
	private static final int VERSION = 200;
	private static final Logger log = LoggerFactory
			.getLogger(LtyySmsController.class);

	@Autowired
	private ISmsLtyyService smsLtyyService;

	/****
	 * 给下游渠道提示的获取短信验证码的接口
	 * 
	 * @return
	 * @author houzz
	 * @date 2015年10月23日
	 */
	@RequestMapping("getVerifyCode")
	@ResponseBody
	public String getVerifyCode(HttpServletRequest request) {
		try {
			log.info("联通音乐下游渠道请求验证码信息为:{}", request.getQueryString());
			final String upOrderId = request.getParameter("order_id");
			if (upOrderId == null || upOrderId.length() != 14) {
				log.info("联通音乐下游渠道请求验证码返回数据:{}",
						"{\"result\":\"illegal_parameters\"}");
				return "{\"result\":\"illegal_parameters\"}";
			}
			final Long id = smsLtyyService.selectSeqId();
			final String orderIdLocal = ORDER_ID_PRE
					+ StringUtil.format(id.toString(), 10);
			final String price = request.getParameter("price");
			final String imsi = request.getParameter("imsi");
			final String imei = request.getParameter("imei");
			final String phone = request.getParameter("phone");
			final String timestamp = request.getParameter("timestamp");
			final String ip = IpUtil.getRealIp(request);

			StringBuilder urlBuild = new StringBuilder(GET_VERIFYCODE_URL);
			urlBuild.append("?order_id=" + orderIdLocal)
					.append("&channel_id=" + CHANNEL_ID)
					.append("&product_id=" + PRODUCT_ID)
					.append("&price=" + price).append("&imsi=" + imsi)
					.append("&imei=" + imei).append("&phone=" + phone)
					.append("&timestamp=" + timestamp)
					.append("&version=" + VERSION);
			String url = urlBuild.toString();
			log.info("请求验证码url为:{}", url);
			final String result = HttpClientUtil.simpleVisitUrl(url);
			Thread t = new Thread() {
				public void run() {
					try {
						Integer channelAppId = 0;
						SmsLtyy smsLtyy = new SmsLtyy();
						smsLtyy.setOrderId(id);
						smsLtyy.setChannelAppId(channelAppId);
						smsLtyy.setImei(imei);
						smsLtyy.setImsi(imsi);
						smsLtyy.setIp(ip);
						smsLtyy.setPhone(Long.parseLong(phone));
						smsLtyy.setPrice(Integer.parseInt(price));
						JSONObject jsObj = JSONObject.fromObject(result);
						smsLtyy.setResult(jsObj.getString("result"));
						smsLtyy.setTimeStamp(timestamp);
						smsLtyy.setUpOrderId(upOrderId);
						smsLtyy.setVersion(VERSION);
						smsLtyyService.insertSmsLtyy(smsLtyy);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			t.start();
			log.info("联通音乐下游渠道请求验证码返回数据:{}", result);
			return result;
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("联通音乐下游渠道请求验证码返回数据:{}", "{\"result\":\"illegal_parameters\"}");
		return "{\"result\":\"illegal_parameters\"}";
	}

	/****
	 * 给下游渠道提示的发送短信验证码的接口
	 * 
	 * @return
	 * @author houzz
	 * @date 2015年10月23日
	 */
	@RequestMapping("sendVerifyCode")
	@ResponseBody
	public String sendVerifyCode(HttpServletRequest request) {
		log.info("联通音乐下游渠道发送验证码信息为:{}", request.getQueryString());
		try {
			String ip = IpUtil.getRealIp(request);
			String upOrderId = request.getParameter("order_id");
			String price = request.getParameter("price");
			String imsi = request.getParameter("imsi");
			String imei = request.getParameter("imei");
			String phone = request.getParameter("phone");
			final String verifyCode = request.getParameter("verify_code");
			String timestamp = request.getParameter("timestamp");
			if (upOrderId == null || upOrderId.length() != 14) {
				log.info("联通音乐下游渠道发送验证码返回数据:{}",
						"{\"result\":\"illegal_parameters\"}");
				return "{\"result\":\"illegal_parameters\"}";
			}
			final SmsLtyy smsLtyy = smsLtyyService.selectByIpAndUpOrderId(ip,
					upOrderId);
			if (smsLtyy != null) {
				String orderIdLocal = "1111"
						+ StringUtil
								.format(smsLtyy.getOrderId().toString(), 10);
				StringBuilder urlBuild = new StringBuilder(SEND_VERIFYCODE_URL);
				urlBuild.append("?order_id=" + orderIdLocal)
						.append("&channel_id=" + CHANNEL_ID)
						.append("&product_id=" + PRODUCT_ID)
						.append("&price=" + price).append("&imsi=" + imsi)
						.append("&imei=" + imei).append("&phone=" + phone)
						.append("&timestamp=" + timestamp)
						.append("&version=" + VERSION)
						.append("&verify_code=" + verifyCode);
				String url = urlBuild.toString();
				log.info("发送验证码url为:{}", url);
				final String result = HttpClientUtil.simpleVisitUrl(url);
				Thread t = new Thread() {
					public void run() {
						try {
							// 更新记录状态
							JSONObject jsObj = JSONObject.fromObject(result);
							SmsLtyy record = new SmsLtyy();
							record.setSendStatus(jsObj.getString("result"));
							record.setVerifyCode(verifyCode);
							record.setOrderId(smsLtyy.getOrderId());
							smsLtyyService.updateSmsLtyy(record);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				};
				t.start();
				log.info("联通音乐下游渠道发送验证码返回数据:{}", result);
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("联通音乐下游渠道发送验证码返回数据:{}", "{\"result\":\"illegal_parameters\"}");
		return "{\"result\":\"illegal_parameters\"}";
	}

	public static void main(String[] args) {
		JSONObject obj = JSONObject
				.fromObject("{\"result\":\"illegal_parameters\"}");
		System.out.println(obj.getString("result"));
	}
}
