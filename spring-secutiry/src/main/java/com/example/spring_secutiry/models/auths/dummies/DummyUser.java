package com.example.spring_secutiry.models.auths.dummies;

import com.example.spring_secutiry.models.auths.UserDetails;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class DummyUser implements UserDetails {

  /*
  *
  * Override list
  *
  * */
  @Override
  public String getUsername() {
    return "bill";
  }

  @Override
  public String getPassword() {
    return "12345";
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(() -> "READ");
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
