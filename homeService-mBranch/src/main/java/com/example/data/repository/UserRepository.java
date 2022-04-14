package com.example.data.repository;

import com.example.data.entity.User;
import com.example.data.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

/**
 * @author fh.kazemi
 **/

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String name);

    Optional<User> findBySurname(String surname);

    Optional<User> findByNameAndSurname(String name, String surname);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    Optional<User> findByStatus(UserStatus status);

    Optional<User> findByRegisterDate(Date registerDate);

    @Modifying
    @Transactional
    @Query(value = "update User u set u.password=:password where u.email=:email and u.password=:oldPassword")
    void updatePassword(@Param("email") String email, @Param("password") String password, @Param("oldPassword") String oldPassword);

    @Modifying
    @Transactional
    @Query(value = "update User u set u.creditCart=:creditCart where u.email=:email")
    void updateCreditCart(@Param("email") String email, @Param("creditCart") Double creditCart);

    @Modifying
    @Transactional
    @Query(value = "update User u set u.status=:status where u.email=:email")
    void updateStatus(@Param("email") String email, @Param("status") UserStatus status);
}
