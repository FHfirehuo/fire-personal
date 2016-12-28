package com.ciecc.fire.personal.backstage.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ciecc.fire.common.AjaxResult;
import com.ciecc.fire.personal.domain.User;

@Controller
public class SecurityController {

	private Logger LOGGER = LoggerFactory.getLogger(SecurityController.class);

	//@Autowired
	//VerifyService verifyService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {

		return "login";
	}

	/*@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult login(String username, String password, HttpServletRequest request) {

		AjaxResult ar = new AjaxResult();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		if (verifyService.check(user)) {
			request.getSession().setAttribute("loginUser", user);
			ar.setData(user);
			LOGGER.info(username + " 登录成功");
			ar.setMessage(username + "登录成功");
		} else {
			ar.setCode(AjaxResult.SERVER_FAIL);
		}

		return ar;
	}*/

	/*@RequestMapping(value = "user", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult getLoginUser(HttpServletRequest request) {
		AjaxResult ar = new AjaxResult();
		try {
			User user = (User) request.getSession().getAttribute("loginUser");
			ar.setData(user);
		} catch (Exception e) {
			LOGGER.error("getLoginUser is error.", e);
			ar.setCode(AjaxResult.SERVER_FAIL);
		}
		return ar;
	}

	@RequestMapping(value = "signout", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult signout(HttpServletRequest request) {

		AjaxResult ar = new AjaxResult();
		try {
			String name = ((User)request.getSession().getAttribute("loginUser")).getName();
			request.getSession().removeAttribute("loginUser");
			LOGGER.info(name + " 登出成功");
			ar.setMessage(name + "登出成功");
		} catch (Exception e) {
			ar.setCode(AjaxResult.SERVER_FAIL);
		}
		return ar;
	}*/

}
