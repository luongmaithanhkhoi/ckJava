package com.example.realEstateCk.repository;

import com.example.realEstateCk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
