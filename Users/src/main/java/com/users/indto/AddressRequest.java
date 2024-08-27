package com.users.indto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddressRequest {

  @NotNull(message = "Street is required")
  private String street;

  @NotNull(message = "City is required")
  private String city;

  @NotNull(message = "State is required")
  private String state;

  @NotNull(message = "Pincode is required")
  private Integer pincode;

  @NotNull(message = "UserId is required")
  private Integer userId;
}
