package com.hytx.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.hytx.cache.MyAspect;






public class Getkey {
	public static String getChannelKey(String cod){
		File f = new File(MyAspect.class.getResource("/channelkeys.properties").getFile());
		Properties pr = new Properties();
		InputStream ins;
		try {
			ins = new FileInputStream(f.getPath());
			try {
				pr.load(ins);
			return	pr.getProperty(cod);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
