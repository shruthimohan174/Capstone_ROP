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
  @Pattern(
    regexp = "^[a-zA-Z]+$",
    message = "First name must contain only alphabets."
  )
  private String firstName;

  @NotNull(message = "Last name is required")
  @Pattern(
    regexp = "^[a-zA-Z]+$",
    message = "Last name must contain only alphabets."
  )
  private String lastName;

  @Email(message = "Invalid email format.")
  @Pattern(
    regexp = "^[a-zA-Z]+[a-zA-Z0-9._%+-]*@(gmail\\.com|nucleusteq\\.com)$",
    message = "Email must be a valid, @gmail.com or @nucleusteq.com and contain at least one alphabet before the '@' symbol."
  )
  @NotNull(message = "Email is required")
  private String email;

  @NotNull(message = "Password is required")
  @Size(min = 5, message = "Password must be at least 5 characters long")
  @Pattern(
    regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{5,}$",
    message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, and one special character."
  )
  private String password;

  @Size(min = 10, max = 10, message = "Phone number must be exactly 10 digits long.")
  @Pattern(
    regexp = "^[789]\\d{9}$",
    message = "Phone number must start with 7, 8, or 9 and contain exactly 10 digits."
  )
  private String phoneNumber;

  @NotNull(message = "User Role is required")
  private UserRole userRole;
}
