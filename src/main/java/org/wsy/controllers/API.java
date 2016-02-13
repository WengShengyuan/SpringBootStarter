package org.wsy.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wsy.core.modules.testtable.domain.TestTable;

@Controller
@RequestMapping("/api")
public class API {
	
	@ResponseBody
	@RequestMapping("pushSession/{value}")
	public TestTable pushSession(HttpServletRequest request, @PathVariable("value") String value){
		request.getSession().setAttribute("value", value);
		TestTable a = new TestTable();
		a.setCol1("success");
		return a;
		
	}

}
