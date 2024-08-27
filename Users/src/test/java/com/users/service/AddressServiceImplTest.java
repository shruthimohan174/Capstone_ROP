package com.users.service;

import com.users.constants.UserConstants;
import com.users.entities.Address;
import com.users.exception.AddressNotFoundException;
import com.users.indto.AddressRequest;
import com.users.outdto.AddressResponse;
import com.users.repositories.AddressRepository;
import com.users.service.impl.AddressServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressServiceImplTest {
  @InjectMocks
  private AddressServiceImpl addressService;

  @Mock
  private AddressRepository addressRepository;

  private Address address;
  private AddressRequest addressRequest;
  private AddressResponse addressResponse;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

    addressRequest = new AddressRequest();
    addressRequest.setUserId(1);
    addressRequest.setStreet("Plot No 147, Sector 74");
    addressRequest.setCity("Indore");
    addressRequest.setPincode(123456);

    addressResponse = new AddressResponse();
    addressResponse.setId(1);
    addressResponse.setUserId(1);
    addressResponse.setStreet("Plot No 147, Sector 74");
    addressResponse.setCity("Indore");
    addressResponse.setPincode(123456);

    address = new Address();
    address.setId(1);
    address.setUserId(1);
    address.setStreet("Plot No 147, Sector 74");
    address.setCity("Indore");
    address.setPincode(123456);
  }

  @Test
  void addAddressTest() {
    when(addressRepository.save(any(Address.class))).thenReturn(address);

    AddressResponse response = addressService.addAddress(addressRequest);

    assertEquals(addressResponse.getId(), response.getId());
    assertEquals(addressResponse.getUserId(), response.getUserId());
    assertEquals(addressResponse.getStreet(), response.getStreet());
    assertEquals(addressResponse.getCity(), response.getCity());
    assertEquals(addressResponse.getState(), response.getState());
    assertEquals(addressResponse.getPincode(), response.getPincode());
  }

  @Test
  void getAllAddressTest() {
    when(addressRepository.findAll()).thenReturn(Collections.singletonList(address));

    List<Address> addresses = addressService.getAllAddress();

    assertNotNull(addresses);
    assertFalse(addresses.isEmpty());
    assertEquals(1, addresses.size());
    assertEquals(address.getId(), addresses.get(0).getId());
  }

  @Test
  void getAddressByUserIdTest() {
    when(addressRepository.findByUserId(anyInt())).thenReturn(Collections.singletonList(address));

    List<Address> addresses = addressService.getAddressByUserId(1);

    assertNotNull(addresses);
    assertFalse(addresses.isEmpty());
    assertEquals(1, addresses.size());
    assertEquals(address.getId(), addresses.get(0).getId());
  }

  @Test
  void updateAddressTest() {
    when(addressRepository.findById(anyInt())).thenReturn(Optional.of(address));
    when(addressRepository.save(any(Address.class))).thenReturn(address);

    AddressResponse response = addressService.updateAddress(1, addressRequest);

    assertEquals(addressResponse.getId(), response.getId());
    assertEquals(addressResponse.getUserId(), response.getUserId());
    assertEquals(addressResponse.getStreet(), response.getStreet());
    assertEquals(addressResponse.getCity(), response.getCity());
    assertEquals(addressResponse.getState(), response.getState());
    assertEquals(addressResponse.getPincode(), response.getPincode());
  }

  @Test
  void deleteAddressTest() {
    when(addressRepository.findById(anyInt())).thenReturn(Optional.of(address));

    addressService.deleteAdderess(1);

    verify(addressRepository, times(1)).delete(address);
  }

  @Test
  void findAddressByIdTest() {
    when(addressRepository.findById(anyInt())).thenReturn(Optional.of(address));
    Address result = addressService.findAddressById(1);
    assertNotNull(result);
    assertEquals(1, result.getId());
    assertEquals("Plot No 147, Sector 74", result.getStreet());
    assertEquals("Indore", result.getCity());
    assertEquals(123456, result.getPincode());
  }

  @Test
  void findAddressByIdAddressNotFoundTest() {
    when(addressRepository.findById(anyInt())).thenReturn(Optional.empty());
    AddressNotFoundException exception = assertThrows(AddressNotFoundException.class, () -> {
      addressService.findAddressById(1);
    });
    assertEquals(UserConstants.ADDRESS_NOT_FOUND, exception.getMessage());
  }
}
