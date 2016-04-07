package com.hytx.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hytx.model.syncEx.SyncByRetained;
import com.hytx.model.syncEx.TActivationVolume;

public class ExcelUtil {
	private static InputStream is = null;
	private static Workbook wb = null;

	public static List<SyncByRetained> readByRetained(String uri) {
		List<SyncByRetained> byRetainedList = new ArrayList<SyncByRetained>(); 
		try {
			is = new FileInputStream(new File(uri));
			if (is != null) {
				// 根据输入流创建Workbook对象
				wb = new XSSFWorkbook(is);
			}

		} catch (Exception e) {
			try {
				is=new FileInputStream(new File(uri));
				if (is != null) {
					// 根据输入流创建Workbook对象
					wb = new HSSFWorkbook(is);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}
		}
		if (wb != null) {
			// get到Sheet对象
			Sheet sheet = wb.getSheetAt(0);
			int i = 0;
			// 这个必须用接口
			for (Row row : sheet) {
				SyncByRetained byRetained = new SyncByRetained();
				if (i == 1) {
					int j = 0;
					for (Cell cell : row) {
						// cell.getCellType是获得cell里面保存的值的type
						// 如Cell.CELL_TYPE_STRING
						String str = "";
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_BOOLEAN:
							// 得到Boolean对象的方法
							str = cell.getBooleanCellValue() + " ";
							break;
						case Cell.CELL_TYPE_NUMERIC:
							// 先看是否是日期格式
							if (DateUtil.isCellDateFormatted(cell)) {
								// 读取日期格式
								str = cell.getDateCellValue() + " ";
							} else {
								// 读取数字
								str = (int) cell.getNumericCellValue() + " ";
							}
							break;
						case Cell.CELL_TYPE_FORMULA:
							// 读取公式
							str = cell.getCellFormula() + " ";
							break;
						case Cell.CELL_TYPE_STRING:
							// 读取String
							str = cell.getRichStringCellValue().toString()
									+ " ";
							break;
						}
						str =str.trim();
						switch(j){
						case 1:
							byRetained.setLinkid(str);
							break;
						case 2:
							byRetained.setPayFee(Integer.parseInt(str));
							break;
						case 5:
							byRetained.setMobile(str);
							break;
						case 6:
							byRetained.setMsg(str);
							break;
						case 7:
							byRetained.setPort(str);
							break;
						case 8:
							byRetained.setOrderTime(str);
							break;
						}						
						j++;
					}
					System.out.println(byRetained);
					byRetainedList.add(byRetained);
				}
				if (i == 0) {
					i = 1;
				}
			}
		}
		System.out.println(byRetainedList.size());	
		return byRetainedList;
	}
	public static List<TActivationVolume> readActivationVolume(String uri) {
		List<TActivationVolume> activationVolumeList = new ArrayList<TActivationVolume>(); 
		try {
			is = new FileInputStream(new File(uri));
			if (is != null) {
				// 根据输入流创建Workbook对象
				wb = new XSSFWorkbook(is);
			}
			
		} catch (Exception e) {
			try {
				is=new FileInputStream(new File(uri));
				if (is != null) {
					// 根据输入流创建Workbook对象
					wb = new HSSFWorkbook(is);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}
		}
		if (wb != null) {
			// get到Sheet对象
			Sheet sheet = wb.getSheetAt(0);
			int i = 0;
			// 这个必须用接口
			for (Row row : sheet) {
				TActivationVolume byRetained = new TActivationVolume();
				if (i == 1) {
					int j = 0;
					for (Cell cell : row) {
						// cell.getCellType是获得cell里面保存的值的type
						// 如Cell.CELL_TYPE_STRING
						String str = "";
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_BOOLEAN:
							// 得到Boolean对象的方法
							str = cell.getBooleanCellValue() + " ";
							break;
						case Cell.CELL_TYPE_NUMERIC:
							// 先看是否是日期格式
							if (DateUtil.isCellDateFormatted(cell)) {
								// 读取日期格式
								str = cell.getDateCellValue() + " ";
							} else {
								// 读取数字
								str = (int) cell.getNumericCellValue() + " ";
							}
							break;
						case Cell.CELL_TYPE_FORMULA:
							// 读取公式
							str = cell.getCellFormula() + " ";
							break;
						case Cell.CELL_TYPE_STRING:
							// 读取String
							str = cell.getRichStringCellValue().toString()
							+ " ";
							break;
						}
						str =str.trim();
						switch(j){
						case 1:
							SimpleDateFormat dateFormat = new SimpleDateFormat(
									"yyyy-MM-dd");
							
							try {
								byRetained.setDaytime(dateFormat.parse(str));
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							break;
						case 2:
							byRetained.setCooperationMode(str);
							break;
						case 3:
							byRetained.setChannelName(str);
							break;
						case 4:
							byRetained.setAppName(str);
							break;
						case 5:
							byRetained.setPrice(Integer.parseInt(str));
							break;
						case 6:
							byRetained.setTheActivationNums(Integer.parseInt(str));;
							break;
						}						
						j++;
					}
					System.out.println(byRetained);
					activationVolumeList.add(byRetained);
				}
				if (i == 0) {
					i = 1;
				}
			}
		}
		return activationVolumeList;
	}
}
