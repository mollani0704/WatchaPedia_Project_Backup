package com.project.watchapedia.web.controller.dto.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.project.watchapedia.domain.user.User;

import lombok.Data;

@Data
public class SignupReqDto {
	@NotBlank
	@Pattern(regexp = "^[가-힇]*$", message = "한글만 입력 가능합니다.")
	private String userName;
	
	@NotBlank
	@Email
	private String userEmail;
	
	@NotBlank
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[-~!@#$%^&*_+=])[a-zA-Z\\d-~!@#$%^&*_+=]{8,16}$")
	private String userPassword;
	
	public User toEntity() {
		return User.builder()
					.user_name(userName)
					.user_email(userEmail)
					.user_password(userPassword)
					.build();
	}
}
