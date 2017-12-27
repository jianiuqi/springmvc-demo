package com.jxn.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONWriter;
import com.jxn.springmvc.bean.UserBean;

/**
 * http://localhost:8080/springmvc-demo/demo/getParamsDemo1.htm?uname=jxn&pwd=123
 * @author jxn
 */
@Controller
@RequestMapping(value="/demo")
public class GetController {
	
	/**
	 * 1.直接把表单的参数写在Controller相应的方法的形参中
	 */
	@RequestMapping("/getParamsDemo1")
	public void getParamsDemo1(String uname, String pwd, HttpServletResponse response) throws Exception{
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());
		Map<String, String> user = new HashMap<String, String>();
		user.put("username", uname);
		user.put("password", pwd);
		writer.writeObject(user);
		writer.flush();
		writer.close();
	}
	
	/**
	 * 2、通过HttpServletRequest接收，post方式和get方式都可以
	 */
	@RequestMapping("/getParamsDemo2")
	public void getParamsDemo2(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String username=request.getParameter("uname");
        String password=request.getParameter("pwd");
        response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());
		Map<String, String> user = new HashMap<String, String>();
		user.put("username", username);
		user.put("password", password);
		writer.writeObject(user);
		writer.flush();
		writer.close();
	}
	
	/**
	 * 3、通过一个bean来接收, post方式和get方式都可以
	 */
	@RequestMapping("/getParamsDemo3")
	public void getParamsDemo3(UserBean userBean, HttpServletResponse response) throws Exception{
        response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());
		Map<String, String> user = new HashMap<String, String>();
		user.put("username", userBean.getUname());
		user.put("password", userBean.getPwd());
		writer.writeObject(user);
		writer.flush();
		writer.close();
	}
	
	@RequestMapping(value="/getParamsDemo4", method=RequestMethod.GET)
	public void getParamsDemo4(@RequestParam String uname, @RequestParam String pwd, HttpServletResponse response) throws Exception{
		response.setContentType("application/json;charset=utf-8");
		JSONWriter writer = new JSONWriter(response.getWriter());
		Map<String, String> user = new HashMap<String, String>();
		user.put("username", uname);
		user.put("password", pwd);
		writer.writeObject(user);
		writer.flush();
		writer.close();
	}
}
