package com.hytx.service.count;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.springframework.stereotype.Service;

@Service
public class ExportFileServiceImpl implements IExportFileService {

	public byte[] createXlsFileContent(String rows,String fileds){
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		try{
			String filedsArr[]=fileds.split(",");
			JSONArray rowsJson= JSONArray.fromObject(rows);
			int len=rowsJson.size();
			int rownum;
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet s = wb.createSheet();
			HSSFCellStyle cs = wb.createCellStyle();
			HSSFCellStyle cs2 = wb.createCellStyle();
			
			HSSFFont f = wb.createFont();
			HSSFFont f2 = wb.createFont();
			f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			f2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
			cs.setFont(f);
			cs.setAlignment(CellStyle.ALIGN_CENTER);
			cs.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			cs2.setFont(f2);
			cs2.setAlignment(CellStyle.ALIGN_CENTER);
			cs2.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			HSSFRow rh = s.createRow(0);
			rh.setHeightInPoints(20);
			for (int cellnum = 0; cellnum < filedsArr.length; cellnum++) {
				HSSFCell c = rh.createCell(cellnum);
				c.setCellValue(filedsArr[cellnum]);
				c.setCellStyle(cs);
				s.setColumnWidth(cellnum , (int) (20 * 8 / 0.05));
			}
			for (rownum = 1; rownum <= len; rownum++) {
				HSSFRow r = s.createRow(rownum);
				r.setHeightInPoints(18);
				JSONObject rowObj = rowsJson.getJSONObject(rownum-1);
				for (int cellnum = 0; cellnum < filedsArr.length; cellnum++) {
					HSSFCell c = r.createCell(cellnum);
					c.setCellValue(rowObj.getString(filedsArr[cellnum]));
					c.setCellStyle(cs2);
				}
			}
			wb.write(out);
		}catch(Exception e){
			e.printStackTrace();
		}
		return out.toByteArray();
	}
	
	public static void main(String[] args) {
		ExportFileServiceImpl efs=new ExportFileServiceImpl();
		JSONArray arr = JSONArray.fromObject("[]");
		System.out.println(arr.size());
	}
}
