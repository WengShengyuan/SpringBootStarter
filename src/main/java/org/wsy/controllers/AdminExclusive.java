package org.wsy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wsy.core.generic.staticparams.StaticParams;

@Controller
@RequestMapping(value = StaticParams.PATH.AUTHADMIN)
public class AdminExclusive {
	
	@Autowired
	private Authentication authentication;
	
	
	@ResponseBody
	@RequestMapping(value = "greeting", method = RequestMethod.GET)
	public String greeting(){
		return "HELLO from admin only";
	}

}
