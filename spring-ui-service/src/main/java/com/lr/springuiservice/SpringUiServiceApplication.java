package com.lr.springuiservice;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringUiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringUiServiceApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<AuthenticationFilter> loggingFilter(){
	    FilterRegistrationBean<AuthenticationFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new AuthenticationFilter());
	    registrationBean.addUrlPatterns("/secure/*");
	         
	    return registrationBean;    
	}

}

@RestController
class AuthenticationController {
	
	@PostMapping("/api/login")
	public ResponseEntity<ServerResponse> login(@RequestBody Credentials credentials, HttpServletRequest request,
			HttpServletResponse response) {
		
		// session management
		HttpSession httpSession = request.getSession();
		Cookie cookie = new Cookie("SESSIONID", "qwertyuiop");
		cookie.setHttpOnly(true);
		cookie.setSecure(false); // true in production
		
		// talk to session management service

		response.addCookie(cookie);
		
		ResponseEntity<ServerResponse> responseEntity;

		if(credentials.getEmail().equals("test")) {
			ServerResponse serverResponse = new ServerResponse(OperationStatus.SUCCESS);
			responseEntity = new ResponseEntity<>(serverResponse, HttpStatus.OK);
			return responseEntity;
		}
		ServerResponse serverResponse = new ServerResponse(OperationStatus.FAILED);
		responseEntity = new ResponseEntity<>(serverResponse, HttpStatus.UNAUTHORIZED);
		return responseEntity;
	}
	
	@GetMapping("/secure/data")
	public ResponseEntity<Data> getData() {
		return new ResponseEntity<>(new Data("data from server"), HttpStatus.OK);
	}
	
}

class Data {
	
	public String message;
	
	public Data() {
	}
	
	public Data(String message) {
		super();
		this.message = message;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}



class Credentials {
	
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}

class ServerResponse {
	
	private String status;
	
	public ServerResponse() {
	}
	
	public ServerResponse(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}

class OperationStatus {
	
	public static final String SUCCESS = "SUCCESS";
	public static final String FAILED = "FAILED";
	
	private OperationStatus() {}
}


class SessionCookiePredicate {
	
	public Predicate<Cookie> isSessionCookie() {
		return p -> p.getName().equals("SESSIONID");
	}
	
	
}
