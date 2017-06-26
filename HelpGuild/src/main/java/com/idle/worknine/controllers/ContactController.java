package com.idle.worknine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.idle.worknine.entity.Contact;

@Controller
public class ContactController {
	
	@Autowired
	Contact contactdetails;

	@RequestMapping(value="/contact")
	public String contact(Model model){
		model.addAttribute("contact", contactdetails);
		return "contactdef";
	}
}
