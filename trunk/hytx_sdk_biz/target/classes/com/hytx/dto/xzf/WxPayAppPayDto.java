package com.hytx.dto.xzf;

import org.codehaus.jackson.annotate.JsonProperty;

import com.hytx.constance.BaseContance;
import com.hytx.util.MD5;

public class WxPayAppPayDto {
	private String appid;
	private String noncestr;
	@JsonProperty("package")
	private String packageName;
	private String partnerid;
	private String prepayid;
	private String sign;
	private String timestamp;

	public WxPayAppPayDto() {
	}

	public WxPayAppPayDto(WxPayRespDto wxPayRespDto) {
		this.appid = wxPayRespDto.getAppid();
		this.noncestr = wxPayRespDto.getNonceStr();
		this.packageName = "Sign=WXPay";
		this.partnerid = wxPayRespDto.getMchId();
		this.prepayid = wxPayRespDto.getPrepayId();
		this.timestamp = System.currentTimeMillis() / 1000 + "";
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
		builder.append("&noncestr=");
		builder.append(this.noncestr);
		builder.append("&package=");
		builder.append(this.packageName);
		builder.append("&partnerid=");
		builder.append(this.partnerid);
		builder.append("&prepayid=");
		builder.append(this.prepayid);
		builder.append("&timestamp=");
		builder.append(this.timestamp);
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

	public String getPartnerid() {
		return partnerid;
	}

	public void setPartnerid(String partnerid) {
		this.partnerid = partnerid;
	}

	public String getPrepayid() {
		return prepayid;
	}

	public void setPrepayid(String prepayid) {
		this.prepayid = prepayid;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getNoncestr() {
		return noncestr;
	}

	public void setNoncestr(String noncestr) {
		this.noncestr = noncestr;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
