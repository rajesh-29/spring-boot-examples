package com.rajesh.controllers;

import org.springframework.stereotype.Repository;

@Repository
public interface ILoginDao {

	public boolean validate(Login login);
	public boolean validate(String userName, String password);
}
