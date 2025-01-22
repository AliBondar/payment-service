package com.bondar.paymentservice.service;

import com.bondar.paymentservice.dto.PaymentRequestDto;
import com.bondar.paymentservice.entity.Payment;
import com.bondar.paymentservice.repository.PaymentRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class paymentServiceImpl implements PaymentService {

    PaymentRepository paymentRepository;

    public Payment savePayment(PaymentRequestDto dto) {
        return saveOrUpdatePayment(
                new Payment.PaymentBuilder().setTransaction(UUID.randomUUID().toString()).build(), dto);
    }

    public Payment saveOrUpdatePayment(Payment payment, PaymentRequestDto dto) {
        payment.setStatus(dto.getStatus());
        return paymentRepository.saveAndFlush(payment);
    }

}
