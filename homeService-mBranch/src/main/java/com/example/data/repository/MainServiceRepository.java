package com.example.data.repository;

import com.example.data.entity.MainService;
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
public interface MainServiceRepository extends JpaRepository<MainService, Integer> {

    List<MainService> findAll();

    Optional<MainService> findByName(String name);

    Optional<MainService> findBySubServicesContains(SubService subService);

    Integer deleteByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "update MainService m set m.subServices=:subServices where m.name=:name")
    void updateSubServices(@Param("name") String name,
                           @Param("subServices") Set<SubService> subServices);
}
