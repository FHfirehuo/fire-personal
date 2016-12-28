package com.ciecc.fire.personal.portal.sercurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ciecc.fire.personal.portal.sercurity.data.UserPrincipal;
import com.ciecc.fire.personal.portal.sercurity.data.UserPrincipalRepository;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UserPrincipalRepository userPrincipalRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserPrincipal userPrincipal = userPrincipalRepository.findByUsername(username);
		if(userPrincipal == null){
			System.out.println("用户不存在");
			throw new UsernameNotFoundException("用户不存在");
		}
		System.out.println("userPrincipal:"+userPrincipal.toString());
		return userPrincipal;
	}

}
