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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BaseDataApplication.class)
@AutoConfigureMockMvc
public class BaseDataApplicationTest {

	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	@Transactional
	public void baseDataApplicationTest() throws Exception {
		String content="{\"id\":\"3\",\"exchangeId\":\"300\",\"exchangeName\":\"OSE\",\"brief\":\"brief\",\"contactAddr\":\"\",\"remarks\":\"remarks\"}";
		MvcResult mvcResult = mockMvc.perform(post("/api/mangeStock/add").contentType(MediaType.APPLICATION_JSON)
				.content(content)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		Assert.assertEquals(201, status);
	}
}
