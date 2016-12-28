package com.ciecc.fire.personal.backstage.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ciecc.fire.personal.domain.User;

@Controller
@RequestMapping("user")
public class UserController {
	
	private Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="home", method= RequestMethod.GET)
	public String home(HttpServletRequest request) {
		//User user = (User) request.getSession().getAttribute("loginUser");
		//LOGGER.info("user:"+user.toString());
		return "user/home";
	}

}
