package com.example.realEstateCk.Controller;

import com.example.realEstateCk.model.PaypalTransaction;
import com.example.realEstateCk.model.User;
import com.example.realEstateCk.service.PayPalService;
import com.example.realEstateCk.service.PayPalTransactionService;
import com.example.realEstateCk.service.UserService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.math.BigDecimal;

@RestController
@RequestMapping("/paypal")
public class PayPalController {

    @Autowired
    private PayPalService paypalService;

    @Autowired
    private UserService userService;

    @Autowired
    private PayPalTransactionService payPalTransactionService;

    @GetMapping("/pay")
    public void pay(@RequestParam("amount") double amount, HttpServletRequest request,  HttpServletResponse response) {
        String cancelUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/paypal/cancel";
        String successUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/paypal/success";

        try {
            Payment payment = paypalService.createPayment(
                    amount,
                    "USD",
                    "paypal",
                    "sale",
                    "Payment description",
                    cancelUrl,
                    successUrl
            );

            for (Links link : payment.getLinks()) {
                if (link.getRel().equals("approval_url")) {
                    response.sendRedirect(link.getHref()); // Chuyển hướng ngay lập tức
                    return;
                }
            }

        } catch (PayPalRESTException | IOException e) {
            e.printStackTrace();
            try {
                response.sendRedirect("/error"); // Chuyển hướng tới trang lỗi nếu có
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @GetMapping("/success")
    public ModelAndView success(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {

//                String username = SecurityContextHolder.getContext().getAuthentication().getName();
//                User user = userService.findByUsername(username);  // Giả sử bạn có service UserService để tìm người dùng

                // Tạo và lưu thông tin giao dịch vào cơ sở dữ liệu
                String payerEmail = payment.getPayer().getPayerInfo().getEmail();
                BigDecimal amount = new BigDecimal(payment.getTransactions().get(0).getAmount().getTotal());
                String currencyCode = payment.getTransactions().get(0).getAmount().getCurrency();
                String transactionId = payment.getId();
                String paymentStatus = payment.getState();
                String orderId = payment.getTransactions().get(0).getInvoiceNumber();  // Sử dụng invoice number (nếu có)
                String transactionDetails = payment.getTransactions().get(0).getDescription();
                Long id = 1L;
                payPalTransactionService.saveTransaction(paymentId, payerId, payerEmail, transactionId, amount, currencyCode, paymentStatus, orderId, transactionDetails, id);
                User addMoneyUser = userService.findById(id);
                Long totalMoney = addMoneyUser.getMoney() + convertUsdToVnd(amount);
                addMoneyUser.setMoney(totalMoney);
                userService.update(addMoneyUser);
                modelAndView.setViewName("redirect:/seller");
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
            modelAndView.setViewName("paymentFailure");
        }
        return modelAndView;
    }

        // Function to convert USD to VND
    public static long convertUsdToVnd(BigDecimal usdAmount) {
        // Define the exchange rate (e.g., 1 USD = 25,000 VND)
        BigDecimal exchangeRate = new BigDecimal("25000.0");
        BigDecimal vndAmount = usdAmount.multiply(exchangeRate);
        return vndAmount.longValue();
    }


    @GetMapping("/cancel")
    public ModelAndView cancel() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Giao dịch đã bị hủy");
        modelAndView.setViewName("redirect:/seller/addMoney");
        return modelAndView;
    }




}