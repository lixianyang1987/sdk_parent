package com.hytx.web.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.NativeWebRequest;

import com.hytx.util.JsonMapper;

@ControllerAdvice
public class BaseController {
	private static Logger logger = LoggerFactory.getLogger("CLIENT_LOG");

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor dateEditor = new CustomDateEditor(df, true);
		// 表示如果命令对象有Date类型的属性，将使用该属性编辑器进行类型转换
		binder.registerCustomEditor(Date.class, dateEditor);
		logger.debug("======初始化日期绑定=========");
	}

	@ExceptionHandler(Exception.class)
	public Map<String, Object> processUnCatchException(
			NativeWebRequest request, Exception e) {
		e.printStackTrace();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("resultCode", "0");
		logger.info("程序错误信息为：{}", e.getMessage());
		logger.info("返回数据为：{}", JsonMapper.toLogJson(map));
		return map; // 返回一个逻辑视图名
	}

}
