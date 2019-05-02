package com.rajesh.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.rajesh.logging.Logger;
import com.rajesh.web.security.Session;

@Controller
public class AuthenticationController {

	@ExceptionHandler(Exception.class)
	public void handleConflict() {
		Logger.log("EXCEPTION","AuthenticationController Exception Handler");
	}
	
	@Autowired
	private IAuthenticationService authenticationService;
	
	@RequestMapping("/authenticate")
	public ModelAndView auth(HttpServletRequest request,
			HttpServletResponse response,
			RedirectAttributes attributes) {
		
		Logger.log("ENTRY","AuthenticationController/authenticate");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (authenticationService.authenticate(userName, password)) {
			Session.createNewSessionFor(request, userName);
			Logger.log("EXIT","AuthenticationController/authenticate");
			return new ModelAndView("home");
		} else {
			attributes.addFlashAttribute("message","fail");
			Logger.log("EXIT","AuthenticationController/authenticate");
			return new ModelAndView("index", "message", new String("Invalid credentials"));
		}
	}
	
}
