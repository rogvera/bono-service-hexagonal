package com.hexagonal.services.bono.app.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bono {
    private Long id;
    private String name;
    private double price;
    private double interestRate;
}
