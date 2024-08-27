package com.users.indto;

import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UpdateUserRequest {

  private String firstName;

  private String lastName;

  @Size(min = 10, max = 10, message = "Phone number must be exactly 10 digits long.")
  @Pattern(regexp = "\\d+", message = "Phone number must contain only numbers.")
  private String phoneNumber;
}
