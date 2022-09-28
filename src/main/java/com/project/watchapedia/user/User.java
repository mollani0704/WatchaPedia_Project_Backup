package com.project.watchapedia.user;

import java.time.LocalTime;

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
    private String user_roles;
    private String oauth2_id;
    private String user_provider;
    private LocalTime create_date;
    private LocalTime update_date;
}
