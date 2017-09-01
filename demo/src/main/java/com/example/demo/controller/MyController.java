package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class MyController {
	@RequestMapping("/welcome.html")
	public ModelAndView getwelcome(){
		return new ModelAndView("welcome");
	}

}
