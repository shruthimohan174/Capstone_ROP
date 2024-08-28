package com.users.service.impl;

import com.users.constants.UserConstants;
import com.users.dto.conversion.DtoConversion;
import com.users.entities.Address;
import com.users.exception.AddressNotFoundException;
import com.users.indto.AddressRequest;
import com.users.outdto.AddressResponse;
import com.users.repositories.AddressRepository;
import com.users.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the {@link AddressService} interface.
 * <p>
 * This service provides methods for managing addresses and interacting with the underlying
 * data repository.
 * </p>
 */
@Service
public class AddressServiceImpl implements AddressService {
  private static final Logger logger = LoggerFactory.getLogger(AddressServiceImpl.class);

  @Autowired
  private AddressRepository addressRepository;

  @Override
  public AddressResponse addAddress(AddressRequest request) {
    logger.info("Adding new address for user ID: {}", request.getUserId());
    Address address = DtoConversion.convertAddressRequestToAddress(request);
    Address saved = addressRepository.save(address);
    logger.info("Address added successfully with ID: {}", saved.getId());
    return DtoConversion.convertAddressToAddressResponse(saved);
  }

  @Override
  public List<Address> getAllAddress() {
    logger.info("Fetching all addresses");
    return addressRepository.findAll();
  }

  @Override
  public List<Address> getAddressByUserId(Integer userId) {
    logger.info("Fetching addresses for user ID: {}", userId);
    return addressRepository.findByUserId(userId);
  }

  @Override
  public AddressResponse updateAddress(Integer id, AddressRequest request) {
    logger.info("Updating address with ID: {}", id);
    Address existingAddress = findAddressById(id);
    DtoConversion.convertUpdateAddressRequestToAddress(request, existingAddress);
    Address updatedAddress = addressRepository.save(existingAddress);
    logger.info("Address updated successfully with ID: {}", updatedAddress.getId());
    return DtoConversion.convertAddressToAddressResponse(updatedAddress);
  }

  @Override
  public void deleteAdderess(Integer id) {
    logger.info("Deleting address with ID: {}", id);
    Address address = findAddressById(id);
    addressRepository.delete(address);
    logger.info("Address deleted successfully with ID: {}", id);
  }

  @Override
  public Address findAddressById(Integer id) {
    logger.info("Finding address by ID: {}", id);
    return addressRepository.findById(id)
      .orElseThrow(() -> {
        logger.error("Address not found with ID: {}", id);
        return new AddressNotFoundException(UserConstants.ADDRESS_NOT_FOUND);
      });
  }
}
