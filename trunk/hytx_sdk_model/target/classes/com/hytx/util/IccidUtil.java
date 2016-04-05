package com.hytx.util;

import java.util.HashMap;
import java.util.Map;

public class IccidUtil {
	private static Map<String, String> mobileMap = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("01", "北京");
			put("02", "天津");
			put("03", "河北");
			put("04", "山西");
			put("05", "内蒙古");
			put("06", "辽宁");
			put("07", "吉林");
			put("08", "黑龙江");
			put("09", "上海");
			put("10", "江苏");
			put("11", "浙江");
			put("12", "安徽");
			put("13", "福建");
			put("14", "江西");
			put("15", "山东");
			put("16", "河南");
			put("17", "湖北");
			put("18", "湖南");
			put("19", "广东");
			put("20", "广西");
			put("21", "海南");
			put("22", "四川");
			put("23", "贵州");
			put("24", "云南");
			put("25", "西藏");
			put("26", "陕西");
			put("27", "甘肃");
			put("28", "青海");
			put("29", "宁夏");
			put("30", "新疆");
			put("31", "重庆");
		}
	};
	private static Map<String, String> unicomMap = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("10", "内蒙古");
			put("11", "北京");
			put("13", "天津");
			put("17", "山东");
			put("18", "河北");
			put("19", "山西");
			put("30", "安徽");
			put("31", "上海");
			put("34", "江苏");
			put("36", "浙江");
			put("38", "福建");
			put("50", "海南");
			put("51", "广东");
			put("59", "广西");
			put("70", "青海");
			put("71", "湖北");
			put("74", "湖南");
			put("75", "江西");
			put("76", "河南");
			put("79", "西藏");
			put("81", "四川");
			put("83", "重庆");
			put("84", "陕西");
			put("85", "贵州");
			put("86", "云南");
			put("87", "甘肃");
			put("88", "宁夏");
			put("89", "新疆");
			put("90", "吉林");
			put("91", "辽宁");
			put("97", "黑龙江");
		}
	};
	private static Map<String, String> telcomMap = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("010", "北京");
			put("022", "天津 ");
			put("021", "上海");
			put("023", "重庆");
			put("024", "辽宁");
			put("331", "河北");
			put("351", "山西");
			put("471", "内蒙古");
			put("451", "黑龙江");
			put("971", "青海");
			put("028", "四川");
			put("851", "贵州");
			put("871", "云南");
			put("029", "陕西");
			put("931", "甘肃");
			put("951", "宁夏");
			put("991", "新疆");
			put("891", "西藏");
			put("898", "海南");
			put("025", "江苏");
			put("571", "浙江");
			put("551", "安徽");
			put("591", "福建");
			put("791", "江西");
			put("531", "山东");
			put("371", "河南");
			put("027", "湖北");
			put("731", "湖南");
			put("020", "广东");
			put("771", "广西");
			put("431", "吉林");
		}
	};

	/***
	 * 根据移动iccid获取省份名称
	 * 
	 * @param iccid
	 * @return
	 * @author houzz
	 * @date 2015年7月6日
	 */
	private static String getMobileProvince(String iccid) {
		if (iccid == null || iccid.length() != 20) {
			return null;
		}
		String ss = iccid.substring(8, 10);
		return mobileMap.get(ss);
	}

	/***
	 * 根据联通iccid获取省份名称
	 * 
	 * @param iccid
	 * @return
	 * @author houzz
	 * @date 2015年7月6日
	 */
	private static String getUnicomProvince(String iccid) {
		if (iccid == null || iccid.length() != 20) {
			return null;
		}
		String ss = iccid.substring(9, 11);
		System.out.println(ss);
		return unicomMap.get(ss);
	}

	/***
	 * 根据电信iccid获取省份名称
	 * 
	 * @param iccid
	 * @return
	 * @author houzz
	 * @date 2015年7月6日
	 */
	private static String getTelcomProvince(String iccid) {
		if (iccid == null || iccid.length() != 20) {
			return null;
		}
		String ss = iccid.substring(9, 12);
		return telcomMap.get(ss);
	}

	/***
	 * 根据iccid获取省份名称
	 * 
	 * @param iccid
	 * @return
	 * @author houzz
	 * @date 2015年7月6日
	 */
	public static String getProvinceNameByIccid(String iccid) {
		if (iccid == null || iccid.length() != 20) {
			return null;
		}
		String st = iccid.substring(4, 6);
		System.out.println(st);
		if (st.equals("01") || st.equals("06")) {
			/*联通类型*/
			return getUnicomProvince(iccid);
		} else if (st.equals("03") || st.equals("05") || st.equals("11")) {
			/*电信类型*/
			return getTelcomProvince(iccid);
		} else {
			/* 移动类型,默认设置成移动类型,iccid以898600；898602开头 */
			return getMobileProvince(iccid);
		}
	}

	public static void main(String[] args) {
		System.out
				.println(getProvinceNameByIccid("89860114221100259379") == null);
	}

}
