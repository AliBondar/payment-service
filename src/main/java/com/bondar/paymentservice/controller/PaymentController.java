package com.bondar.paymentservice.controller;

import com.bondar.paymentservice.dto.PaymentRequestDto;
import com.bondar.paymentservice.entity.Payment;
import com.bondar.paymentservice.service.PaymentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payment")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentController {

    PaymentService paymentService;

    public ResponseEntity<?> savePayment(@RequestBody PaymentRequestDto dto) {
        Payment persistedPayment = paymentService.savePayment(dto);
        if (persistedPayment != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(persistedPayment);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
