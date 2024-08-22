package com.users.outdto;

import com.users.entities.UserRole;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserResponse {

  private String firstName;

  private String lastName;

  private String email;

  private UserRole userRole;
}
