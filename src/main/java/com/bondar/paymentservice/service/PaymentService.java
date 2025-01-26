package com.bondar.paymentservice.service;

import com.bondar.paymentservice.dto.PaymentDto;
import com.bondar.paymentservice.entity.Payment;

public interface PaymentService {

    Payment savePayment(PaymentDto dto);

    String processPayment();
}
