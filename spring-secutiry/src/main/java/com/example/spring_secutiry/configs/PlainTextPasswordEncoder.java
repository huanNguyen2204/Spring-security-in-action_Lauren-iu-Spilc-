package com.example.spring_secutiry.configs;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PlainTextPasswordEncoder
  implements PasswordEncoder {

  /*
  *
  * Implement methods
  *
  * */
  @Override
  public String encode(CharSequence rawPassword) {
    return rawPassword.toString();
  }

  @Override
  public boolean matches(CharSequence rawPassword, String encodedPassword) {
    return rawPassword.equals(encodedPassword);
  }
}
