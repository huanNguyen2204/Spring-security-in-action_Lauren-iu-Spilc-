package com.example.spring_secutiry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ProjectConfig {

  /*
   *
   * List of @Bean
   *
   * */
  /* Add a username and password for admin at first. */
  @Bean
  public UserDetailsService userDetailsService() {
    var user = User.withUsername("john")
      .password("12345")
      .authorities("read")
      .build();
    return new InMemoryUserDetailsManager(user);
  }

  /* Add PasswordEncoder */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

  /* Security chain to apply the role */
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http)
    throws Exception {
    http.httpBasic(Customizer.withDefaults());
    http.authorizeRequests(
      c -> c.anyRequest().authenticated()
    );
    return http.build();
  }
}
