package com.example.data.repository;

import com.example.data.entity.Customer;
import com.example.data.entity.Order;
import com.example.data.entity.SubService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author fh.kazemi
 **/

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Optional<List<Order>> findOrderBySubService(SubService subService);

    Optional<List<Order>> findOrdersByCustomer(Customer customer);

    @Modifying
    @Transactional
    @Query(value = "update Order o set o.orderstatus=:status where o.id=:id")
    void updateOrderStatus(@Param("status") String status, @Param("id") Integer id);
}
