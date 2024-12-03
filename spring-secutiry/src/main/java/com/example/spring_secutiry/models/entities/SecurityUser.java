package com.example.spring_secutiry.models.entities;

import com.example.spring_secutiry.models.auths.UserDetails;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class SecurityUser implements UserDetails {

  /*
  *
  * Attrs
  *
  * */
  private final User user;

  public SecurityUser(User user) {
    this.user = user;
  }

  /*
  *
  * Impl methods
  *
  * */
  @Override
  public String getUsername() {
    return "";
  }

  @Override
  public String getPassword() {
    return "";
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of();
  }

  @Override
  public boolean isAccountNonExpired() {
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return false;
  }
}
