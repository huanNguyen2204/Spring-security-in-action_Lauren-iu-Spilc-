package com.example.spring_secutiry.models.auths;

import java.io.Serializable;

public interface GrantedAuthority extends Serializable {

  String getAuthority();
}
