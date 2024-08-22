package com.users.dtoConversion;

import com.users.entities.User;
import com.users.entities.UserRole;
import com.users.indto.UserRequest;
import com.users.outdto.UserResponse;
import com.users.utils.Base64Utils;

import java.math.BigDecimal;

public class DtoConversion {

  public static User convertUserRequestToUser(UserRequest userRequest){
    User user=new User();
    user.setFirstName(userRequest.getFirstName());
    user.setLastName(userRequest.getLastName());
    user.setEmail(userRequest.getEmail());
    user.setPassword(Base64Utils.encodePassword(userRequest.getPassword()));
    user.setPhoneNumber(userRequest.getPhoneNumber());
    user.setUserRole(userRequest.getUserRole());
    if(user.getUserRole()== UserRole.CUSTOMER) {
      user.setWalletBalance(BigDecimal.valueOf(1000));
    }
    return user;
  }

  public static UserResponse convertUserToUserResponse(User user){
    UserResponse userResponse=new UserResponse();
    userResponse.setFirstName(user.getFirstName());
    userResponse.setLastName(user.getLastName());
    userResponse.setEmail(user.getEmail());
    userResponse.setUserRole(user.getUserRole());
    return userResponse;
  }
}
