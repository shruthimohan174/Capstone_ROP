package com.users.repositories;

import com.users.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
  List<Address> findByUserId(Integer userId);
}
