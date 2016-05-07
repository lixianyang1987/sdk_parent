package com.hytx.util;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

/****
 * 此类用于反序列化json的日期字符串到日期对象 日期字符串格式为yyyy-MM-dd HH:mm:ss或yyyy-MM-dd， 若用到其它格式请修改此类。
 * 
 * @author hzz
 *
 */
public class CustomDateDeserializer extends JsonDeserializer<Date> {
	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		String dateStr = jp.getText();
		try {
			return DateUtils.parseDate(dateStr, "yyyy-MM-dd HH:mm:ss",
					"yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
