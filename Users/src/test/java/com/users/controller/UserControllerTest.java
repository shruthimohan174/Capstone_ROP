package com.users.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.users.entities.User;
import com.users.entities.UserRole;
import com.users.indto.UpdateUserRequest;
import com.users.indto.UserLoginRequest;
import com.users.indto.UserRequest;
import com.users.outdto.UpdateUserResponse;
import com.users.outdto.UserResponse;
import com.users.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

  @InjectMocks
  private UserController userController;

  @Mock
  private UserService userService;

  private MockMvc mockMvc;
  private ObjectMapper objectMapper;

  private UserRequest userRequest;
  private UserLoginRequest userLoginRequest;
  private UserResponse userResponse;
  private User user;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    objectMapper = new ObjectMapper();

    userRequest = new UserRequest();
    userRequest.setFirstName("Shruthi");
    userRequest.setLastName("Mohan");
    userRequest.setEmail("shruthimohan1708@gmail.com");
    userRequest.setPassword("Pass123!");
    userRequest.setPhoneNumber("8434972888");
    userRequest.setUserRole(UserRole.RESTAURANT_OWNER);

    userLoginRequest = new UserLoginRequest();
    userLoginRequest.setEmail("shruthimohan1708@gmail.com");
    userLoginRequest.setPassword("Pass123!");

    userResponse = new UserResponse(1, "Shruthi", "Mohan", "shruthimohan1708@gmail.com", "8434972888", UserRole.RESTAURANT_OWNER,null);

    user = new User();
    user.setId(1);
    user.setFirstName("Shruthi");
    user.setLastName("Mohan");
    user.setEmail("shruthimohan1708@gmail.com");
    user.setPhoneNumber("8434972888");
    user.setUserRole(UserRole.RESTAURANT_OWNER);
  }

  @Test
  void loginUserTests() throws Exception {
    when(userService.loginUser(any(UserLoginRequest.class))).thenReturn(userResponse);

    mockMvc.perform(post("/user/login")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(userLoginRequest)))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.id").value(1))
      .andExpect(jsonPath("$.firstName").value("Shruthi"))
      .andExpect(jsonPath("$.lastName").value("Mohan"))
      .andExpect(jsonPath("$.email").value("shruthimohan1708@gmail.com"))
      .andExpect(jsonPath("$.phoneNumber").value("8434972888"))
      .andExpect(jsonPath("$.userRole").value("RESTAURANT_OWNER"));
  }

  @Test
  void getAllUsersTests() throws Exception {
    when(userService.getAllUsers()).thenReturn(Collections.singletonList(user));

    mockMvc.perform(get("/user"))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$[0].id").value(1))
      .andExpect(jsonPath("$[0].firstName").value("Shruthi"))
      .andExpect(jsonPath("$[0].lastName").value("Mohan"))
      .andExpect(jsonPath("$[0].email").value("shruthimohan1708@gmail.com"))
      .andExpect(jsonPath("$[0].phoneNumber").value("8434972888"))
      .andExpect(jsonPath("$[0].userRole").value("RESTAURANT_OWNER"));
  }

  @Test
  void registerUser() throws Exception {
    when(userService.registerUser(any(UserRequest.class))).thenReturn(userResponse);

    ResponseEntity<UserResponse> response = userController.registerUser(userRequest);

    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals(userResponse, response.getBody());
  }

  @Test
  void updateUserTests() throws Exception {
    UpdateUserRequest updateUserRequest = new UpdateUserRequest();
    updateUserRequest.setFirstName("Shruthi");
    updateUserRequest.setLastName("Mohan");
    updateUserRequest.setPhoneNumber("8434972888");

    UpdateUserResponse updateUserResponse = new UpdateUserResponse(1, "Shruthi", "Mohan", "8434972888");

    when(userService.updateUser(eq(1), any(UpdateUserRequest.class))).thenReturn(updateUserResponse);

    mockMvc.perform(put("/user/update/{id}", 1)
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(updateUserRequest)))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.id").value(1))
      .andExpect(jsonPath("$.firstName").value("Shruthi"))
      .andExpect(jsonPath("$.lastName").value("Mohan"))
      .andExpect(jsonPath("$.phoneNumber").value("8434972888"));
  }

  @Test
  void deleteUserTests() throws Exception {
    doNothing().when(userService).deleteUser(1);

    mockMvc.perform(delete("/user/delete/{id}", 1))
      .andExpect(status().isNoContent());
  }

  @Test
  void getByUserIdTests() throws Exception {
    when(userService.findUserById(1)).thenReturn(user);

    mockMvc.perform(get("/user/{id}", 1))
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath("$.id").value(1))
      .andExpect(jsonPath("$.firstName").value("Shruthi"))
      .andExpect(jsonPath("$.lastName").value("Mohan"))
      .andExpect(jsonPath("$.email").value("shruthimohan1708@gmail.com"))
      .andExpect(jsonPath("$.phoneNumber").value("8434972888"))
      .andExpect(jsonPath("$.userRole").value("RESTAURANT_OWNER"));
  }
}
