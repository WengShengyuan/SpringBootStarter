package org.wsy.core.modules;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wsy.core.modules.user.dao.SystemUserDao;
import org.wsy.core.modules.user.dao.UserRoleDao;
import org.wsy.core.modules.user.domain.SystemUser;
import org.wsy.core.modules.user.domain.UserRole;

@Service("InitializerService")
public class InitializerService {
	

	@Resource(name = "SystemUserDaoImpl")
	private SystemUserDao systemUserDao;
	

	@Resource(name = "UserRoleDaoImpl")
	private UserRoleDao userRoleDao;
	
	@Transactional
	public void intUserAndRoles() {
		try {
			systemUserDao.clearTable();
			userRoleDao.clearTable();
			
			SystemUser admin = new SystemUser();
//			admin.setId(1L);
			admin.setPassword("admin");
			admin.setUserName("admin");
			
			SystemUser user = new SystemUser();
//			user.setId(2L);
			user.setPassword("user");
			user.setUserName("user");
			
			UserRole rAdmin = new UserRole();
//			rAdmin.setId(1L);
			rAdmin.setUserId(admin.getId());
			rAdmin.setRole("ADMIN");
			
			UserRole rUser = new UserRole();
//			rUser.setId(2L);
			rUser.setUserId(user.getId());
			rUser.setRole("USER");
			
			systemUserDao.save(admin);
			systemUserDao.save(user);
			userRoleDao.save(rAdmin);
			userRoleDao.save(rUser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
