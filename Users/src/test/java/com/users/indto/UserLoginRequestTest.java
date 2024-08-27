package com.users.indto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserLoginRequestTest {

  private UserLoginRequest userLoginRequest;

  @BeforeEach
  void setUp() {
    userLoginRequest = new UserLoginRequest();
  }

  @Test
  void testSettersAndGetters() {
    userLoginRequest.setEmail("shruthi.mohan@example.com");
    userLoginRequest.setPassword("password123");

    assertThat(userLoginRequest.getEmail()).isEqualTo("shruthi.mohan@example.com");
    assertThat(userLoginRequest.getPassword()).isEqualTo("password123");
  }

  @Test
  void testToString() {
    userLoginRequest.setEmail("shruthi.mohan@example.com");
    userLoginRequest.setPassword("password123");

    String actualString = userLoginRequest.toString();
    String expectedString = "UserLoginRequest(email=shruthi.mohan@example.com, password=password123)";
    assertThat(actualString).isEqualTo(expectedString);
  }

  @Test
  void testHashCode() {
    userLoginRequest.setEmail("shruthi.mohan@example.com");
    userLoginRequest.setPassword("password123");

    int expectedHashCode = userLoginRequest.hashCode();
    assertThat(expectedHashCode).isEqualTo(userLoginRequest.hashCode());
  }

  @Test
  void testEquals() {
    UserLoginRequest request1 = new UserLoginRequest("shruthi.mohan@example.com", "password123");
    UserLoginRequest request2 = new UserLoginRequest("shruthi.mohan@example.com", "password123");

    assertThat(request1).isEqualTo(request2);

  }
}
