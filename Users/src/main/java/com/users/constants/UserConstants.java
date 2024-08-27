package com.users.constants;

public final class UserConstants {
  public static final String USER_ALREADY_EXISTS = "User already exists with this email.";
  public static final String INVALID_CREDENTIALS = "Invalid email or password";
  public static final String USER_NOT_FOUND = "User does not exist";
  public static final String ADDRESS_NOT_FOUND = "No Address found with this id";

  private UserConstants() {
    throw new UnsupportedOperationException("Utility class");
  }
}
