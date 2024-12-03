package com.example.spring_secutiry.models.auths.dummies;

import com.example.spring_secutiry.models.auths.UserDetails;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class SimpleUser implements UserDetails {

  /*
   *
   * Attrs
   *
   * */
  private final String username;
  private final String password;

  public SimpleUser(String username, String password) {
    this.username = username;
    this.password = password;
  }

  /*
   *
   * Impl methods
   *
   * */
  @Override
  public String getUsername() {
    return this.username;
  }

  @Override
  public String getPassword() {
    return this.password;
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
