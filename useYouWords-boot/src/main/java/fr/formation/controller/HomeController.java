package fr.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	@GetMapping
	public String home() {
		return "home";	
	}
	@PostMapping
	public String postHome() {
		//return "Hello World!";
	    
		return "redirect:/home";
	}
	
}

