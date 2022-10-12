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
	
	@GetMapping("/movie/detail/{number}")
	public String detailMovie() {
		return "detailMovie";
	}
	
	@GetMapping("/movie/information/{number}") 
	public String contentsDetail() {
		return "contentDetail";
	}
	
	@GetMapping("/drama/detail/{number}")
	public String detailDrama() {
		return "detailDrama";
	}
	
	@GetMapping("/book/detail/{number}")
	public String detailBook() {
		return "detailBook";
	}
	
	@GetMapping("/mypage/{username}")
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
	
	@GetMapping("/movie/wishList")
	public String movieWishList() {
		return "movieWishList";
	}
	
	@GetMapping("/drama/wishList")
	public String dramaWishList() {
		return "dramaWishList";
	}
	
	@GetMapping("/adminPage")
	public String adminPage() {
		return "adminPage";
	}
	
	
}
