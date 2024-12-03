package com.example.spring_secutiry.services;

import com.example.spring_secutiry.models.auths.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class InMemoryUserDetailsService implements UserDetailsService {

  /*
  *
  * Attrs
  *
  * */
  private final List<UserDetails> users;

  public InMemoryUserDetailsService(List<UserDetails> users) {
    this.users = users;
  }

  /*
  *
  * Implement methods
  *
  * */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return users.stream()
      .filter(u -> u.getUsername().equals(username))
      .findFirst()
      .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }
}
