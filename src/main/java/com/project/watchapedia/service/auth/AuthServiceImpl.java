package com.project.watchapedia.service.auth;

import org.springframework.stereotype.Service;

import com.project.watchapedia.domain.user.UserRepository;
import com.project.watchapedia.web.controller.dto.auth.UserEmailCheckReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
	
	private final UserRepository userRepository;
	
	@Override
	public boolean checkUserEmail(UserEmailCheckReqDto userEmailCheckReqDto) throws Exception {
		
		return userRepository.findUserByUserEmail(userEmailCheckReqDto.getUserEmail()) == null;
	}
	
}
