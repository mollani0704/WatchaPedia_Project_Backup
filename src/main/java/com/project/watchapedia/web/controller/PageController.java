package com.project.watchapedia.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping({"/","/movie"})
	public String Movie() {
		return "mainMovie";
	}
	
	@GetMapping("/drama")
	public String Drama() {
		return "mainDrama";
	}
	
	@GetMapping("/book")
	public String Book() {
		return "mainBook";
	}
	
	@GetMapping("/detail/{number}")
	public String detail() {
		return "detail";
	}
	
	@GetMapping("/mypage")
	public String MyPage() {
		return "myPage";
	}
	
	@GetMapping("/signin")
	public String SignIn() {
		return "signIn";
	}
	
	@GetMapping("/signup")
	public String SignUp() {
		return "signUp";
	}
}
