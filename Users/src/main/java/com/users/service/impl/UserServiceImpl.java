package com.users.service.impl;

import com.users.constants.UserConstants;
import com.users.dtoConversion.DtoConversion;
import com.users.entities.User;
import com.users.exception.InvalidCredentialsException;
import com.users.exception.UserAlreadyExistsException;
import com.users.indto.UserRequest;
import com.users.indto.UserLoginRequest;
import com.users.outdto.UserResponse;
import com.users.repositories.UserRepository;
import com.users.service.UserService;
import com.users.utils.Base64Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserResponse registerUser(UserRequest userRequest) {
    Optional<User> emailExists = userRepository.findByEmail(userRequest.getEmail());
    if (emailExists.isPresent()) {
      throw new UserAlreadyExistsException(UserConstants.USER_ALREADY_EXISTS);
    }
    User user = DtoConversion.convertUserRequestToUser(userRequest);
    User savedUser = userRepository.save(user);
    return DtoConversion.convertUserToUserResponse(savedUser);
  }

  @Override
  public UserResponse loginUser(UserLoginRequest userRequest) {
    Optional<User> user=userRepository.findByEmail(userRequest.getEmail());
    if(!user.isPresent() || !Base64Utils.decodePassword(user.get().getPassword()).equals(userRequest.getPassword())){
      throw  new InvalidCredentialsException(UserConstants.INVALID_CREDENTIALS);
    }
    return DtoConversion.convertUserToUserResponse(user.get());
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public User findUserById(Integer id) {
    return userRepository.findById(id).get();
  }

  @Override
  public UserResponse updateUser(Integer id, UserRequest request) {
    User user=findUserById(id);
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setPhoneNumber(request.getPhoneNumber());
    User updatedUser=userRepository.save(user);
     return DtoConversion.convertUserToUserResponse(updatedUser);
  }

  @Override
  public void deleteUser(Integer id) {
    User user=findUserById(id);
    userRepository.delete(user);
  }
}
