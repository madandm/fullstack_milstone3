package com.iiht.stock;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CompanyApplication.class)
@AutoConfigureMockMvc
public class CompanyApplicationTest {

	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void companyApplicationTest() throws Exception {
		String content="{\"key\":\"company\"}";
		MvcResult mvcResult = mockMvc.perform(post("/api/company/all").contentType(MediaType.APPLICATION_JSON)
				.content(content)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
	}
	
	@Test
	public void companyApplicationTest01() throws Exception {
		String content="{\"key\":\"company1\"}";
		MvcResult mvcResult = mockMvc.perform(post("/api/company/key").contentType(MediaType.APPLICATION_JSON)
				.content(content)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(200, status);
	}
	@Test
	@Transactional
	public void companyApplicationTest02() throws Exception {
		String content="{\"companyName\":\"company01\",\"companyCode\":\"999999\",\"exchangeId\":\"200\",\"ceo\":\"Lily\",\"sectorId\":\"1002\"}";
		MvcResult mvcResult = mockMvc.perform(post("/api/company/regist").contentType(MediaType.APPLICATION_JSON)
				.content(content)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(201, status);
	}
	
	@Test
	@Transactional
	public void companyApplicationTest03() throws Exception {
		String content="{\"id\":\"2\",\"companyName\":\"company2\",\"companyCode\":\"600002\",\"exchangeId\":\"200\",\"ceo\":\"Lily\",\"sectorId\":\"1002\"}";
		MvcResult mvcResult = mockMvc.perform(post("/api/company/update").contentType(MediaType.APPLICATION_JSON)
				.content(content)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(201, status);
	}
}
