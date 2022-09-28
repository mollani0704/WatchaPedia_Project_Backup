package com.project.watchapedia.service.auth;

import com.project.watchapedia.web.controller.dto.auth.UserEmailCheckReqDto;

public interface AuthService {
	public boolean checkUserEmail(UserEmailCheckReqDto userEmailCheckReqDto) throws Exception;
}
