package com.project.watchapedia.domain.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	private int user_code;
	private String user_name;
	private String user_email;
	private String user_password;
	private String oauth2_id;
	private String user_roles;
	private String user_provider;
	private LocalDateTime create_date;
	
	public List<String> getUserRoles() {
		if(user_roles == null || user_roles.isBlank()) {
			return new ArrayList<String>();
		}
		
		return Arrays.asList(user_roles.replaceAll(" ", "").split(","));
	}
 }
