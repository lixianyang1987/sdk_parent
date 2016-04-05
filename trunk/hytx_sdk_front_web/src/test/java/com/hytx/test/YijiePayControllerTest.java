package com.hytx.test;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.hytx.Json.JsonXzfBillBase;
import com.hytx.util.JsonMapper;

public class YijiePayControllerTest extends AbstractContextControllerTests {

	@Test
	public void testYijiePay() throws Exception {
		JsonXzfBillBase jsonXzfBillBase = new JsonXzfBillBase();
		jsonXzfBillBase.setChannelAppKey("sdfsdfs");
		// jsonXzfBillBase.setFeeType(1);
		// jsonXzfBillBase.setFeeValue(100);
		jsonXzfBillBase.setOrderId("sfsdfsdfsdfsdf");
		jsonXzfBillBase.setOpType(1);
		jsonXzfBillBase.setSdkVersion("1.0");
		jsonXzfBillBase.setSign(jsonXzfBillBase.getColculateSign("464654546"));
		String content = JsonMapper.toNonNullJson(jsonXzfBillBase);
		String url = "/xzf/yijie/pay";
		mockMvc.perform(
				MockMvcRequestBuilders.post(url).content(content)
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
		// 执行请求
		// .andExpect(
		// MockMvcResultMatchers.model().attributeExists("page")) // 验证存储模型数据
				/*.andExpect(
						MockMvcResultMatchers.view().name(
								"/system/role/roleList")) // 验证viewName
				 */// .andExpect(forwardedUrl("/WEB-INF/jsp/user/view.jsp"))//验证视图渲染时forward到的jsp
				.andExpect(MockMvcResultMatchers.status().isOk())// 验证状态码
				.andDo(MockMvcResultHandlers.print()); // 输出MvcResult到控制台
	}

}
