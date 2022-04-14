package com.example.data.repository;

import com.example.data.entity.Expert;
import com.example.data.entity.Offer;
import com.example.data.entity.Order;
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
public interface OfferRepository extends JpaRepository<Offer, Integer> {
    Optional<List<Offer>> findOffersByOrder(Order order);

    Optional<List<Offer>> findOffersByExpert(Expert expert);

    Optional<List<Offer>> findOffersByOrderAndExpert(Order order, Expert expert);

    @Modifying
    @Transactional
    @Query(value = "update Offer o set o.offerStatus=:status where o.id=:id")
    void updateOfferStatus(@Param("status") String status, @Param("id") Integer id);
}
