package com.users.indto;

import com.users.entities.UserRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRequestTest {

  private UserRequest userRequest;

  @BeforeEach
  void setUp() {
    userRequest = new UserRequest();
  }

  @Test
  void testSettersAndGetters() {
    userRequest.setFirstName("Shruthi");
    userRequest.setLastName("Mohan");
    userRequest.setEmail("shruthi.mohan@example.com");
    userRequest.setPassword("Password1@");
    userRequest.setPhoneNumber("8434972888");
    userRequest.setUserRole(UserRole.CUSTOMER);

    assertThat(userRequest.getFirstName()).isEqualTo("Shruthi");
    assertThat(userRequest.getLastName()).isEqualTo("Mohan");
    assertThat(userRequest.getEmail()).isEqualTo("shruthi.mohan@example.com");
    assertThat(userRequest.getPassword()).isEqualTo("Password1@");
    assertThat(userRequest.getPhoneNumber()).isEqualTo("8434972888");
    assertThat(userRequest.getUserRole()).isEqualTo(UserRole.CUSTOMER);
  }

  @Test
  void testToString() {
    userRequest.setFirstName("Shruthi");
    userRequest.setLastName("Mohan");
    userRequest.setEmail("shruthi.mohan@example.com");
    userRequest.setPassword("Password1@");
    userRequest.setPhoneNumber("8434972888");
    userRequest.setUserRole(UserRole.CUSTOMER);

    String actualString = userRequest.toString();
    String expectedString = "UserRequest(firstName=Shruthi, lastName=Mohan, email=shruthi.mohan@example.com, " +
      "password=Password1@, phoneNumber=8434972888, userRole=CUSTOMER)";
    assertThat(actualString).isEqualTo(expectedString);
  }

  @Test
  void testHashCode() {
    userRequest.setFirstName("Shruthi");
    userRequest.setLastName("Mohan");
    userRequest.setEmail("shruthi.mohan@example.com");
    userRequest.setPassword("Password1@");
    userRequest.setPhoneNumber("8434972888");
    userRequest.setUserRole(UserRole.CUSTOMER);

    int expectedHashCode = userRequest.hashCode();
    assertThat(expectedHashCode).isEqualTo(userRequest.hashCode());
  }

  @Test
  void testEquals() {
    UserRequest request1 = new UserRequest();
    request1.setFirstName("Shruthi");
    request1.setLastName("Mohan");
    request1.setEmail("shruthi.mohan@example.com");
    request1.setPassword("Password1@");
    request1.setPhoneNumber("8434972888");
    request1.setUserRole(UserRole.CUSTOMER);

    UserRequest request2 = new UserRequest();
    request2.setFirstName("Shruthi");
    request2.setLastName("Mohan");
    request2.setEmail("shruthi.mohan@example.com");
    request2.setPassword("Password1@");
    request2.setPhoneNumber("8434972888");
    request2.setUserRole(UserRole.CUSTOMER);

    assertThat(request1).isEqualTo(request2);

  }
}
