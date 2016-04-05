package com.hytx.dto.xzf;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.RandomStringUtils;

import com.hytx.constance.BaseContance;
import com.hytx.constance.XzfConstant;
import com.hytx.util.MD5;

/****
 * 微信支付订单的查询，商户可以通过该接口主动查询订单状态，完成下一步的业务逻辑。
 * 
 * @author houzz
 *
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class WxPayQueryReqDto {
	/*微信分配的公众账号ID（企业号corpid即为此appId）*/
	private String appid;
	/* 微信支付分配的商户号*/
	@XmlElement(name = "mch_id")
	private String mchId;
	/*随机字符串，不长于32位*/
	@XmlElement(name = "nonce_str")
	private String nonceStr;
	/*订单号*/
	@XmlElement(name = "out_trade_no")
	private String orderId;
	private String sign;

	public WxPayQueryReqDto(String orderId) {
		this.appid = XzfConstant.WX_APPID;
		this.mchId = XzfConstant.WX_MCH_ID;
		this.orderId = orderId;
		this.nonceStr = RandomStringUtils.randomAlphabetic(20);
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
		Map<String, Object> map = new TreeMap<String, Object>();
		map.put("appid", this.appid);
		map.put("mch_id", this.mchId);
		map.put("nonce_str", this.nonceStr);
		map.put("out_trade_no", this.orderId);

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

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
}
