package org.wsy.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.wsy.core.generic.staticparams.StaticParams;
import org.wsy.core.modules.user.domain.SystemUser;
import org.wsy.core.modules.user.service.SystemUserService;
import org.wsy.core.modules.user.service.UserRoleService;

@Controller
public class SecurityController {

	@Resource(name = "SystemUserServiceImpl")
	private SystemUserService systemUserService;
	
	@Resource(name = "UserRoleServiceImpl")
	private UserRoleService userRoleService;
	
	
	/**
	 * 默认登陆页面
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		ModelAndView view = new ModelAndView();
		view.setViewName("login");
		return view;
	}
	
	
	
	/**
	 * 登陆接口，不能被拦截
	 * @param request
	 * @param response
	 * @param name
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = StaticParams.PATH.NOAUTH+"/api/doLogin/{name}/{password}")
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
	@RequestMapping(value = "/logout")
	public String doLogout(HttpServletRequest request, HttpServletResponse response){
		return "logout";
	}
	
	@ResponseBody
	@RequestMapping(value = "/logoutsuccess")
	public String logoutSuccess(){
		return "logout success";
	}
	
}
