package com.iiht.stock.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.iiht.stock.UserApplication;

import net.sf.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
@AutoConfigureMockMvc
public class UserApplicationTest {

	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void defaultInfoTest() throws Exception {
		String contentAsString = this.mockMvc  
				.perform(MockMvcRequestBuilders.get("/api/user/1001").param("id", "1001"))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		Assert.assertEquals("Search fail", "1001", JSONObject.fromObject(contentAsString).getString("id"));
	}
	
	@Test
	public void userApplicationTest() throws Exception {
		String content="{\"id\":\"1001\",\"userName\":\"user99\",\"password\":\"user99\",\"userType\":\"0\",\"email\":\"999@abc.com\", \"mobileNum\":\"99111111\"}";
		MvcResult mvcResult = mockMvc.perform(post("/api/user/update").contentType(MediaType.APPLICATION_JSON)
				.content(content)).andReturn();
		mvcResult.getResponse().setCharacterEncoding("UTF-8");
		int status = mvcResult.getResponse().getStatus();
		String responseString = mvcResult.getResponse().getContentAsString();
		System.out.println(responseString);
		Assert.assertEquals(201, status);
	}
	
	/**
	 * 
	 * user exist : do nothing
	 */
	@Test
	public void registTest01() throws Exception {
		String content="{\"userName\":\"user02\",\"password\":\"user01\",\"userType\":\"0\",\"email\":\"333@abc.com\", \"mobileNum\":\"11111111\"}";
		MvcResult mvcResult = mockMvc.perform(post("/api/user/regist").contentType(MediaType.APPLICATION_JSON)
				.content(content)).andReturn();
		mvcResult.getResponse().setCharacterEncoding("UTF-8");
		int status = mvcResult.getResponse().getStatus();
		String responseString = mvcResult.getResponse().getContentAsString();
		System.out.println(responseString);
		Assert.assertEquals(200, status);
	}
	
	/**
	 * 
	 * user not exist : insert
	 */
	@Test
	@Transactional
	public void registTest02() throws Exception {
		String content="{\"userName\":\"user03\",\"password\":\"user03\",\"userType\":\"0\",\"email\":\"333@abc.com\", \"mobileNum\":\"11111111\"}";
		MvcResult mvcResult = mockMvc.perform(post("/api/user/regist").contentType(MediaType.APPLICATION_JSON)
				.content(content))
				.andExpect(status().is(201)).andDo(print()).andReturn();
		mvcResult.getResponse().setCharacterEncoding("UTF-8");
		int status = mvcResult.getResponse().getStatus();
		String responseString = mvcResult.getResponse().getContentAsString();
		System.out.println(responseString);
		Assert.assertEquals(201, status);
	}
}
