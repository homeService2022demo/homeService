package com.example.data.repository;

import com.example.data.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author fh.kazemi
 **/

@Repository
public interface WorkRepository extends JpaRepository<Work, Integer> {
}
