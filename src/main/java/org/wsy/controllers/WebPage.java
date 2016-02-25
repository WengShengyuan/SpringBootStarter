package org.wsy.controllers;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.wsy.core.modules.testtable.domain.TestTable;
import org.wsy.core.modules.testtable.service.TestTableService;
import org.wsy.core.modules.user.domain.SystemUser;
import org.wsy.core.modules.user.service.SystemUserService;

@Controller
public class WebPage {

	@Resource(name = "TestTableServiceImpl")
	private TestTableService testTableService;
	
	@Resource(name = "SystemUserServiceImpl")
	private SystemUserService systemUserService;
	
	
	 @PostConstruct
	   public void dataInit(){
		 try {
			systemUserService.clearTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	        SystemUser admin = new SystemUser();
	        admin.setPassword("admin");
	        admin.setUserName("admin");
	        
	        SystemUser user = new SystemUser();
	        user.setPassword("user");
	        user.setUserName("user");
	        
	        try {
				systemUserService.save(admin);
				systemUserService.save(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	
	
	
	@ResponseBody
	@RequestMapping("nopass")
	public String noPass(){
		return "noPass";
	}
	
	@RequestMapping("hello")
	public ModelAndView mainPage(HttpServletRequest request){
		ModelAndView view = new ModelAndView();
		view.setViewName("hello");
		view.addObject("data", "data from java");
		view.addObject("value", (String) request.getSession().getAttribute("value"));
		
		try {
			TestTable t =new TestTable();
			t.setCol1(new Date().toString());
			testTableService.save(t);
			List<TestTable> ts = testTableService.findAll();
			view.addObject("list", ts);
			if(ts != null && ts.size()>10){
				testTableService.clearTable();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return view;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView();
		view.setViewName("login");
		return view;
	}
	
	@ResponseBody
	@RequestMapping(value = "api/doLogin/{name}/{password}")
	public String doLogin(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("name") String name,
			@PathVariable("password") String password){
		System.out.println("Logging in --> " + name + " : " + password);
		SystemUser user;
		try {
			user = systemUserService.findByName(name);
		} catch (Exception e) {
			return "system error";
		}
		if(user == null){
			return "No User";
		}
		
	        
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "api/doLogout")
	public String doLogout(HttpServletRequest request, HttpServletResponse response){
		return "logout";
	}
	
}
