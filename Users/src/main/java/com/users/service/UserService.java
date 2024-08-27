package com.users.service;

import com.users.entities.User;
import com.users.indto.UpdateUserRequest;
import com.users.indto.UserLoginRequest;
import com.users.indto.UserRequest;
import com.users.outdto.UpdateUserResponse;
import com.users.outdto.UserResponse;

import java.util.List;

public interface UserService {
  UserResponse registerUser(UserRequest request);

  UserResponse loginUser(UserLoginRequest request);

  List<User> getAllUsers();

  User findUserById(Integer id);

  UpdateUserResponse updateUser(Integer id, UpdateUserRequest request);

  void deleteUser(Integer id);

//  UserResponse findUserByEmail(String email);
}
