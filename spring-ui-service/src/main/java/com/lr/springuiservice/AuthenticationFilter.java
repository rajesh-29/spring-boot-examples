package com.lr.springuiservice;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("~~~AuthenticationFilter~~~");
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession httpSession = request.getSession(false);
		Cookie cookies[] = request.getCookies();
		
		String[] allowDomain = {"http://localhost:3000","https://localhost:8080"};
	    Set<String> allowedOrigins = new HashSet<String>(Arrays.asList (allowDomain));                  
	    String originHeader = request.getHeader("Origin");
	    
		response.setHeader("Access-Control-Allow-Origin", originHeader);
		System.out.println("--- cookies ---");
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				System.out.println(cookie.getName() + "=" + cookie.getValue());
			}
		}
		System.out.println("------");
		/*
		if(httpSession != null) {
			
			Optional<Cookie> sessionCookie = Stream.of(cookies)
				.filter(p -> p.getName().equals("SESSIONID"))
				.findAny();
			
			if(sessionCookie.isPresent()) {
				if(sessionCookie.get().equals("qwertyuiop")) {
					
					// talk to session management service
					chain.doFilter(request, response);
				}
			}
		}
		*/
		chain.doFilter(request, response);
		// response.sendError(401);
	}

	@Override
	public void destroy() {
		
	}

}
