package com.users.repositories;

import com.users.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
  public Address findByUserId(Integer userId);
}
