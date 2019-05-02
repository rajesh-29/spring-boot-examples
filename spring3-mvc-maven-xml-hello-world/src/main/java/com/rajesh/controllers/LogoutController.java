package com.rajesh.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rajesh.logging.Logger;
import com.rajesh.web.security.Session;

@Controller
public class LogoutController {

	@ExceptionHandler(Exception.class)
	public void handleConflict() {
		Logger.log("EXCEPTION","LogoutController Exception Handler");
	}
	
	@RequestMapping("/logout")
	public ModelAndView auth(HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes attributes) {
		
		Logger.log("ENTRY","LogoutController");
		new Session(request).logOut();
		Logger.log("EXIT","LogoutController");
		return new ModelAndView("index", "message", new String("You are logged out"));
	}
}
