package com.example.data.repository;

import com.example.data.entity.Comment;
import com.example.data.entity.Customer;
import com.example.data.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author fh.kazemi
 **/

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Optional<List<Comment>> findAllByOrder(Order order);
    Optional<List<Comment>> findAllByCustomer(Customer customer);
}
