package com.example.spring_secutiry.models.auths;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

public interface UserDetails extends Serializable {

  String getUsername();

  String getPassword();

  Collection<? extends GrantedAuthority> getAuthorities();

  boolean isAccountNonExpired();

  boolean isAccountNonLocked();

  boolean isCredentialsNonExpired();

  boolean isEnabled();
}
