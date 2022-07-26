package com.kirillsoklakov.spring.boot.application.repository;

import com.kirillsoklakov.spring.boot.application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.login = ?1")
    User LoadUserByUsername(String login);
}
