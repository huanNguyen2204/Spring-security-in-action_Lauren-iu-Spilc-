package com.example.spring_secutiry.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ProjectConfig {

  /*
  *
  * DI
  *
  * */
  private final CustomAuthenticationProvider authenticationProvider;

  public ProjectConfig(CustomAuthenticationProvider authenticationProvider) {
    this.authenticationProvider = authenticationProvider;
  }

  /*
   *
   * List of @Bean
   *
   * */
  /* Add PasswordEncoder */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

  /* Security chain to apply the role */
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http)
    throws Exception {
    // Setting roles
    http.httpBasic(Customizer.withDefaults());
    http.authorizeHttpRequests(
      c -> c.anyRequest().permitAll()
    );

    // Add a username and password for admin at first.
    var user = User.withUsername("john")
      .password("12345")
      .authorities("read")
      .build();

    // Add PasswordEncoder
    var userDetailsService = new InMemoryUserDetailsManager(user);

    return http.build();
  }
}
