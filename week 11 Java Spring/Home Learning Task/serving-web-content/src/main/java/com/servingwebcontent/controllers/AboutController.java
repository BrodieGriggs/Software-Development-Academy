package com.servingwebcontent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
	
	// if "root/about" url requested, display about.html template
	@GetMapping("/about")
	public String greeting (Model model) {
		
		return "about";
	}
}
