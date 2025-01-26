package com.bondar.paymentservice.service;

import com.bondar.paymentservice.dto.PaymentDto;
import com.bondar.paymentservice.entity.Payment;
import com.bondar.paymentservice.repository.PaymentRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class paymentServiceImpl implements PaymentService {

    final PaymentRepository paymentRepository;

    @Autowired
    public paymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment savePayment(PaymentDto dto) {
        Payment payment = new Payment.PaymentBuilder()
                .transactionId(UUID.randomUUID().toString())
                .status(processPayment())
                .orderId(dto.getOrderId())
                .amount(dto.getAmount())
                .build();
        return paymentRepository.saveAndFlush(payment);
    }


    public String processPayment() {
        return new Random().nextBoolean() ? "success" : "false";
    }


}
