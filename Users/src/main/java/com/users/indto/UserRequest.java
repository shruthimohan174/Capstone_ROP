package com.users.indto;

import com.users.entities.UserRole;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserRequest {

  @NotNull(message = "First name is required")
  private String firstName;

  @NotNull(message = "Last name is required")
  private String lastName;

  @Email(message = "Invalid email format. Email should be in the format 'username@domain.com' and contain an '@' symbol")
  @NotNull(message = "Email is required")
  private String email;

  @NotNull(message = "Password is required")
  @Size(min = 5, message = "Password must be at least 5 characters long")
  @Pattern(
    regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{5,}$",
    message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, one special character"
  )
  private String password;

  @Size(min = 10, max = 10, message = "Phone number must be exactly 10 digits long.")
  @Pattern(regexp = "\\d+", message = "Phone number must contain only numbers.")
  private String phoneNumber;

  @NotNull(message = "User Role is required")
  private UserRole userRole;
}
