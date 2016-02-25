package org.wsy.spring.security;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.wsy.core.modules.user.domain.SystemUser;
import org.wsy.core.modules.user.domain.UserRole;
import org.wsy.core.modules.user.service.SystemUserService;
import org.wsy.core.modules.user.service.UserRoleService;

@Service("MyUserDetailsImpl")
public class MyUserDetailsService implements UserDetailsService {
	@Resource(name = "SystemUserServiceImpl")
	private SystemUserService systemUserService;

	@Resource(name = "UserRoleServiceImpl")
	private UserRoleService userRoleService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		SystemUser user;
		try {
			user = systemUserService.findByName(userName);
		} catch (Exception e) {
			throw new UsernameNotFoundException("user select fail");
		}
		if(user == null){
			throw new UsernameNotFoundException("no user found");
		} else {
			try {
				List<UserRole> roles = userRoleService.getRoleByUser(user);
				return new MyUserDetails(user, roles);
			} catch (Exception e) {
				throw new UsernameNotFoundException("user role select fail");
			}
		}
	}
}
