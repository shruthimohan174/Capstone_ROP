package com.users.outdto;

import com.users.entities.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
  private Integer id;
  private String firstName;

  private String lastName;

  private String email;

  private String phoneNumber;

  private UserRole userRole;
  private BigDecimal walletBalance;
}
