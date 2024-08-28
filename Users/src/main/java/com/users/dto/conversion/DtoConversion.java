package com.users.dto.conversion;

import com.users.entities.Address;
import com.users.entities.User;
import com.users.entities.UserRole;
import com.users.indto.AddressRequest;
import com.users.indto.UpdateUserRequest;
import com.users.indto.UserRequest;
import com.users.outdto.AddressResponse;
import com.users.outdto.UpdateUserResponse;
import com.users.outdto.UserResponse;

import java.math.BigDecimal;

/**
 * Utility class for converting between different DTOs and entity objects.
 * <p>
 * This class provides static methods to convert between user and address related
 * DTOs and entities. The class is final and has a private constructor to prevent
 * instantiation.
 * </p>
 */
public final class DtoConversion {

  private DtoConversion() {
    throw new UnsupportedOperationException("Utility class");
  }

  /**
   * Converts a {@link UserRequest} to a {@link User} entity.
   * <p>
   * Initializes the wallet balance to 1000.00 if the user role is CUSTOMER.
   * </p>
   *
   * @param userRequest the user request DTO to convert
   * @return the corresponding {@link User} entity
   */
  public static User convertUserRequestToUser(UserRequest userRequest) {
    User user = new User();
    user.setFirstName(userRequest.getFirstName());
    user.setLastName(userRequest.getLastName());
    user.setEmail(userRequest.getEmail());
    user.setPhoneNumber(userRequest.getPhoneNumber());
    user.setUserRole(userRequest.getUserRole());
    if (user.getUserRole() == UserRole.CUSTOMER) {
      user.setWalletBalance(BigDecimal.valueOf(1000.00));
    }
    return user;
  }

  /**
   * Converts a {@link User} entity to a {@link UserResponse} DTO.
   *
   * @param user the user entity to convert
   * @return the corresponding {@link UserResponse} DTO
   */
  public static UserResponse convertUserToUserResponse(User user) {
    UserResponse userResponse = new UserResponse();
    userResponse.setId(user.getId());
    userResponse.setFirstName(user.getFirstName());
    userResponse.setLastName(user.getLastName());
    userResponse.setEmail(user.getEmail());
    userResponse.setUserRole(user.getUserRole());
    userResponse.setPhoneNumber(user.getPhoneNumber());
    userResponse.setWalletBalance(user.getWalletBalance());
    return userResponse;
  }

  /**
   * Updates an existing {@link User} entity with details from an {@link UpdateUserRequest}.
   *
   * @param existingUser the existing user entity to update
   * @param request      the update user request DTO containing new details
   * @return the updated {@link User} entity
   */
  public static User convertUpdateUserRequestToUser(User existingUser, UpdateUserRequest request) {
    existingUser.setFirstName(request.getFirstName());
    existingUser.setLastName(request.getLastName());
    existingUser.setPhoneNumber(request.getPhoneNumber());
    return existingUser;
  }

  /**
   * Converts a {@link User} entity to an {@link UpdateUserResponse} DTO.
   *
   * @param user the user entity to convert
   * @return the corresponding {@link UpdateUserResponse} DTO
   */
  public static UpdateUserResponse convertUserToUpdateUserResponse(User user) {
    UpdateUserResponse response = new UpdateUserResponse();
    response.setId(user.getId());
    response.setFirstName(user.getFirstName());
    response.setLastName(user.getLastName());
    response.setPhoneNumber(user.getPhoneNumber());
    return response;
  }

  /**
   * Converts an {@link AddressRequest} to an {@link Address} entity.
   *
   * @param request the address request DTO to convert
   * @return the corresponding {@link Address} entity
   */
  public static Address convertAddressRequestToAddress(AddressRequest request) {
    Address address = new Address();
    address.setStreet(request.getStreet());
    address.setCity(request.getCity());
    address.setState(request.getState());
    address.setUserId(request.getUserId());
    address.setPincode(request.getPincode());
    return address;
  }

  /**
   * Converts an {@link Address} entity to an {@link AddressResponse} DTO.
   *
   * @param address the address entity to convert
   * @return the corresponding {@link AddressResponse} DTO
   */
  public static AddressResponse convertAddressToAddressResponse(Address address) {
    AddressResponse addressResponse = new AddressResponse();
    addressResponse.setId(address.getId());
    addressResponse.setStreet(address.getStreet());
    addressResponse.setCity(address.getCity());
    addressResponse.setState(address.getState());
    addressResponse.setUserId(address.getUserId());
    addressResponse.setPincode(address.getPincode());
    return addressResponse;
  }

  /**
   * Updates an existing {@link Address} entity with details from an {@link AddressRequest}.
   *
   * @param request the address request DTO containing new details
   * @param existingAddress the existing address entity to update
   * @return the updated {@link Address} entity
   */
  public static Address convertUpdateAddressRequestToAddress(AddressRequest request, Address existingAddress) {
    existingAddress.setStreet(request.getStreet());
    existingAddress.setCity(request.getCity());
    existingAddress.setState(request.getState());
    existingAddress.setPincode(request.getPincode());
    return existingAddress;
  }
}
