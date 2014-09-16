package com.fms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.model.User;
import com.fms.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user")
	public String setupForm(Map<String, Object> map){
		User user = new User();
		map.put("user", user);
		map.put("userList", userService.getAllUser());
		return "user";
	}
	
	@RequestMapping(value="/user.html", method=RequestMethod.POST)
	public String doActions(@ModelAttribute User user, BindingResult result, @RequestParam String action, Map<String, Object> map){
		User userResult = new User();
		if(action.toLowerCase().equals("add")){
			userService.add(user);
			//userResult =getUser();
		}else if(action.toLowerCase().equals("update")){
			userService.edit(user);
			//userResult =user;
		}
		
		map.put("user", userResult);
		map.put("userList", userService.getAllUser());
		return "user";
	}
	

}
