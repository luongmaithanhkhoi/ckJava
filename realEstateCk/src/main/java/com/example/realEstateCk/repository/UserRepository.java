package com.example.realEstateCk.repository;

import com.example.realEstateCk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String username);
    User findByEmail(String email);
    User findByVerificationCode(String verificationCode);
    void deleteById(Long id);
}
