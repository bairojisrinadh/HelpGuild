package com.idle.worknine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.idle.worknine.entity.User;
import com.idle.worknine.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users")
	public String users(Model model){
		model.addAttribute("users", userService.findAll());
		return "users";		
	}
	
	@RequestMapping(value="/user-detail/{id}")
	@Transactional
	public String userDetail(@PathVariable int id, Model model){
		User user = userService.findByUser(id);
		model.addAttribute("user", user);
		return "user-detail";
	}
	
}
