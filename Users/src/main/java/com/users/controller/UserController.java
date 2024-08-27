package com.users.controller;

import com.users.dto.conversion.DtoConversion;
import com.users.entities.User;
import com.users.indto.UpdateUserRequest;
import com.users.indto.UserLoginRequest;
import com.users.indto.UserRequest;
import com.users.outdto.UpdateUserResponse;
import com.users.outdto.UserResponse;
import com.users.service.UserService;
import com.users.service.impl.AddressServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
  private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserRequest userRequest) {
    logger.info("Registering user with email: {}", userRequest.getEmail());
    UserResponse userResponse = userService.registerUser(userRequest);
    logger.info("User registered successfully with email: {}", userRequest.getEmail());
    return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
  }

  @PostMapping("/login")
  public ResponseEntity<UserResponse> loginUser(@RequestBody UserLoginRequest userRequest) {
    logger.info("Logging in user with email: {}", userRequest.getEmail());
    UserResponse userResponse = userService.loginUser(userRequest);
    logger.info("User logged in successfully with email: {}", userRequest.getEmail());
    return new ResponseEntity<>(userResponse, HttpStatus.OK);
  }

  @GetMapping("")
  public ResponseEntity<List<User>> getAllUsers() {
    logger.info("Fetching all users");
    List<User> userList = userService.getAllUsers();
    return new ResponseEntity<>(userList, HttpStatus.OK);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<UpdateUserResponse> updateUser(@PathVariable Integer id, @Valid @RequestBody UpdateUserRequest request) {
    logger.info("Updating user with ID: {}", id);
    UpdateUserResponse userResponse = userService.updateUser(id, request);
    logger.info("User updated successfully with ID: {}", id);
    return new ResponseEntity<>(userResponse, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
    logger.info("Deleting user with ID: {}", id);
    userService.deleteUser(id);
    logger.info("User deleted successfully with ID: {}", id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponse> getByUserId(@PathVariable Integer id) {
    logger.info("Fetching user details with id: {}", id);
    User user = userService.findUserById(id);
    UserResponse userResponse = DtoConversion.convertUserToUserResponse(user);
    return new ResponseEntity<>(userResponse, HttpStatus.OK);
  }

}
