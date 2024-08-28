package com.users.service;

import com.users.entities.Address;
import com.users.indto.AddressRequest;
import com.users.outdto.AddressResponse;

import java.util.List;

/**
 * Service interface for managing addresses.
 * <p>
 * This service provides methods for adding, retrieving, updating, and deleting addresses.
 * </p>
 */
public interface AddressService {

  /**
   * Adds a new address.
   *
   * @param request the address request DTO containing the address details
   * @return the {@link AddressResponse} DTO with details of the added address
   */
  AddressResponse addAddress(AddressRequest request);

  /**
   * Retrieves all addresses.
   *
   * @return a list of {@link Address} entities
   */
  List<Address> getAllAddress();

  /**
   * Retrieves all addresses associated with a specific user ID.
   *
   * @param userId the ID of the user whose addresses are to be retrieved
   * @return a list of {@link Address} entities for the specified user ID
   */
  List<Address> getAddressByUserId(Integer userId);

  /**
   * Updates an existing address.
   *
   * @param id      the ID of the address to update
   * @param request the address request DTO containing updated address details
   * @return the {@link AddressResponse} DTO with details of the updated address
   */
  AddressResponse updateAddress(Integer id, AddressRequest request);

  /**
   * Deletes an address by its ID.
   *
   * @param id the ID of the address to delete
   */
  void deleteAdderess(Integer id);

  /**
   * Finds an address by its ID.
   *
   * @param id the ID of the address to find
   * @return the {@link Address} entity with the specified ID
   */
  Address findAddressById(Integer id);
}
