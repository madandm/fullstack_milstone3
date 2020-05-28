package com.iiht.stock;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StockpriceApplication.class)
@AutoConfigureMockMvc
public class StockpriceApplicationTest {

	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void stockpriceApplicationTest() throws Exception {
		String content="{\"key1\":\"company1\",\"period\":\"day\"}";
		MvcResult mvcResult = mockMvc.perform(post("/api/echart/search").contentType(MediaType.APPLICATION_JSON)
				.content(content)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		String resultString = mvcResult.getResponse().getContentAsString();
		System.out.print(resultString);
		Assert.assertEquals(200, status);
	}
	
	@Test
	public void stockpriceApplicationTest01() throws Exception {
		String content="{\"key1\":\"company1\",\"PeriodFrom\":\"2020-05-01\"}";
		MvcResult mvcResult = mockMvc.perform(post("/api/echart/compare").contentType(MediaType.APPLICATION_JSON)
				.content(content)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		String resultString = mvcResult.getResponse().getContentAsString();
		System.out.print(resultString);
		Assert.assertEquals(200, status);
	}
}
