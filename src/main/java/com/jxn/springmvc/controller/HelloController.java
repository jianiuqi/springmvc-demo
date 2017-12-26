package com.jxn.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 访问http://localhost:8080/springmvc-demo/hello.htm
 * @author jxn
 */
@Controller
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView helloWorld() {
		String me = "Hello World, Spring 3.0!";
		//ModelAndView： 包含了试图要实现的模型数据和逻辑视图名
		//message 为数据的名称，在视图中用来引用的名字  
		//hello 如此例对应hello.jsp是对应视图的名字
		ModelAndView modelAndView = new ModelAndView();  
		modelAndView.addObject("message", me);  
		modelAndView.setViewName("hello");
		return modelAndView;
	}
}
