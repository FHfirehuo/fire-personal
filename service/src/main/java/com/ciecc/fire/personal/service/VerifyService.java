package com.ciecc.fire.personal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciecc.fire.personal.domain.User;
import com.ciecc.fire.personal.domain.template.UserTemplate;


@Service
public class VerifyService {
	
	@Autowired
	private UserTemplate userTemplate;

	public boolean check(String username, String password) {
		User user = userTemplate.getByUserName(username);
		if(password.equals(user.getPassword())){
			return true;
		}
		return false;
	}

	public boolean check(User user) {
		User u = userTemplate.getByUserName(user.getUsername());
		if(user.getPassword().equals(u.getPassword())){
			user.setName(u.getName());
			user.setPassword("");
			return true;
		}
		return false;
	}

}