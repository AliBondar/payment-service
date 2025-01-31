package com.bondar.paymentservice.repository;

import com.bondar.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Payment findPaymentByOrderId(Long orderId);
}
