package com.bondar.paymentservice.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentRequestDto implements Serializable {

    String status;

    String transaction;
}
