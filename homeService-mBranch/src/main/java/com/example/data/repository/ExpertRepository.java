package com.example.data.repository;

import com.example.data.entity.Expert;
import com.example.data.entity.SubService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author fh.kazemi
 **/

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Integer> {
    Optional<List<Expert>> findAllBySubServices(SubService subService);

    @Modifying
    @Transactional
    @Query(value = "update Expert set score=:score where  email=:email")
    void updateScore(@Param("email") String email, @Param("score") double score);

    @Modifying
    @Transactional
    @Query(value = "update Expert e set e.subServices=:subServicesList where e.email=:email")
    void updateServiceList(@Param("email") String email, @Param("subServicesList") Set<SubService> subServicesList);
}
