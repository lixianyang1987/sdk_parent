package com.hytx.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
/*@ContextConfiguration(locations = "file*:src/main/webapp/WEB-INF/spring-mvc.xml")*/
@ContextHierarchy({
		@ContextConfiguration(name = "parent", locations = "classpath:applicationContext.xml"),
		@ContextConfiguration(name = "child", locations = "file:src/main/webapp/WEB-INF/spring-mvc.xml") })
public class AbstractContextControllerTests extends
		AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	protected WebApplicationContext wac;

	protected MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

}
