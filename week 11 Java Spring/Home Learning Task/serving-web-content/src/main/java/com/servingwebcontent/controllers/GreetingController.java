package com.servingwebcontent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GreetingController {
	
	// if "root/greeting" url requested, display greeting.html template
	@GetMapping("/greeting")
	public String greeting (@RequestParam(name = "user_name", required = false) String userName, Model model) {
		
		if(userName != null) { // if a username has been given, use it
			model.addAttribute("user_name", " " + userName);
		}
		return "greeting";
	}
}