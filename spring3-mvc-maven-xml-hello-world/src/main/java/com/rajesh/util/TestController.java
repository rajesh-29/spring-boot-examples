package com.rajesh.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping(value="/search-cdli")
	public void method1(HttpServletRequest request, HttpServletResponse response){
    	
		System.out.println("/search-cdli");
    }
	
	@RequestMapping(value="/view-cdli")
	public void method2(HttpServletRequest request, HttpServletResponse response){
    	
		System.out.println("/view-cdli");
    }	
	
	@RequestMapping(value="/edit-cdli")
	public void method3(HttpServletRequest request, HttpServletResponse response){
    	
		System.out.println("/edit-cdli");
    }	
	
	@RequestMapping(value="/add-cdli")
	public void method4(HttpServletRequest request, HttpServletResponse response){
    	
		System.out.println("/add-cdli");
    }	
	
	@RequestMapping(value="/login-cdli")
	public void method5(HttpServletRequest request, HttpServletResponse response){
    	
		System.out.println("/login-cdli");
    }	
}

// method = RequestMethod.GET
// String userAgent = request.getHeader("User-Agent");
// BrowserRecognitionModel browserDetails=new BrowserRecognitionModel(userAgent);
// System.out.println("Browser Name - "+browserDetails.getName());
// System.out.println("Browser Version - "+browserDetails.getVersion());
// String phone = request.getParameter("phone");
// String name = request.getParameter("name");
