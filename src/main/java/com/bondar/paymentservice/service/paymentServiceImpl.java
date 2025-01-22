package com.bondar.paymentservice.service;

import com.bondar.paymentservice.dto.PaymentRequestDto;
import com.bondar.paymentservice.entity.Payment;
import com.bondar.paymentservice.repository.PaymentRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class paymentServiceImpl implements PaymentService {

    final PaymentRepository paymentRepository;

    @Autowired
    public paymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment savePayment(PaymentRequestDto dto) {
        return saveOrUpdatePayment(
                new Payment.PaymentBuilder().setTransaction(UUID.randomUUID().toString()).build(), dto);
    }

    public Payment saveOrUpdatePayment(Payment payment, PaymentRequestDto dto) {
        payment.setStatus(dto.getStatus());
        return paymentRepository.saveAndFlush(payment);
    }

}
