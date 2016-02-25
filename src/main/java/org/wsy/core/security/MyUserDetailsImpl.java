package org.wsy.core.security;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.wsy.core.modules.user.service.SystemUserService;
import org.wsy.core.modules.user.service.UserRoleService;

@Service("MyUserDetailsImpl")
public class MyUserDetailsImpl implements MyUserDetails {
	@Resource(name = "SystemUserServiceImpl")
	private SystemUserService systemUserService;

	@Resource(name = "UserRoleServiceImpl")
	private UserRoleService userRoleService;

	@Override
	public UserDetails findByUserName(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
