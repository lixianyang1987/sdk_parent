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
public class WxPayQueryRespDto {
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

	/*用户是否关注公众账号，Y-关注，N-未关注仅在公众账号类型支付有效*/
	@XmlElement(name = "is_subscribe")
	private String isSubscribe;

	/*用户在商户appid下的唯一标识 */
	private String openid;
	/*取值如下：JSAPI，NATIVE，APP，*/
	@XmlElement(name = "trade_type")
	private String tradeType;
	/*交易状态 
	 * SUCCESS—支付成功

	REFUND—转入退款

	NOTPAY—未支付

	CLOSED—已关闭

	REVOKED—已撤销（刷卡支付）

	USERPAYING--用户支付中

	PAYERROR--支付失败(其他原因，如银行返回失败)
	 */
	@XmlElement(name = "trade_state ")
	private String tradeState;
	/*交易状态描述*/
	@XmlElement(name = "trade_state_desc")
	private String tradeStateDesc;
	/*取值如下：JSAPI，NATIVE，APP，*/
	@XmlElement(name = "device_info")
	private String deviceInfo;
	/*银行类型，采用字符串类型的银行标识*/
	@XmlElement(name = "bank_type")
	private String bankType;
	/*订单总金额，单位为分*/
	@XmlElement(name = "total_fee")
	private Integer totalFee;
	/*货币种类*/
	@XmlElement(name = "fee_type")
	private String feeType;
	/*现金支付金额*/
	@XmlElement(name = "cash_fee")
	private Integer cashFee;
	/*货币类型，符合ISO4217标准的三位字母代码，默认人民币：CNY*/
	@XmlElement(name = "cash_fee_type")
	private String cashFeeType;
	/*微信支付订单号*/
	@XmlElement(name = "transaction_id")
	private String transactionId;
	/*商户订单号*/
	@XmlElement(name = "out_trade_no")
	private String orderId;
	/*支付完成时间*/
	@XmlElement(name = "time_end")
	private String timeEnd;
	/*代金券或立减优惠金额*/
	@XmlElement(name = "coupon_fee")
	private Integer couponFee;
	/*代金券或立减优惠使用数量*/
	@XmlElement(name = "coupon_count")
	private Integer couponCount;
	/*商家数据包，原样返回*/
	private String attach;

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
		map.put("out_trade_no", this.orderId);
		map.put("total_fee", this.totalFee);
		map.put("trade_type", this.tradeType);
		map.put("trade_type", this.tradeType);
		map.put("return_code", this.returnCode);
		map.put("err_code", this.errCode);
		map.put("err_code_des", this.errCodeDes);
		map.put("is_subscribe", this.isSubscribe);
		map.put("openid", this.openid);
		map.put("trade_type", this.tradeType);
		map.put("bank_type", this.bankType);
		map.put("total_fee", this.totalFee);
		map.put("fee_type", this.feeType);
		map.put("cash_fee", this.cashFee);
		map.put("cash_fee_type", this.cashFeeType);
		map.put("transaction_id", this.transactionId);
		map.put("time_end", this.timeEnd);
		map.put("attach", this.attach);
		map.put("coupon_fee", this.couponFee);
		map.put("coupon_count", this.couponCount);
		map.put("trade_state", this.tradeState);
		map.put("trade_state_desc", this.tradeStateDesc);

		StringBuilder builder = new StringBuilder(500);
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

	public String getIsSubscribe() {
		return isSubscribe;
	}

	public void setIsSubscribe(String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
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

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public Integer getCashFee() {
		return cashFee;
	}

	public void setCashFee(Integer cashFee) {
		this.cashFee = cashFee;
	}

	public String getCashFeeType() {
		return cashFeeType;
	}

	public void setCashFeeType(String cashFeeType) {
		this.cashFeeType = cashFeeType;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public Integer getCouponFee() {
		return couponFee;
	}

	public void setCouponFee(Integer couponFee) {
		this.couponFee = couponFee;
	}

	public Integer getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(Integer couponCount) {
		this.couponCount = couponCount;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getTradeState() {
		return tradeState;
	}

	public void setTradeState(String tradeState) {
		this.tradeState = tradeState;
	}

	public String getTradeStateDesc() {
		return tradeStateDesc;
	}

	public void setTradeStateDesc(String tradeStateDesc) {
		this.tradeStateDesc = tradeStateDesc;
	}

}
