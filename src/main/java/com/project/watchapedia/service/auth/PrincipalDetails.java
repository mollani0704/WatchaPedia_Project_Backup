package com.project.watchapedia.service.auth;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.watchapedia.domain.user.User;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	private User user;
	private Map<String, Object> attribute;
	
	public PrincipalDetails(User user) {
		this.user = user;
	}
	
	public PrincipalDetails(User user, Map<String, Object> attribute) {
		this.user = user;
		this.attribute = attribute;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		
		return user.getUser_password(); 
	}

	@Override
	public String getUsername() {
		
		return user.getUser_name();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
