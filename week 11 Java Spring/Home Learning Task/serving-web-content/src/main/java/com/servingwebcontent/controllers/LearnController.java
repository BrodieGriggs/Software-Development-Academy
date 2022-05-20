package com.servingwebcontent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LearnController {
	
	// if "root/learn" url requested, display learn.html template
	@GetMapping("/learn")
	public String greeting (Model model) {
		
		return "learn";
	}
}
