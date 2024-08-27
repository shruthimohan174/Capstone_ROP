package com.users.indto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequest {

  @NotNull(message = "Email is required")
  private String email;

  @NotNull(message = "Password is required")
  private String password;
}
