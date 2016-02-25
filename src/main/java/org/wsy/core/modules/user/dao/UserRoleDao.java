package org.wsy.core.modules.user.dao;

import java.util.List;

import org.wsy.core.generic.dao.GenericDao;
import org.wsy.core.modules.user.domain.SystemUser;
import org.wsy.core.modules.user.domain.UserRole;

public interface UserRoleDao extends GenericDao<UserRole>{
	public List<UserRole> getRoleByUser(SystemUser user) throws Exception;
}
