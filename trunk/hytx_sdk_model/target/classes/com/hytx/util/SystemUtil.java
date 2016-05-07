package com.hytx.util;

public class SystemUtil {

	public static boolean isWindows(){
		String os = System.getProperty("os.name");  

		if (os != null && os.startsWith("Windows")) {  
			return true;
		}
		return false;

	}
	public static void main(String[] args) {
		System.out.println(isWindows());
		System.out.println(System.getProperty("user.dir"));  

	}

}
