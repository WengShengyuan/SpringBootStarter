package org.wsy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wsy.core.generic.staticparams.StaticParams;

/**
 * 整个Controller 仅允许ADMIN权限的人员使用
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = StaticParams.PATH.AUTHADMIN)
public class AdminExclusive {
	
	
	@ResponseBody
	@RequestMapping(value = "greeting", method = RequestMethod.GET)
	public String greeting(){
		return "HELLO from admin only";
	}

}
