package com.example.data.repository;

import com.example.data.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author fh.kazemi
 **/

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Optional<Address> findByZipcode(String zipCode);
}
