package com.example.spring_secutiry.configs;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha512PasswordEncoder
  implements PasswordEncoder {

  /*
  *
  * Implement methods
  *
  * */
  @Override
  public String encode(CharSequence rawPassword) {
    return hashWithSHA512(rawPassword.toString());
  }

  @Override
  public boolean matches(CharSequence rawPassword, String encodedPassword) {
    return false;
  }

  /*
  *
  * Private methods
  *
  * */
  private String hashWithSHA512(String input) {
    StringBuilder result = new StringBuilder();

    try {
      MessageDigest md = MessageDigest.getInstance("SHA-512");
      byte[] digested = md.digest(input.getBytes());
      for (int i=0;i<digested.length;i++) {
        result.append(Integer.toHexString(0xFF & digested[i]));
      }
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Bad algorith");
    }

    return result.toString();
  }
}
