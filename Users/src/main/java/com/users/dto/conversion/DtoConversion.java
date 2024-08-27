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

public final class DtoConversion {

  private DtoConversion() {
    throw new UnsupportedOperationException("Utility class");
  }

  public static User convertUserRequestToUser(UserRequest userRequest) {
    User user = new User();
    user.setFirstName(userRequest.getFirstName());
    user.setLastName(userRequest.getLastName());
    user.setEmail(userRequest.getEmail());
    user.setPhoneNumber(userRequest.getPhoneNumber());
    user.setUserRole(userRequest.getUserRole());
    if (user.getUserRole() == UserRole.CUSTOMER) {
      user.setWalletBalance(BigDecimal.valueOf(1000));
    }
    return user;
  }

  public static UserResponse convertUserToUserResponse(User user) {
    UserResponse userResponse = new UserResponse();
    userResponse.setId(user.getId());
    userResponse.setFirstName(user.getFirstName());
    userResponse.setLastName(user.getLastName());
    userResponse.setEmail(user.getEmail());
    userResponse.setUserRole(user.getUserRole());
    userResponse.setPhoneNumber(user.getPhoneNumber());
    return userResponse;
  }

  public static User convertUpdateUserRequestToUser(User existingUser, UpdateUserRequest request) {
    existingUser.setFirstName(request.getFirstName());
    existingUser.setLastName(request.getLastName());
    existingUser.setPhoneNumber(request.getPhoneNumber());
    return existingUser;
  }

  public static UpdateUserResponse convertUserToUpdateUserResponse(User user) {
    UpdateUserResponse response = new UpdateUserResponse();
    response.setId(user.getId());
    response.setFirstName(user.getFirstName());
    response.setLastName(user.getLastName());
    response.setPhoneNumber(user.getPhoneNumber());
    return response;
  }

  public static Address convertAddressRequestToAddress(AddressRequest request) {
    Address address = new Address();
    address.setStreet(request.getStreet());
    address.setCity(request.getCity());
    address.setState(request.getState());
    address.setUserId(request.getUserId());
    address.setPincode(request.getPincode());
    return address;
  }

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

  public static Address convertUpdateAddressRequestToAddress(AddressRequest request, Address existingAddress) {
    existingAddress.setStreet(request.getStreet());
    existingAddress.setCity(request.getCity());
    existingAddress.setState(request.getState());
    existingAddress.setPincode(request.getPincode());
    return existingAddress;
  }
}
