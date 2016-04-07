package com.hytx.dto.xzf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.RandomStringUtils;

import com.hytx.constance.BaseContance;
import com.hytx.constance.XzfConstant;
import com.hytx.util.MD5;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WxPayReqDto {

	/*微信分配的公众账号ID（企业号corpid即为此appId）*/
	private String appid;
	/* 商品描述*/
	private String body;
	/* 微信支付分配的商户号*/
	@XmlElement(name = "mch_id")
	private String mchId;
	/*随机字符串，不长于32位*/
	@XmlElement(name = "nonce_str")
	private String nonceStr;
	/*接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。*/
	@XmlElement(name = "notify_url")
	private String notifyUrl;
	/*订单号*/
	@XmlElement(name = "out_trade_no")
	private String orderId;
	/*APP和网页支付提交用户端ip*/
	@XmlElement(name = "spbill_create_ip")
	private String spBillCreateIp;
	/*订单总金额，单位为分*/
	@XmlElement(name = "total_fee")
	private String totalFee;
	/*取值如下：JSAPI，NATIVE，APP，*/
	@XmlElement(name = "trade_type")
	private String tradeType;
	/**/
	private String sign;

	public WxPayReqDto() {
	}

	public WxPayReqDto(String totalFee, String orderId, String body) {
		this.appid = XzfConstant.WX_APPID;
		this.mchId = XzfConstant.WX_MCH_ID;
		this.notifyUrl = XzfConstant.WX_NOTIFY_URL;
		this.tradeType = "APP";
		this.spBillCreateIp = XzfConstant.DX_SERVER_IP;
		this.totalFee = totalFee;
		this.orderId = orderId;
		this.nonceStr = RandomStringUtils.randomAlphabetic(20);
		this.body = body;
		this.sign = caculateSign(BaseContance.WECHAR_KEY);
	}

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
		StringBuilder builder = new StringBuilder();
		builder.append("&appid=");
		builder.append(this.appid);
		builder.append("&body=");
		builder.append(this.body);
		builder.append("&mch_id=");
		builder.append(this.mchId);
		builder.append("&nonce_str=");
		builder.append(this.nonceStr);
		builder.append("&notify_url=");
		builder.append(this.notifyUrl);
		builder.append("&out_trade_no=");
		builder.append(orderId);
		builder.append("&spbill_create_ip");
		builder.append(this.spBillCreateIp);
		builder.append("&total_fee=");
		builder.append(this.totalFee);
		builder.append("&trade_type=");
		builder.append(this.tradeType);
		builder.append("&key=");
		builder.append(key);
		return MD5.getMD5(builder.toString()).toUpperCase();
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

	public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getSpBillCreateIp() {
		return spBillCreateIp;
	}

	public void setSpBillCreateIp(String spBillCreateIp) {
		this.spBillCreateIp = spBillCreateIp;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
