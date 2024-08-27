package com.users.outdto;

import lombok.Data;

@Data
public class AddressResponse {

  private Integer id;

  private String street;

  private String city;

  private String state;

  private Integer pincode;

  private Integer userId;

}
