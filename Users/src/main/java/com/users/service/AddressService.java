package com.users.service;

import com.users.entities.Address;
import com.users.indto.AddressRequest;
import com.users.outdto.AddressResponse;

import java.util.List;

public interface AddressService {

  AddressResponse addAddress(AddressRequest request);

  List<Address> getAllAddress();

  List<Address> getAddressByUserId(Integer userId);

  AddressResponse updateAddress(Integer id, AddressRequest request);

  void deleteAdderess(Integer id);

  Address findAddressById(Integer id);
}
