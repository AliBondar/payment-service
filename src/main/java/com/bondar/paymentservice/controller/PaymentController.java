package com.bondar.paymentservice.controller;

import com.bondar.paymentservice.dto.PaymentDto;
import com.bondar.paymentservice.entity.Payment;
import com.bondar.paymentservice.service.PaymentService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentController {

    final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/savePayment")
    public ResponseEntity<?> savePayment(@RequestBody PaymentDto dto) {
        Payment persistedPayment = paymentService.savePayment(dto);
        if (persistedPayment != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(persistedPayment);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
