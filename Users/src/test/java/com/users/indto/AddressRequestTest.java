package com.users.indto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressRequestTest {
  private AddressRequest addressRequest;

  @BeforeEach
  void setUp() {
    addressRequest = new AddressRequest();
    addressRequest.setUserId(1);
    addressRequest.setStreet("Plot No 147, Sector 74");
    addressRequest.setCity("Indore");
    addressRequest.setPincode(123456);
    addressRequest.setState("MP");
  }

  @Test
  void testGettersSetters() {
    assertEquals(1, addressRequest.getUserId());
    assertEquals("Plot No 147, Sector 74", addressRequest.getStreet());
    assertEquals("Indore", addressRequest.getCity());
    assertEquals(123456, addressRequest.getPincode());
    assertEquals("MP", addressRequest.getState());
  }

  @Test
  void testToString() {
    String expected = "AddressRequest(street=Plot No 147, Sector 74, city=Indore, state=MP, pincode=123456, userId=1)";
    assertEquals(expected, addressRequest.toString());
  }

  @Test
  void testEquals() {
    AddressRequest anotherAddressRequest = new AddressRequest();
    anotherAddressRequest.setUserId(1);
    anotherAddressRequest.setStreet("Plot No 147, Sector 74");
    anotherAddressRequest.setCity("Indore");
    anotherAddressRequest.setPincode(123456);
    anotherAddressRequest.setState("MP");

    assertEquals(addressRequest, anotherAddressRequest);
  }

  @Test
  void testHashCode() {
    AddressRequest anotherAddressRequest = new AddressRequest();
    anotherAddressRequest.setUserId(1);
    anotherAddressRequest.setStreet("Plot No 147, Sector 74");
    anotherAddressRequest.setCity("Indore");
    anotherAddressRequest.setPincode(123456);
    anotherAddressRequest.setState("MP");

    assertEquals(addressRequest.hashCode(), anotherAddressRequest.hashCode());
  }
}
