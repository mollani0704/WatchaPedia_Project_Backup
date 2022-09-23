package com.project.watchapedia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.watchapedia.service.auth.PrincipalOauth2UserService;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final PrincipalOauth2UserService principalOauth2UserService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.authorizeRequests()
			.anyRequest()
			.permitAll()
			
			.and()
			
			.formLogin()
			.loginPage("/auth/signin")
			.loginProcessingUrl("/auth/signin")
			.failureHandler(null)
			
			.and()
			
			.oauth2Login()
			.userInfoEndpoint()
			
			.userService(principalOauth2UserService)
			
			.and()
		
			.defaultSuccessUrl("/");
//		super.configure(http);
	}
	
}
