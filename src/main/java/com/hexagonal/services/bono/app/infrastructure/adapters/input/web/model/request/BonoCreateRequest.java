package com.hexagonal.services.bono.app.infrastructure.adapters.input.web.model.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BonoCreateRequest {

    @NotBlank(message = "The name field cannot be empty or null.")
    private String name;
    @NotNull(message = "The price field cannot be null.")
    private Double price;
    @NotNull(message = "The interestRate field cannot be null.")
    private Double interestRate;

}
