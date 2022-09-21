package com.project.watchapedia.service.auth;

import org.springframework.stereotype.Service;

import com.project.watchapedia.domain.user.UserRepository;
import com.project.watchapedia.web.controller.dto.auth.SignupReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService {
	
	private final UserRepository userRepository;
	
	public boolean addUser(SignupReqDto signupReqDto) throws Exception {
		
		return userRepository.save(signupReqDto.toEntity()) > 0;
	}
	
}
