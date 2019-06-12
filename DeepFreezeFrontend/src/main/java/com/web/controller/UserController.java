package com.web.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.dao.ProductDAO;
import com.web.dao.UserDAO;
import com.web.model.Product;
import com.web.model.UserDetail;

/*@Controller annotation indicates that a particular class serves the role of a controller. */
/*The dispatcher scans such annotated classes for mapped methods and detects @RequestMapping annotations.*/

@Controller
public class UserController {
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	
	
	
	@RequestMapping("/login_success")
	public String loginSuccess(HttpSession session,Model m)
	{
		System.out.println("I am in login success");
		
		String page="";
		boolean loggedIn=false;
				
		//This object will contain the logged in user detail like username and role
		SecurityContext sContext=SecurityContextHolder.getContext();
		Authentication authentication= sContext.getAuthentication();
		
		String username=authentication.getName();
		String name= authentication.getPrincipal().toString();
		System.out.println("Pricipal::::" +name);
		
		//getting all the roles associated with the user
		Collection<GrantedAuthority> roles = (Collection<GrantedAuthority>) authentication.getAuthorities();
		
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				loggedIn=true;
				page="AdminHome";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
			}
			else
			{
				List<Product> productList= productDAO.listProduct();
				m.addAttribute("productList",productList);
				loggedIn=true;
				page="Index";
				session.setAttribute("loggedIn", loggedIn);
				session.setAttribute("username", username);
				
			}
		}
				
		return page;
	}
	
	@RequestMapping(value="/RegisterUser")
	public String registerUser(@RequestParam("customername")String customerName, @RequestParam("username")String username,@RequestParam("email")String email,@RequestParam("password")String password,@RequestParam("address")String address)
	{
		System.out.println("Inside our register User controller");
		
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		System.out.println("Password#######################::::"+hashedPassword);
		
		UserDetail user = new UserDetail();
		user.setCustomername(customerName);
		user.setRole("ROLE_USER");
		user.setUserName(username);
		user.setPassword(hashedPassword);
		user.setEnabled(true);
		user.setEmail(email);
		user.setAddress(address);
		
		userDAO.addUser(user);
		System.out.println("After Adding user");
		
		return "Success";
	}
	
	@RequestMapping(value="/AdminHome")
	public String showLoginPage() 
	{
		return "AdminHome";
		
	}
	

}
