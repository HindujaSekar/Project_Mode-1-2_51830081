package com.bankapp.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {
	@GetMapping(path="login")
	public String login(){
		return "loginpage";
	}
	@GetMapping(path="accessdenied")
	public String accessdenied(Principal user){
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("msg", "Hi " + user.getName()
					+ ", You can not access this page!");
		} else {
			model.addObject("msg", "You can not access this page!");
		}

		return "403";
	}
	@GetMapping(path="/")
	public String welcome(){
		
		 return "redirect:/home";
	}
	@GetMapping(path="home")
	public ModelAndView home(ModelAndView mv){
		mv.addObject("info","hello to spring boot");
		mv.setViewName("home");
		return mv;
	}
}
