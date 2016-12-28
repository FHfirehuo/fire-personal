package com.ciecc.fire.personal.backstage.cgi.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CgiInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String userAgent = request.getHeader("User-Agent");
		System.out.println("userAgent:" + userAgent);
		if (!userAgent.contains("Mozilla")) {
			System.out.println("no userAgent-------------");
		}
		// response.setHeader("User-Agent", "");
		return true;
	}

}
