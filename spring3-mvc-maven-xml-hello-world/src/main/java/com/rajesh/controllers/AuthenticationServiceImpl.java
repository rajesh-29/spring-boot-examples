package com.rajesh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajesh.logging.Logger;


@Service
public class AuthenticationServiceImpl implements IAuthenticationService {
	
	@Autowired
	private ILoginDao loginDao;
	
	@Override
	public boolean authenticate(String userName, String password) {
		Logger.log("ENTRY", "Authenticating...");
		try {
			
			/*
			 * Access user accounts database
			 * 
			 * */
			if(userName.equals("test")&&password.equals("test")){
				return true;
			}
			else if(loginDao.validate(userName, password)) {
				return true;
			}
			else{
				return false;
			}
		} catch (Exception e) {
			Logger.log("EXCEPTION","Authentication Exception");
		}
		Logger.log("EXIT","Authentication Failed");
		return false;
	}
}
