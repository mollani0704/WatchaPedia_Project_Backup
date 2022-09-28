package com.project.watchapedia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.watchapedia.config.auth.AuthFailureHandler;
import com.project.watchapedia.service.auth.PrincipalDetailsService;
import com.project.watchapedia.service.auth.PrincipalOauth2UserService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final PrincipalOauth2UserService principalOauth2UserService;
	private final PrincipalDetailsService principalDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.headers()
			.frameOptions()
			.disable();
		
		http.authorizeRequests()
//			.antMatchers("/mypage")
//			.hasRole("ROLE_USER")
//			.access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN)")
			
			.anyRequest()
			.permitAll()
			
			.and()
			
			.formLogin()

			.usernameParameter("userEmail")
			.passwordParameter("userPassword")
			.loginPage("/signin")
			.loginProcessingUrl("/auth/signin")
			.failureHandler(new AuthFailureHandler())

			
			.and()
			
			.oauth2Login()
			.userInfoEndpoint()
			
			.userService(principalOauth2UserService)
			
			.and()
		
			.defaultSuccessUrl("/");
//		super.configure(http);
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
}
