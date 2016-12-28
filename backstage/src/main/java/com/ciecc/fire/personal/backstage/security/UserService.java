package com.ciecc.fire.personal.backstage.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{

	private UserPrincipalRepository userPrincipalRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserPrincipal userPrincipal = userPrincipalRepository.findByUsername(username);
		System.out.println("------userPrincipal:"+userPrincipal);
		return userPrincipal;
	}

}
