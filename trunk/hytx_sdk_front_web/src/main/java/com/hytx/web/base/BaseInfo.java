package com.hytx.web.base;

public class BaseInfo {
	public final static int LOG_TYPE_XZF = 1;// 信支付
	public final static int LOG_TYPE_WX = 2;// 微信
	public final static int LOG_TYPE_ZFB = 3;// 支付宝

	public final static String COUNT_ERROR_CACHE_NAME = "countErrorCacheName";// 统计错误次数缓存
	public final static String XXF_SESSION_CACHE_NAME = "xzfSessionCache";// 存储信支付session缓存
	public final static long GET_VCODE_LOCK_TIME = 60 * 60;// 获取验证码错误次数超限锁定1个小时
	public final static long MODIFY_PWD_LOCK_TIME = 60 * 60;// 修改密码错误次数超限锁定1个小时
	public final static long LOGIN_LOCK_TIME = 20;// 60 * 60;//
													// 登录错误次数超限锁定1个小时

	public enum XZF_STEP {
		CREATEBILL(1), GETVCODE(2), VALIDVCODE(3), INPUTNAME(4), VALIDNAME(5), WECHATCARE(
				6);
		private int value;

		public int getValue() {
			return this.value;
		}

		XZF_STEP(int value) {
			this.value = value;
		}

	}

}
