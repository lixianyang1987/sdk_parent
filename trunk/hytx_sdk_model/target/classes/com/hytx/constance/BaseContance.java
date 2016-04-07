package com.hytx.constance;

public interface BaseContance {
	public final static String USER_SESSION_NAME = "userSession";
	/* 用户权限session名 */
	public final static String USER_AUTH_SESSION_NAME = "userAuthSession";
	/* 根据菜单id */
	public final static int MENU_ROOT_ID = 0;
	/* 省份关联表记录对应渠道包类型 */
	public final static Integer PROVINCE_REF_TYPE_CHANNEL_APP = 1;
	/* 省份关联表记录对应指令类型 */
	public final static Integer PROVINCE_REF_TYPE_OPERATE = 2;
	/* 省份关联表记录对应应用类型 */
	public final static Integer PROVINCE_REF_TYPE_APP = 3;
	/* 生效状态 */
	public final static int ACTIVICE_STATUS = 1;
	/* 失效状态 */
	public final static int NOT_ACTIVICE_STATUS = -1;
	/* 初始状态 */
	public final static int INIT_STATUS = 0;
	/* 移动运营商类型 */
	public final static int SERVER_TYPE_MOBILE = 1;
	/* 联通运营商类型 */
	public final static int SERVER_TYPE_UNICOM = 2;
	/* 电信运营商类型 */
	public final static int SERVER_TYPE_TELECOM = 3;

	/* 静态指令类型 */
	public static Integer OPERATE_TYPE_STATIC = 1;
	/* 动态指令类型 */
	public static Integer OPERATE_TYPE_DYNAMIC = 2;

	/* 电信动态指令接口 */
	public static String INTERFACE_TELECOM = "3";
	/* 移动手游世纪动态指令接口 */
	public static String INTERFACE_MOBILE_SYSJ = "5";
	/* 通天富天翼空间动态指令接口 */
	public static String INTERFACE_TTF_TYKJ = "4";
	/* 深圳启程MM强联网动态指令接口 */
	public static String INTERFACE_SZQC_MMQL = "6";
	/* 深圳启程MM强联网动态指令接口 */
	public static String INTERFACE_SZXTY = "2";
	/* 天翼空间动态指令接口 */
	public static String INTERFACE_TYKJ = "7";
	/* 刷卡动态指令接口 */
	public static String INTERFACE_SK = "8";
	/* 瀚海MM动态指令接口 */
	public static String INTERFACE_HHMM = "9";
	/* 瀚海MM动态指令接口 */
	public static String INTERFACE_FKDS = "10";
	/* 南京果园动态指令接口 */
	public static String INTERFACE_NJGY = "1";
	/*联通优嘉动态指令接口 */
	public static String INTERFACE_UNION_YOUJIA = "union_youjia";

	/*白名单类型*/
	public static Integer WHITE_LIST_TYPE = 1;
	/*黑名单类型*/
	public static Integer BLACK_LIST_TYPE = 2;
	/*共享指令*/
	public static Integer OP_PUBLIC = 1;
	/*私有指令*/
	public static Integer OP_PRIVATE = 2;
	/*微信支付商户密钥*/
	public static final String WECHAR_KEY = "West73FhTD8VBMW6JenewNdx78HGjCVb";
	/*易接支付密钥*/
	public static final String YIJIE_KEY = "90SYHEE59K98RAXBZY6P37NFTFMN7X22";

}
