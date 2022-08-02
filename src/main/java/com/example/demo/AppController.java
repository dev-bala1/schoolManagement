package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class AppController {
	
	@Autowired
	private UserRepository repo;
	
	@GetMapping("")
	public String viewHomepage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showSingUpForm(Model model){
		model.addAttribute("user",new User());
		return "signup";
	}
	
	
	@PostMapping("/process_register")  //process_register
	public String processRegistration(User user) {
		repo.save(user);
		return "successfull";
	}
	@GetMapping("/list_user")
	public String viewusers() {
		return "users";
	}

}
