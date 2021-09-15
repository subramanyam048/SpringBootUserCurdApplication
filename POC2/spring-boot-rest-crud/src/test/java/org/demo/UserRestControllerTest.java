package org.demo;

import static org.mockito.Mockito.doNothing;

import java.util.Arrays;

import org.demo.controller.UserController;
import org.demo.service.UserService;
import org.demo.util.UserUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserRestControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService userService;

	@Test
	public void getAllUserAPI() throws Exception {
		Mockito.when(userService.findAll()).thenReturn(Arrays.asList(UserUtil.getUser()));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/all").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();

		String expected = "[{\"userId\":101,\"userName\":\"subbu\",\"userSurName\":\"singanamala\",\"userPinCode\":516127,\"userBirthDate\":\"2021-09-14T13:49:24.649+00:00\",\"userJoiningDate\":\"2021-09-14T13:49:24.649+00:00\"}]";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

	}

	@Test
	public void saveUserTest() throws Exception {
		Mockito.when(userService.save(Mockito.any())).thenReturn(UserUtil.getUser());

		String expected = "{\"userId\":101,\"userName\":\"subbu\",\"userSurName\":\"singanamala\",\"userPinCode\":516127,\"userBirthDate\":\"2021-09-14T13:49:24.649+00:00\",\"userJoiningDate\":\"2021-09-14T13:49:24.649+00:00\"}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/add").accept(MediaType.APPLICATION_JSON)
				.content(expected).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void saveUserTest1() throws Exception {
		Mockito.when(userService.save(Mockito.any())).thenReturn(UserUtil.getUser());

		String expected = "{\"userId\":101,\"userName\":\"subbu\",\"userSurName\":\"singanamala\",\"userPinCode\":516127,\"userBirthDate\":\"2021-09-14T13:49:24.649+00:00\",\"userJoiningDate\":\"2021-09-14T13:49:24.649+00:00\"}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/user/update").accept(MediaType.APPLICATION_JSON)
				.content(expected).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(requestBuilder).andReturn();

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void deleteUserByIdTest() throws Exception {
		Integer userId = 101;
		Mockito.doNothing().when(userService).deleteById(userId);
		String expected = "{\"userId\":101,\"userName\":\"subbu\",\"userSurName\":\"singanamala\",\"userPinCode\":516127,\"userBirthDate\":\"2021-09-14T13:49:24.649+00:00\",\"userJoiningDate\":\"2021-09-14T13:49:24.649+00:00\"}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/userId").accept(MediaType.APPLICATION_JSON)
		.content(expected).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mvc.perform(requestBuilder).andReturn();

	
	}

	@Test
	public void getUserAPI() throws Exception {
		Mockito.when(userService.findByUserName(Mockito.anyString())).thenReturn(Arrays.asList(UserUtil.getUser()));
		String expected = "{\"userId\":101,\"userName\":\"subbu\",\"userSurName\":\"singanamala\",\"userPinCode\":516127,\"userBirthDate\":\"2021-09-14T13:49:24.649+00:00\",\"userJoiningDate\":\"2021-09-14T13:49:24.649+00:00\"}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/userName").accept(MediaType.APPLICATION_JSON)
		.content(expected).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mvc.perform(requestBuilder).andReturn();
		
		
	}

	@Test
	public void getallSortByUserBirthDateApi() throws Exception {
		Mockito.when(userService.findAllSortByBirthDate()).thenReturn(Arrays.asList(UserUtil.getUser()));
		String expected = "{\"userId\":101,\"userName\":\"subbu\",\"userSurName\":\"singanamala\",\"userPinCode\":516127,\"userBirthDate\":\"2021-09-14T13:49:24.649+00:00\",\"userJoiningDate\":\"2021-09-14T13:49:24.649+00:00\"}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/allSortByUserBirthDate").accept(MediaType.APPLICATION_JSON)
		.content(expected).contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mvc.perform(requestBuilder).andReturn();

		
	}

}
