package com.idle.worknine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.idle.worknine.entity.Register;
import com.idle.worknine.entity.User;
import com.idle.worknine.service.LoginService;
import com.idle.worknine.service.UserService;

@Controller
public class LoginController {
	
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	UserService userService;

	@ModelAttribute(value="registernow")
	public Register construct(){
		return new Register();
	}
	
	@RequestMapping(value = "/login")
	public String login(){
		return "logindef";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String authenticate(@RequestParam String email,
			@RequestParam String password, Model model){
		System.out.println(email);
		System.out.println(password);
		Register register = new Register(email);
		Integer id = register.getId();
		Register authenticate = loginService.authenticate(id);
		model.addAttribute("user", authenticate);
		if(authenticate != null){
			if(email.equals(authenticate.getEmail()) && password.equals(authenticate.getPassword())){
				return "loginpostdef";
			}
		}
		return "error";
	}
	
	@RequestMapping(value = "/register")
	public String register(){
		return "registerdef";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String performRegistration(@ModelAttribute("registernow") Register register, Model model) throws Exception{
		if(register.getPassword().equals(register.getConfirmPassword())){
		loginService.save(register);
		}else{
			throw new Exception();
		}
		User user = new User();
		user.setName(register.getName());
		userService.save(user);
		System.out.println(user.toString());
		model.addAttribute("user", user);
		return "success";
	}
}
