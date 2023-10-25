package com.nadia.paymentservice.services;

import com.nadia.paymentservice.model.Payment;

public interface PaymentService {
    void sendPayment(Payment payment);
}
