package com.bondar.paymentservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String status;

    String transactionId;

    private Payment(PaymentBuilder builder) {
        this.transactionId = builder.transactionId;
        this.status = builder.status;
    }

    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class PaymentBuilder {
        String status;

        String transactionId;

        public PaymentBuilder setTransaction(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public PaymentBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}

