package com.project.watchapedia.web.controller.api.auth;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.watchapedia.handler.aop.annotation.Log;
import com.project.watchapedia.handler.aop.annotation.Timer;
import com.project.watchapedia.handler.aop.annotation.ValidCheck;
import com.project.watchapedia.service.auth.AuthService;
import com.project.watchapedia.service.auth.PrincipalDetails;
import com.project.watchapedia.service.auth.PrincipalDetailsService;
import com.project.watchapedia.web.controller.dto.CMRespDto;
import com.project.watchapedia.web.controller.dto.auth.SignupReqDto;
import com.project.watchapedia.web.controller.dto.auth.UserEmailCheckReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final PrincipalDetailsService principalDetailsService;
	private final AuthService authService;
	
	@Log
	@Timer
	@ValidCheck
	@GetMapping("/signup/validation/userEmail")
	public ResponseEntity<?> checkUserEmail(@Valid UserEmailCheckReqDto userEmailCheckReqDto, BindingResult bindingResult) {
		
		boolean status = false;
		
		try {
			status = authService.checkUserEmail(userEmailCheckReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(-1, "서버 오류", status));
		}
		
		return ResponseEntity.ok(new CMRespDto<>(1, "회원가입 가능여부", status));
		
	}
	
	
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
	
	@GetMapping("/principal")
	public ResponseEntity<?> getPrincipal(@AuthenticationPrincipal PrincipalDetails principalDetails) {
				
		if(principalDetails == null) {
			return ResponseEntity.badRequest().body(new CMRespDto<>(-1, "principal is null", null));
		}
		return ResponseEntity.ok(new CMRespDto<>(1, "success load", principalDetails.getUser()));
	}
}
