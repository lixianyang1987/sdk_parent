package com.hytx.constance;

public interface ReqSmsCodeConstance {
	public static final Integer SUCCESS = 1000;// 成功
	public static final Integer PRO_ERROR = 0;// 服务器程序错误
	public static final Integer FORMAT_ERROR = 101;// 参数格式不符合规范
	public static final Integer NO_CHANNEL_APP_ERROR = 201;// 服务端不存在请求的渠道包
	public static final Integer SIGN_ERROR = 202;// 签名不正确
	public static final Integer CHANNEL_APP_FEE_ERROR = 301;// 渠道包未开启计费
	public static final Integer CHANNEL_APP_DAY_LIMIT_ERROR = 302;// 渠道包超出日限
	public static final Integer USER_DAY_LIMIT_ERROR = 303;// 用户日限额已满
	public static final Integer USER_MONTH_LIMIT_ERROR = 304;// 用户月限额已满
	public static final Integer NO_COMMAND_ERROR = 401;// 不存在满足计费的指令
	public static final Integer BLACK_ERROR = 501;// 黑名单
	public static final Integer HAS_ORDERD = 600;// 已计费
}
