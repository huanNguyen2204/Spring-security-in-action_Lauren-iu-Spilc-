package com.example.spring_secutiry.services;

import com.example.spring_secutiry.models.auths.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsManager extends UserDetailsService {

  void createUser(UserDetails user);

  void updateUser(UserDetails user);

  void deleteUser(String username);

  void changePassword(String oldPassword, String newPassword);

  boolean userExists(String username);
}
