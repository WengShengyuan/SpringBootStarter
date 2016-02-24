package org.wsy.core.modules.user.service;

import org.wsy.core.generic.service.GenericService;
import org.wsy.core.modules.user.domain.SystemUser;

public interface SystemUserService extends GenericService<SystemUser>{
	public SystemUser findByName(String name) throws Exception;
}
