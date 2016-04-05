package com.hytx.constance;

public abstract class XzfConstant {
	/*微信公众号id*/
	public static final String WX_APPID = "wxb6c67eefdb43e663";
	/*微信支付分配的商户号*/
	public static final String WX_MCH_ID = "1301099501";
	/*本项目服务器ip*/
	public static final String DX_SERVER_IP = "115.29.201.88";
	/*接收微信支付异步通知回调地址*/
	public static final String WX_NOTIFY_URL = "http://115.29.201.88/xzf/wxpay/payResult";
	/*微信支付订单的查询url*/
	public static final String WX_ORDER_QUERY_URL = "https://api.mch.weixin.qq.com/pay/orderquery";
	public static final String WX_UNION_PAY_URL = "";

}
