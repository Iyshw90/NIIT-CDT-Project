package com.web.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*@Controller annotation indicates that a particular class serves the role of a controller. */
/*The dispatcher scans such annotated classes for mapped methods and detects @RequestMapping annotations.*/

@Controller
public class PageController {
	
	@RequestMapping(value="/login")
	public String showLoginPage() 
	{
		return "Login";
		
	}
	
	@RequestMapping(value="/register")
	public String showRegisterPage() 
	{
		return "Register";
		
	}
	
	@RequestMapping(value="/aboutUs")
	public String showAboutUsPage() 
	{
		return "AboutUs";
		
	}

}
