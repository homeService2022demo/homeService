package com.example.data.repository;

import com.example.data.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author fh.kazemi
 **/

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findAdminById(Integer id);
}
