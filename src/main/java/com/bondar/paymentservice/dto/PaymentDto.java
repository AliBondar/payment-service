package com.bondar.paymentservice.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentDto implements Serializable {

    Long paymentId;

    String status;

    String transactionId;

    Long orderId;

    double amount;
}
