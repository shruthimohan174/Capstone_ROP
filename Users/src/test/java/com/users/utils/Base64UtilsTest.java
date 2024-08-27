package com.users.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Base64UtilsTest {

  @Test
  void testEncodePassword() {
    String password = "Password@123";
    String encodedPassword = Base64Utils.encodePassword(password);
    String expectedEncodedPassword = "UGFzc3dvcmRAMTIz";

    assertEquals(expectedEncodedPassword, encodedPassword);
  }

  @Test
  void testDecodePassword() {
    String encodedPassword = "UGFzc3dvcmRAMTIz";
    String decodedPassword = Base64Utils.decodePassword(encodedPassword);
    String expectedDecodedPassword = "Password@123";

    assertEquals(expectedDecodedPassword, decodedPassword);
  }
}
