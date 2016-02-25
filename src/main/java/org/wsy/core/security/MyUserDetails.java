package org.wsy.core.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface MyUserDetails {
	
	public UserDetails findByUserName(String userName) throws UsernameNotFoundException;

	
}
