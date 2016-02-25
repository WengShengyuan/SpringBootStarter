package org.wsy.core.modules.user.service;

import java.util.List;

import org.wsy.core.generic.service.GenericService;
import org.wsy.core.modules.user.domain.SystemUser;
import org.wsy.core.modules.user.domain.UserRole;

public interface UserRoleService extends GenericService<UserRole> {
	public List<UserRole> getRoleByUser(SystemUser user) throws Exception; 
}
