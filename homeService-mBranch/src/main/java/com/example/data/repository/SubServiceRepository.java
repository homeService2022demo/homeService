package com.example.data.repository;

import com.example.data.entity.Expert;
import com.example.data.entity.MainService;
import com.example.data.entity.SubService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author fh.kazemi
 **/

@Repository
public interface SubServiceRepository extends JpaRepository<SubService, Integer> {

    Optional<SubService> findByName(String name);

    @Query(value = "from MainService inner join SubService s on s.name=:name")
    Optional<MainService> findMainService(@Param("name")String name);

    @Query(value = "select e.subServices from Expert e where e.id=:id")
    Optional<List<SubService>> findAllSunServicesOfOneExpert(@Param("id") Integer id);
}
