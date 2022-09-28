package com.project.watchapedia.service.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.watchapedia.domain.user.User;
import com.project.watchapedia.domain.user.UserRepository;
import com.project.watchapedia.web.controller.dto.auth.SignupReqDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService{
	
	private final UserRepository userRepository;
	
	public boolean addUser(SignupReqDto signupReqDto) throws Exception {
		
		return userRepository.save(signupReqDto.toEntity()) > 0;
	}

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		
		User userEntity = null;
		
		try {
			userEntity = userRepository.findUserByUserEmail(userEmail);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException(userEmail);
		}
		
		if(userEntity == null) {
			throw new UsernameNotFoundException(userEmail + "사용자이메일은 사용 할 수 없습니다.");
		}
		
		return new PrincipalDetails(userEntity);
	}
	
	
	
}
