package org.wsy.spring;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.wsy.core.modules.user.domain.SystemUser;
import org.wsy.core.modules.user.domain.UserRole;
import org.wsy.core.modules.user.service.SystemUserService;
import org.wsy.core.modules.user.service.UserRoleService;
@Controller
public class InitClass {

	@Resource(name = "SystemUserServiceImpl")
	private SystemUserService systemUserService;
	
	@Resource(name = "UserRoleServiceImpl")
	private UserRoleService userRoleService;
	
	 @PostConstruct
	   public void dataInit(){
		 try {
			systemUserService.clearTable();
			userRoleService.clearTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	        SystemUser admin = new SystemUser();
	        admin.setId(1L);
	        admin.setPassword("admin");
	        admin.setUserName("admin");
	        
	        SystemUser user = new SystemUser();
	        user.setId(2L);
	        user.setPassword("user");
	        user.setUserName("user");
	        
	        UserRole rAdmin = new UserRole();
	        rAdmin.setId(1L);
	        rAdmin.setUserId(admin.getId());
	        rAdmin.setRole("ADMIN");
	        
	        UserRole rUser = new UserRole();
	        rUser.setId(2L);
	        rUser.setUserId(user.getId());
	        rUser.setRole("USER");

	        try {
				systemUserService.save(admin);
				systemUserService.save(user);
				userRoleService.save(rAdmin);
				userRoleService.save(rUser);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	
}
