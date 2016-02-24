package org.wsy.core.modules.user.dao;

import org.wsy.core.generic.dao.GenericDao;
import org.wsy.core.modules.user.domain.SystemUser;

public interface SystemUserDao extends GenericDao<SystemUser> {
	
	public SystemUser findByName(String name) throws Exception;

}
