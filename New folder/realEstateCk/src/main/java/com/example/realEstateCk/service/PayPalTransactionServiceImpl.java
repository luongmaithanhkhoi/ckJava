package com.example.realEstateCk.service;

import com.example.realEstateCk.model.PaypalTransaction;
import com.example.realEstateCk.model.User;
import com.example.realEstateCk.repository.PayPalTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class PayPalTransactionServiceImpl implements PayPalTransactionService {
    @Autowired
    private PayPalTransactionRepository payPalTransactionRepository;
    @Override
    public PaypalTransaction updatePaypalTransaction(PaypalTransaction paypalTransaction) {
        return payPalTransactionRepository.save(paypalTransaction);
    }
    @Autowired
    private UserService userService;  // Giả sử bạn có service để tìm người dùng

    @Override
    public PaypalTransaction saveTransaction(String paymentId, String payerId, String payerEmail,
                                             String transactionId, BigDecimal amount, String currencyCode,
                                             String paymentStatus, String orderId, String transactionDetails,
                                             Long userId) {
        // Lấy thông tin người dùng từ userId
        User user = userService.findById(userId);

        // Tạo đối tượng PaypalTransaction mới và lưu vào cơ sở dữ liệu
        PaypalTransaction transaction = new PaypalTransaction();
        transaction.setPaymentId(paymentId);
        transaction.setPayerId(payerId);
        transaction.setPayerEmail(payerEmail);
        transaction.setTransactionId(transactionId);
        transaction.setAmount(amount);
        transaction.setCurrencyCode(currencyCode);
        transaction.setPaymentStatus(paymentStatus);
        transaction.setPaymentDate(LocalDateTime.now());
        transaction.setOrderId(orderId);
        transaction.setTransactionDetails(transactionDetails);
        transaction.setUser(user);  // Liên kết với người dùng

        return payPalTransactionRepository.save(transaction);  // Lưu vào cơ sở dữ liệu
    }
}
