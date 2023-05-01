package com.jpc16tuesday.springlibraryproject.library.dao;

import com.jpc16tuesday.springlibraryproject.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    Optional<User> findByPhone(String phone);

    @Query("select u from User as u where u.email = ?1")
    Optional<User> getUserByEmail(String email);
}
