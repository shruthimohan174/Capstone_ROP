package com.users.outdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserResponse {
  private Integer id;

  private String firstName;

  private String lastName;

  private String phoneNumber;
}
