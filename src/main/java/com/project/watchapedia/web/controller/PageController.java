package com.project.watchapedia.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping({"/","/movie"})
	public String Movie() {
		return "movie/mainMovie";
	}
	
	@GetMapping("/drama")
	public String Drama() {
		return "drama/mainDrama";
	}
	
	@GetMapping("/book")
	public String Book() {
		return "book/mainBook";
	}
	
	@GetMapping("/movie/detail/{number}")
	public String detailMovie() {
		return "movie/detailMovie";
	}
	
	@GetMapping("/movie/information/{number}") 
	public String contentsDetail() {
		return "movie/movieContentDetail";
	}
	
	@GetMapping("/drama/detail/{number}")
	public String detailDrama() {
		return "drama/detailDrama";
	}
	
	@GetMapping("/drama/information/{number}") 
	public String dramaContentsDetail() {
		return "drama/dramaContentDetail";
	}
	
	@GetMapping("/book/detail/{number}")
	public String detailBook() {
		return "book/detailBook";
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
		return "movie/movieWishList";
	}
	
	@GetMapping("/drama/wishList")
	public String dramaWishList() {
		return "drama/dramaWishList";
	}
	
	@GetMapping("/adminPage")
	public String adminPage() {
		return "adminPage";
	}
	
	
}
