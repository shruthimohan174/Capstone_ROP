package com.users.controller;

import com.users.entities.User;
import com.users.indto.UserLoginRequest;
import com.users.indto.UserRequest;
import com.users.outdto.UserResponse;
import com.users.service.UserService;
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

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public ResponseEntity<UserResponse>registerUser(@Valid @RequestBody UserRequest userRequest){
    UserResponse userResponse=userService.registerUser(userRequest);
    return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
  }

  @PostMapping("/login")
  public ResponseEntity<UserResponse>loginUser(@RequestBody UserLoginRequest userRequest){
    UserResponse userResponse=userService.loginUser(userRequest);
    return new ResponseEntity<>(userResponse, HttpStatus.OK);
  }

  @GetMapping("")
  public ResponseEntity<List<User>>getAllUsers(){
    List<User> userList=userService.getAllUsers();
    return new ResponseEntity<>(userList, HttpStatus.OK);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<UserResponse>updateUser(@PathVariable Integer id,@Valid @RequestBody UserRequest userRequest){
    UserResponse userResponse=userService.updateUser(id,userRequest);
    return new ResponseEntity<>(userResponse, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void>deleteUser(@PathVariable Integer id){
    userService.deleteUser(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}