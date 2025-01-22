package com.bondar.paymentservice.service;

import com.bondar.paymentservice.dto.PaymentRequestDto;
import com.bondar.paymentservice.entity.Payment;

public interface PaymentService {

    Payment savePayment(PaymentRequestDto dto);

    Payment saveOrUpdatePayment(Payment payment, PaymentRequestDto dto);
}
