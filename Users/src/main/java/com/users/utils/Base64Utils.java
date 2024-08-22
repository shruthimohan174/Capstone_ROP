package com.users.utils;

import java.util.Base64;

public class Base64Utils {

  public static String encodePassword(String password){
    return Base64.getEncoder().encodeToString(password.getBytes());
  }

  public static String decodePassword(String encodedPassword){
    return new String(Base64.getDecoder().decode(encodedPassword));
  }
}
