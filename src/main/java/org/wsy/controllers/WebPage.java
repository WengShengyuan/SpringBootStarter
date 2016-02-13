package org.wsy.controllers;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.wsy.core.modules.testtable.domain.TestTable;
import org.wsy.core.modules.testtable.service.TestTableService;

@Controller
@RequestMapping("/WebPage")
public class WebPage {

	@Resource(name = "TestTableServiceImpl")
	private TestTableService testTableService;
	
	
	
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
	
}
