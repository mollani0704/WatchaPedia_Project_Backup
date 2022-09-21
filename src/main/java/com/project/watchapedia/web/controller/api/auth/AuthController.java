package com.project.watchapedia.web.controller.api.auth;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.watchapedia.service.auth.PrincipalDetailsService;
import com.project.watchapedia.web.controller.dto.CMRespDto;
import com.project.watchapedia.web.controller.dto.auth.SignupReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final PrincipalDetailsService principalDetailsService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody @Valid SignupReqDto signupReqDto, BindingResult bindingResult) {
		
		boolean status = false;
		
		if(bindingResult.hasErrors()) {
			Map<String, String> errorMessage = new HashMap<String, String>();
			
			bindingResult.getFieldErrors().forEach(error -> {
				errorMessage.put(error.getField(), error.getDefaultMessage());
			});
			
			return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "유효성 검사 실패", errorMessage));
		}
		
		try {
			status = principalDetailsService.addUser(signupReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "회원가입 실패", status ));
		}
		
		return ResponseEntity.ok(new CMRespDto<>(1, "회원가입 성공", status));
	}
}
