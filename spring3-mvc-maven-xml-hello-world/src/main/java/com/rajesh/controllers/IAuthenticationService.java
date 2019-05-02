package com.rajesh.controllers;

import org.springframework.stereotype.Service;

@Service
public interface IAuthenticationService {
	public boolean authenticate(String userName, String password);
}
