package com.users.outdto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateUserResponseTest {
  private UpdateUserResponse updateUserResponse;

  @BeforeEach
  void setUp() {
    updateUserResponse = new UpdateUserResponse();
    updateUserResponse.setId(1);
    updateUserResponse.setFirstName("Shruthi");
    updateUserResponse.setLastName("Mohan");
    updateUserResponse.setPhoneNumber("8434972888");
  }

  @Test
  void testGettersAndSetters() {
    assertEquals(1, updateUserResponse.getId());
    assertEquals("Shruthi", updateUserResponse.getFirstName());
    assertEquals("Mohan", updateUserResponse.getLastName());
    assertEquals("8434972888", updateUserResponse.getPhoneNumber());
  }

  @Test
  void testToString() {
    String expected = "UpdateUserResponse(id=1, firstName=Shruthi, lastName=Mohan, phoneNumber=8434972888)";
    assertEquals(expected, updateUserResponse.toString());
  }

  @Test
  void testEquals() {
    UpdateUserResponse anotherUpdateUserResponse = new UpdateUserResponse();
    anotherUpdateUserResponse.setId(1);
    anotherUpdateUserResponse.setFirstName("Shruthi");
    anotherUpdateUserResponse.setLastName("Mohan");
    anotherUpdateUserResponse.setPhoneNumber("8434972888");

    assertEquals(updateUserResponse, anotherUpdateUserResponse);
  }

  @Test
  void testHashCode() {
    UpdateUserResponse anotherUpdateUserResponse = new UpdateUserResponse();
    anotherUpdateUserResponse.setId(1);
    anotherUpdateUserResponse.setFirstName("Shruthi");
    anotherUpdateUserResponse.setLastName("Mohan");
    anotherUpdateUserResponse.setPhoneNumber("8434972888");

    assertEquals(updateUserResponse.hashCode(), anotherUpdateUserResponse.hashCode());
  }
}
