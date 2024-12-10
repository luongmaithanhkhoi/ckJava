package com.example.realEstateCk.repository;


import com.example.realEstateCk.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
