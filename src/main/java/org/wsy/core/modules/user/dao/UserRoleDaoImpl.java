package org.wsy.core.modules.user.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.wsy.core.generic.dao.GenericDaoImpl;
import org.wsy.core.modules.user.domain.SystemUser;
import org.wsy.core.modules.user.domain.UserRole;

@Repository("UserRoleDaoImpl")
public class UserRoleDaoImpl extends GenericDaoImpl<UserRole> implements UserRoleDao{

	@Override
	public List<UserRole> getRoleByUser(SystemUser user) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", user.getId());
		return queryByMap(map);
	}

}
