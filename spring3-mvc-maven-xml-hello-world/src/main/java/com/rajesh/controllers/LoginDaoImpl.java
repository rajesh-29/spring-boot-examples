package com.rajesh.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements ILoginDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public boolean validate(Login login) {
		
		
		System.out.println("~~~ " + "LoginDaoImpl()...");
		
		try {
			String sql = "select * from Login where username='" + login.getUsername() + "' and password='" + login.getPassword() + "'";

			// List<User> users = jdbcTemplate.query(sql, new UserMapper());
			List<Login> users = jdbcTemplate.query(sql, new RowMapper() {
				
				@Override
				public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
					Login user = new Login(rs.getString("username"), rs.getString("password"));
					return user;
				}
			});
			System.out.println("~~~ " + users);
			return users.size() > 0 ? true : false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean validate(String userName, String password) {
		
		return validate(new Login(userName,password));
	}

}
