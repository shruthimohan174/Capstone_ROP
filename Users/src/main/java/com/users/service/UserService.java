package com.users.service;

import com.users.entities.User;
import com.users.indto.UpdateUserRequest;
import com.users.indto.UserLoginRequest;
import com.users.indto.UserRequest;
import com.users.outdto.UpdateUserResponse;
import com.users.outdto.UserResponse;

import java.math.BigDecimal;
import java.util.List;

/**
 * Service interface for managing users.
 * <p>
 * This service provides methods for user registration, login, retrieval, update, deletion, and wallet balance management.
 * </p>
 */
public interface UserService {

  /**
   * Registers a new user.
   *
   * @param request the user request DTO containing registration details
   * @return the {@link UserResponse} DTO with details of the registered user
   */
  UserResponse registerUser(UserRequest request);

  /**
   * Logs in a user.
   *
   * @param request the user login request DTO containing login credentials
   * @return the {@link UserResponse} DTO with details of the logged-in user
   */
  UserResponse loginUser(UserLoginRequest request);

  /**
   * Retrieves all users.
   *
   * @return a list of {@link User} entities
   */
  List<User> getAllUsers();

  /**
   * Finds a user by their ID.
   *
   * @param id the ID of the user to find
   * @return the {@link User} entity with the specified ID
   */
  User findUserById(Integer id);

  /**
   * Updates an existing user.
   *
   * @param id      the ID of the user to update
   * @param request the update user request DTO containing updated user details
   * @return the {@link UpdateUserResponse} DTO with details of the updated user
   */
  UpdateUserResponse updateUser(Integer id, UpdateUserRequest request);

  /**
   * Deletes a user by their ID.
   *
   * @param id the ID of the user to delete
   */
  void deleteUser(Integer id);

  /**
   * Updates the wallet balance of a user.
   *
   * @param userId the ID of the user whose wallet balance is to be updated
   * @param amount the amount to be deducted or added to the user's wallet balance
   * @return the {@link UserResponse} DTO with updated user details
   */
  UserResponse updateWalletBalance(Integer userId, BigDecimal amount);
}
