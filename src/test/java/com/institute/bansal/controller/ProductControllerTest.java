package com.institute.bansal.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ProductController.class)
public class ProductControllerTest {
//https://reflectoring.io/spring-boot-web-controller-test/
	//https://spring.io/blog/2014/05/07/preview-spring-security-test-method-security
	@Autowired
	MockMvc mvc;

	 @WithMockUser(username = "user")
	 @Test
	public void testgetProducts() throws Exception {
		 
		mvc.perform(get("/products").accept(MediaType.TEXT_PLAIN_VALUE)).andExpect(status().isOk()).andExpect(content().string("hello"));
	}
	 
	 @Test
	 public void testLogin() throws Exception {
	
		 mvc.perform(formLogin("/login").user( "user").password("user"))
		     .andExpect(authenticated()).andExpect(cookie().exists("JSESSIONID"));
	 }
}

