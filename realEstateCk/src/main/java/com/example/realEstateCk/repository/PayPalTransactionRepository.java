package com.example.realEstateCk.repository;

import com.example.realEstateCk.model.PaypalTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayPalTransactionRepository extends JpaRepository<PaypalTransaction, Long> {

}
