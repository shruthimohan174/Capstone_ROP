package com.users.service;

import com.users.entities.User;
import com.users.indto.UserLoginRequest;
import com.users.indto.UserRequest;
import com.users.outdto.UserResponse;

import java.util.List;

public interface UserService {
  public UserResponse registerUser(UserRequest request);

  public UserResponse loginUser(UserLoginRequest request);

  public List<User> getAllUsers();
  public User findUserById(Integer id);
  public UserResponse updateUser(Integer id,UserRequest request);
  public void deleteUser(Integer id);
}
