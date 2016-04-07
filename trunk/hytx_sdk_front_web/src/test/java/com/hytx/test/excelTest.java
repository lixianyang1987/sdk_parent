package com.hytx.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hytx.model.syncEx.SyncByRetained;
import com.hytx.service.syncEx.SyncByRetainedServiceImpl;
import com.hytx.util.ExcelUtil;

public class excelTest {

	public static void main(String[] args) throws Exception {

	List<SyncByRetained> list=ExcelUtil.readByRetained("e://m_201602_留存.xls");
	SyncByRetainedServiceImpl s =new SyncByRetainedServiceImpl();
	s.AddSyncByRetained(list);
	}
}
