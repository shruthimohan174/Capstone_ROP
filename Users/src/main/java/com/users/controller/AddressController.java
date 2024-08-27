package com.users.controller;

import com.users.entities.Address;
import com.users.indto.AddressRequest;
import com.users.outdto.AddressResponse;
import com.users.service.AddressService;
import com.users.service.impl.AddressServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

  private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

  @Autowired
  private AddressService addressService;

  @PostMapping("/add")
  public ResponseEntity<AddressResponse> addAddress(@RequestBody AddressRequest addressRequest) {
    logger.info("Adding new address for user ID: {}", addressRequest.getUserId());

    AddressResponse response = addressService.addAddress(addressRequest);
    logger.info("Address added successfully for user ID: {}", addressRequest.getUserId());

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @PutMapping("/update/{id}")
  public ResponseEntity<AddressResponse> updateAddress(@RequestBody AddressRequest addressRequest, @PathVariable Integer id) {
    logger.info("Updating address with ID: {}", id);

    AddressResponse response = addressService.updateAddress(id, addressRequest);
    logger.info("Address updated successfully with ID: {}", id);

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Void> deleteAddress(@PathVariable Integer id) {
    logger.info("Deleting address with ID: {}", id);

    addressService.deleteAdderess(id);
    logger.info("Address deleted successfully with ID: {}", id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping
  public ResponseEntity<List<Address>> getAllAddresses() {
    logger.info("Fetching all addresses");

    List<Address> addressList = addressService.getAllAddress();
    return new ResponseEntity<>(addressList, HttpStatus.OK);
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<List<Address>> findAddressesByUserId(@PathVariable Integer userId) {
    logger.info("Fetching addresses for user ID: {}", userId);

    List<Address> addressList = addressService.getAddressByUserId(userId);
    logger.info("Retrieved {} addresses for user ID: {}", addressList.size(), userId);

    return new ResponseEntity<>(addressList, HttpStatus.OK);
  }
}
