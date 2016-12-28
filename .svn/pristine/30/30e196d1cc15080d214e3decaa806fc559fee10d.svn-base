package com.ciecc.fire.personal.backstage.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


public class UserUtil {
	
	public static UserDetails getCcurrentUser() {
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		return userDetails;
		
	}

}
