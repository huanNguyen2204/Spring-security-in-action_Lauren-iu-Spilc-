package com.example.spring_secutiry.services;

import com.example.spring_secutiry.models.auths.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {

  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
