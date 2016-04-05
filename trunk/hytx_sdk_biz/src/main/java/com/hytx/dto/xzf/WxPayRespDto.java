package com.hytx.dto.xzf;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.hytx.constance.BaseContance;
import com.hytx.util.MD5;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WxPayRespDto {
	/*微信分配的公众账号ID（企业号corpid即为此appId）*/
	private String appid;
	/* 微信支付分配的商户号*/
	@XmlElement(name = "mch_id")
	private String mchId;
	/*随机字符串，不长于32位*/
	@XmlElement(name = "nonce_str")
	private String nonceStr;
	/*SUCCESS/FAIL */
	@XmlElement(name = "return_code")
	private String returnCode;
	/*返回信息，如非空，为错误原因 */
	@XmlElement(name = "return_msg")
	private String returnMsg;

	/*业务结果，SUCCESS/FAIL */
	@XmlElement(name = "result_code")
	private String resultCode;
	/*错误代码 */
	@XmlElement(name = "err_code")
	private String errCode;
	/*错误代码描述 */
	@XmlElement(name = "err_code_des")
	private String errCodeDes;
	/*取值如下：JSAPI，NATIVE，APP，*/
	@XmlElement(name = "trade_type")
	private String tradeType;
	/*取值如下：JSAPI，NATIVE，APP，*/
	@XmlElement(name = "device_info")
	private String deviceInfo;
	/*预支付交易会话标识*/
	@XmlElement(name = "prepay_id")
	private String prepayId;
	/*二维码链接*/
	@XmlElement(name = "code_url")
	private String codeUrl;

	private String sign;

	/****
	 * 
	 * 签名算法 签名生成的通用步骤如下：
	 * 
	 * 第一步，设所有发送或者接收到的数据为集合M，将集合M内非空参数值的参数按照参数名ASCII码从小到大排序（字典序），使用URL键值对的格式（
	 * 即key1=value1&key2=value2…）拼接成字符串stringA。
	 * 
	 * 特别注意以下重要规则：
	 * 
	 * ◆ 参数名ASCII码从小到大排序（字典序）； ◆ 如果参数的值为空不参与签名； ◆ 参数名区分大小写； ◆
	 * 验证调用返回或微信主动通知签名时，传送的sign参数不参与签名，将生成的签名与该sign值作校验。 ◆
	 * 微信接口可能增加字段，验证签名时必须支持增加的扩展字段
	 * 
	 * 第二步，在stringA最后拼接上key得到stringSignTemp字符串，并对stringSignTemp进行MD5运算，
	 * 再将得到的字符串所有字符转换为大写，得到sign值signValue。
	 * 
	 * @param key
	 * @return
	 * @author houzz
	 * @date 2016年1月5日
	 */
	public String caculateSign(String key) {
		Map<String, Object> map = new TreeMap<String, Object>();
		map.put("appid", this.appid);
		map.put("mch_id", this.mchId);
		map.put("nonce_str", this.nonceStr);
		map.put("trade_type", this.tradeType);
		map.put("trade_type", this.tradeType);
		map.put("return_code", this.returnCode);
		map.put("err_code", this.errCode);
		map.put("err_code_des", this.errCodeDes);
		map.put("trade_type", this.tradeType);
		map.put("prepay_id", this.prepayId);
		map.put("code_url", this.codeUrl);

		StringBuilder builder = new StringBuilder(300);
		Object value = null;
		for (Entry<String, Object> e : map.entrySet()) {
			value = e.getValue();
			if (value == null) {
				continue;
			}
			if (builder.length() > 0) {
				builder.append("&");
			}
			builder.append(e.getKey()).append("=").append(value.toString());
		}
		builder.append("&key=");
		builder.append(key);
		return MD5.getMD5(builder.toString()).toUpperCase();
	}

	/***
	 * 参数校验
	 * 
	 * @return
	 * @author houzz
	 * @date 2016年1月6日
	 */
	public boolean valid() {
		if (this.sign == null) {
			return true;
		}
		String str = this.caculateSign(BaseContance.WECHAR_KEY);
		return sign.equals(str);
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMchId() {
		return mchId;
	}

	public void setMchId(String mchId) {
		this.mchId = mchId;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrCodeDes() {
		return errCodeDes;
	}

	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getPrepayId() {
		return prepayId;
	}

	public void setPrepayId(String prepayId) {
		this.prepayId = prepayId;
	}

	public String getCodeUrl() {
		return codeUrl;
	}

	public void setCodeUrl(String codeUrl) {
		this.codeUrl = codeUrl;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
