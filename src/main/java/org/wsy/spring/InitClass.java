package org.wsy.spring;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.wsy.core.modules.InitializerService;
@Controller
public class InitClass {
	
	@Autowired
	private InitializerService initializerService;
	
	
	 @PostConstruct
	  public void dataInit(){
//		 initializerService.intUserAndRoles();
	 }
		 
	
}
