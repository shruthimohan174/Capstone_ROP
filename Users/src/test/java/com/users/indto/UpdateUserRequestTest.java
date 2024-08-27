package com.users.indto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdateUserRequestTest {

  private UpdateUserRequest updateUserRequest;

  @BeforeEach
  void setUp() {
    updateUserRequest = new UpdateUserRequest();
  }

  @Test
  void testSettersAndGetters() {
    updateUserRequest.setFirstName("Shruthi");
    updateUserRequest.setLastName("Mohan");
    updateUserRequest.setPhoneNumber("8434972888");

    assertThat(updateUserRequest.getFirstName()).isEqualTo("Shruthi");
    assertThat(updateUserRequest.getLastName()).isEqualTo("Mohan");
    assertThat(updateUserRequest.getPhoneNumber()).isEqualTo("8434972888");
  }

  @Test
  void testToString() {
    updateUserRequest.setFirstName("Shruthi");
    updateUserRequest.setLastName("Mohan");
    updateUserRequest.setPhoneNumber("8434972888");

    String actualString = updateUserRequest.toString();
    String expectedString = "UpdateUserRequest(firstName=Shruthi, lastName=Mohan, phoneNumber=8434972888)";
    assertThat(actualString).isEqualTo(expectedString);
  }

  @Test
  void testHashCode() {
    updateUserRequest.setFirstName("Shruthi");
    updateUserRequest.setLastName("Mohan");
    updateUserRequest.setPhoneNumber("8434972888");

    int expectedHashCode = updateUserRequest.hashCode();
    assertThat(expectedHashCode).isEqualTo(updateUserRequest.hashCode());
  }

  @Test
  void testEquals() {
    UpdateUserRequest request1 = new UpdateUserRequest();
    request1.setFirstName("Shruthi");
    request1.setLastName("Mohan");
    request1.setPhoneNumber("8434972888");

    UpdateUserRequest request2 = new UpdateUserRequest();
    request2.setFirstName("Shruthi");
    request2.setLastName("Mohan");
    request2.setPhoneNumber("8434972888");

    assertThat(request1).isEqualTo(request2);

  }
}
