package com.example.data.repository;

import com.example.data.entity.Comment;
import com.example.data.entity.Customer;
import com.example.data.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author fh.kazemi
 **/

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByOrdersContains(Order order);
}
