package com.hytx.constance;

/***
 * 运营商枚举类
 * 
 * @author houzz
 *
 */
public enum EnumServerType {
	mobile(1), // 移动
	unicom(2), // 联通
	telecom(3);// 电信

	private Integer value;

	private EnumServerType(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return this.value;
	}

	public static boolean isEfficient(int value) {
		EnumServerType[] values = EnumServerType.values();
		for (EnumServerType es : values) {
			if (es.getValue() == value) {
				return true;
			}
		}
		return false;
	}
}
