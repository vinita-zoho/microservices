package com.in28minutes.microservices.currency_conversion.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table
public class CurrencyConversion {

    @Id
    private final Long id;

    @NonNull
    @Column(name = "currency_from")
    private String from;

    @NonNull
    @Column(name = "currency_to")
    private String to;

    @NonNull
    private BigDecimal conversionMultiple;

    private BigDecimal quantity;

    private BigDecimal totalCalculatedAmount;

    private String environment;
}
