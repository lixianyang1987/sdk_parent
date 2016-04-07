package com.hytx.web.count;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hytx.service.count.IExportFileService;

@Controller
@RequestMapping("/count/export")
public class ExportFileController {
	private static Logger logger = LoggerFactory
			.getLogger(ExportFileController.class);
	@Autowired
	private IExportFileService exportFileService;

	/*	ie浏览器导出不正常
	 * @RequestMapping(value="exportXls")
		public ResponseEntity<byte[]> exportXls(@RequestParam("rows") String rows,@RequestParam("fields") String fields){
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.setContentDispositionFormData("attachment", "data.xls");
			responseHeaders.setContentType(new MediaType("application", "x-xls", Charset.forName("UTF-8")));
			byte[] content=exportFileService.createXlsFileContent(rows, fields);
			return new ResponseEntity<byte[]>(content, responseHeaders, HttpStatus.CREATED);
		}*/

	@RequestMapping(value = "exportXls")
	public void exportXls(@RequestParam("rows") String rows,
			@RequestParam("fields") String fields, HttpServletResponse response) {
		logger.debug("导出xls文件开始");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition",
				"attachment;filename=data.xls");
		byte[] content = exportFileService.createXlsFileContent(rows, fields);
		try {
			response.getOutputStream().write(content, 0, content.length);
			response.getOutputStream().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.debug("导出xls文件结束");
	}

}
