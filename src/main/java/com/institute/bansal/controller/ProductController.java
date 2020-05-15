package com.institute.bansal.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/products")
public class ProductController {

	Logger logger= Logger.getLogger(ProductController.class.getName());
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	@ResponseBody
	@GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
	public void getProducts(HttpServletResponse response) throws IOException {
		//addHeaders(response);
		logger.info("in get products");
		response.getWriter().print("hello");
	}
	
	/*
	 * @RequestMapping(method=RequestMethod.OPTIONS) public void
	 * getOptions(HttpServletResponse response) { System.out.println("in options");
	 * // addHeaders(response); response.setStatus(200);
	 * System.out.println(response); //header: Authorization }
	 */
	@ResponseBody
	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public String getProductByIds(@PathVariable int id) {
		return ""+id;
	}
	

	@PreAuthorize("principal == #p.user")
	@PostMapping
	public String addProduct(@ModelAttribute Product p) throws IOException {
		System.out.println(p);
		return "index";
	}

	private void addHeaders(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST");
		response.setHeader("Access-Control-Allow-Headers", "Authorization, Accept, Content-Type");
	}
}

class Product{
	int id;
	String name;
	String user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
}

//Rest service: codepen..