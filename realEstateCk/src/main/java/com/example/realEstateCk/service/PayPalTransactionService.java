package com.example.realEstateCk.service;

import com.example.realEstateCk.model.PaypalTransaction;

import java.math.BigDecimal;

public interface PayPalTransactionService {
    public PaypalTransaction updatePaypalTransaction(PaypalTransaction paypalTransaction);
    public PaypalTransaction saveTransaction(String paymentId, String payerId, String payerEmail,
                                             String transactionId, BigDecimal amount, String currencyCode,
                                             String paymentStatus, String orderId, String transactionDetails, Long userId);
}
