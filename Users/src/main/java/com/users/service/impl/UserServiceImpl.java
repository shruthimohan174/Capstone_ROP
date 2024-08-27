package com.users.service.impl;

import com.users.constants.UserConstants;
import com.users.dto.conversion.DtoConversion;
import com.users.entities.User;
import com.users.exception.InvalidCredentialsException;
import com.users.exception.UserAlreadyExistsException;
import com.users.exception.UserNotFoundException;
import com.users.indto.UpdateUserRequest;
import com.users.indto.UserLoginRequest;
import com.users.indto.UserRequest;
import com.users.outdto.UpdateUserResponse;
import com.users.outdto.UserResponse;
import com.users.repositories.UserRepository;
import com.users.service.UserService;
import com.users.utils.Base64Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserResponse registerUser(UserRequest userRequest) {
    logger.info("Registering new user with email: {}", userRequest.getEmail());
    Optional<User> emailExists = userRepository.findByEmail(userRequest.getEmail());
    if (emailExists.isPresent()) {
      logger.error("User with email {} already exists", userRequest.getEmail());
      throw new UserAlreadyExistsException(UserConstants.USER_ALREADY_EXISTS);
    }
    User user = DtoConversion.convertUserRequestToUser(userRequest);
    user.setPassword(Base64Utils.encodePassword(userRequest.getPassword()));
    User savedUser = userRepository.save(user);
    logger.info("User registered successfully with ID: {}", savedUser.getId());
    return DtoConversion.convertUserToUserResponse(savedUser);
  }

  @Override
  public UserResponse loginUser(UserLoginRequest userRequest) {
    logger.info("Login for email: {}", userRequest.getEmail());
    Optional<User> user = userRepository.findByEmail(userRequest.getEmail());
    if (!user.isPresent() || !Base64Utils.decodePassword(user.get().getPassword()).equals(userRequest.getPassword())) {
      logger.error("Invalid credentials for email: {}", userRequest.getEmail());
      throw new InvalidCredentialsException(UserConstants.INVALID_CREDENTIALS);
    }
    logger.info("Login successful for email: {}", userRequest.getEmail());
    return DtoConversion.convertUserToUserResponse(user.get());
  }

  @Override
  public List<User> getAllUsers() {
    logger.info("Fetching all users");
    return userRepository.findAll();
  }

  @Override
  public User findUserById(Integer id) {
    logger.info("Finding user by ID: {}", id);
    return userRepository.findById(id).orElseThrow(() -> {
      logger.error("User not found with ID: {}", id);
      return new UserNotFoundException(UserConstants.USER_NOT_FOUND);
    });
  }

  @Override
  public UpdateUserResponse updateUser(Integer id, UpdateUserRequest request) {
    logger.info("Updating user with ID: {}", id);
    User existingUser = findUserById(id);
    DtoConversion.convertUpdateUserRequestToUser(existingUser, request);
    User updatedUser = userRepository.save(existingUser);
    logger.info("User updated successfully with ID: {}", updatedUser.getId());
    return DtoConversion.convertUserToUpdateUserResponse(updatedUser);
  }

  @Override
  public void deleteUser(Integer id) {
    logger.info("Deleting user with ID: {}", id);
    User user = findUserById(id);
    userRepository.delete(user);
    logger.info("User deleted successfully with ID: {}", id);
  }

}
