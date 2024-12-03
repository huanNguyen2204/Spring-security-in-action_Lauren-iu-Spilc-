package com.example.spring_secutiry.configs;

import com.example.spring_secutiry.filters.RequestValidationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.DefaultLdapUsernameToDnMapper;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.userdetails.LdapUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class ProjectConfig {

  @Bean
  public UserDetailsService userDetailsService(DataSource dataSource) {
    var cs = new DefaultSpringSecurityContextSource("ldap://127.0.0.1:33389/dc=springframework,dc=org");
    cs.afterPropertiesSet();

    var manager = new LdapUserDetailsManager(cs);
    manager.setUsernameMapper(new DefaultLdapUsernameToDnMapper("ou=groups", "uid"));
    manager.setGroupSearchBase("ou=groups");
    return manager;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http)
    throws Exception {
    http.addFilterBefore(
      new RequestValidationFilter(), BasicAuthenticationFilter.class
    )
      .authorizeHttpRequests(c -> c.anyRequest().permitAll());
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    Map<String, PasswordEncoder> encoders = new HashMap<>();
    encoders.put("noop", NoOpPasswordEncoder.getInstance());
    encoders.put("bcrypt", new BCryptPasswordEncoder());
//    encoders.put("scrypt", new SCryptPasswordEncoder());

    return new DelegatingPasswordEncoder("bcrypt", encoders);
  }

//  /*
//  *
//  * DI
//  *
//  * */
//  private final CustomAuthenticationProvider authenticationProvider;
//
//  public ProjectConfig(CustomAuthenticationProvider authenticationProvider) {
//    this.authenticationProvider = authenticationProvider;
//  }
//
//  /*
//   *
//   * List of @Bean
//   *
//   * */
//  /* Add PasswordEncoder */
//  @Bean(name = "userDetails2")
//  public UserDetailsService userDetailsService() {
//    UserDetails u = new User("john", "12345", "read");
//    List<UserDetails> users = List.of(u);
//    return new InMemoryUserDetailsService(users);
//  }
//
//  @Bean(name = "passwordEnd2")
//  public PasswordEncoder passwordEncoder() {
//    return NoOpPasswordEncoder.getInstance();
//  }

  /* Security chain to apply the role */
//  @Bean
//  public SecurityFilterChain securityFilterChain(HttpSecurity http)
//    throws Exception {
//    // Setting roles
//    http.httpBasic(Customizer.withDefaults());
//    http.authorizeHttpRequests(
//      c -> c.anyRequest().permitAll()
//    );
//
//    // Add a username and password for admin at first.
//    var user = User.withUsername("john")
//      .password("12345")
//      .authorities("read")
//      .build();
//
//    // Add PasswordEncoder
//    var userDetailsService = new InMemoryUserDetailsManager(user);
//
//    return http.build();
//  }
}
