package com.users.indto;

import com.users.entities.UserRole;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserRequest {

  @NotNull(message = "First name is required")
  private String firstName;

  @NotNull(message = "Last name is required")
  private String lastName;

  @Email(message = "Invalid email format")
  @NotNull(message = "Email is required")
  private String email;

  @Size(min=8,message = "Password must be at least 8 characters long")
  private String password;

  @Pattern(regexp = "^[0-9]{10}$", message = "Invalid phone number")
  private String phoneNumber;

  @NotNull(message = "User Role is required")
  private UserRole userRole;
}