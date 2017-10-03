package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class MyController {
	@RequestMapping("/hi/welcome")
	public ModelAndView getwelcome(){
		return new ModelAndView("welcome");
	}
	@RequestMapping("/invalidSession")
	public ModelAndView getinvalidSession(){
		return new ModelAndView("invalidSession");
	}

}
