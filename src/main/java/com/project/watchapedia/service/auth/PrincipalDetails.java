package com.project.watchapedia.service.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.project.watchapedia.domain.user.User;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails, OAuth2User{
	
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
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		
		user.getUserRoles().forEach(role -> {
			grantedAuthorities.add(() -> role);
		});
		
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		
		return user.getUser_password(); 
	}

	@Override
	public String getUsername() {
		
		return user.getUser_email();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Map<String, Object> getAttributes() {
		
		return attribute;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return user.getUser_email();
	}
	
	
}
