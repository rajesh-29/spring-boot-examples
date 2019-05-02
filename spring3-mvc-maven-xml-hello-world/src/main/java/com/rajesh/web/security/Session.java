package com.rajesh.web.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.rajesh.logging.Logger;

public class Session {
	
	private HttpServletRequest request;
	
	public Session(HttpServletRequest request) {
		this.request = request;
	}
	
	public static HttpSession createNewSessionFor(HttpServletRequest request, String userName){
		/*
		 * Set session and create session variables
		 * 
		 * */
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("WinAutStatus", "PASSED");
		httpSession.setAttribute("WinUserName", userName);
		return httpSession;
	}
	
	public void logOut(){
		Logger.log("ENTRY", "Session/logOut");
		try {
			HttpSession httpSession = request.getSession(false);
			if (httpSession != null) {
				try {
					httpSession.removeAttribute("WinAutStatus");
					httpSession.removeAttribute("WinUserName");
				} catch (Exception e) {
				}
				httpSession.invalidate();
			}
		} catch (Exception e) {
			Logger.log("EXCEPTION","Session/logOut Exception");
		}
		Logger.log("EXIT", "Session/logOut");		
	}
	
	public boolean isValidSession(){
		Logger.log("ENTRY", "Session/isValidSession");
		try {
			HttpSession httpSession = request.getSession(false);
			if (httpSession!=null) {
				if(httpSession.getAttribute("WinAutStatus").equals("PASSED")){
					Logger.log("EXIT","Session/isValidSession:valid");
					return true;
				}
			}
		} catch (Exception e) {
			Logger.log("EXCEPTION","Session/isValidSession Exception");
		}
		Logger.log("EXIT","Session/isValidSession : inValid");
		return false;
	}
	
	public String getUserName(){
		Logger.log("ENTRY", "Session/getUserName");
		String user=null;
		try{
			user=request.getSession(false).getAttribute("WinUserName").toString();
			if(user!=null){
				Logger.log("EXIT","Session/getUserName : "+user);
				return user;
			}
		} catch (Exception e) {
			Logger.log("EXIT","Session/getUserName Exception Invalid Session");
		}
		return null;
	}
}
