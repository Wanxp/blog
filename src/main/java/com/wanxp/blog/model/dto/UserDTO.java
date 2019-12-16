package com.wanxp.blog.model.dto;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@Data
public class UserDTO extends AbstractDTO implements UserDetails {
	private String username;
	private String password;
	private String email;
	private String homeUrl;
	private String screenName;
	private Integer activated;
	private Integer logged;
	private String groupName;
	private Boolean accountNonExpired;
	private Boolean accountNonLocked;
	private Boolean credentialsNonExpired;//
	private Boolean enabled; //是否激活
	private List<RoleDTO> authorities;

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
}
