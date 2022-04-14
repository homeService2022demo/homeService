package com.example.data.repository;

import com.example.data.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author fh.kazemi
 **/

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "from Order o where o.customer.id=:id")
    Optional<Customer> findCustomerByOrder(@Param("id")Integer id);

    @Query(value = "from Comment c inner join Order o on c.order.id=o.id " +
            "inner join Customer cu on o.customer.id=cu.id and c.id=:id")
    Optional<Customer> findCustomerByComment(@Param("id")Integer id);
}
