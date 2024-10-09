package com.hexagonal.services.bono.app.infrastructure.adapters.input.web.mapper;

import com.hexagonal.services.bono.app.domain.model.Bono;
import com.hexagonal.services.bono.app.infrastructure.adapters.input.web.model.request.BonoCreateRequest;
import com.hexagonal.services.bono.app.infrastructure.adapters.input.web.model.response.BonoResponse;

import java.util.List;
import java.util.stream.Collectors;

public class BonoWebMapper {

    public static Bono bonoRequestToBonoModel(BonoCreateRequest bonoCreateRequest) {
        return Bono.builder()
                .name(bonoCreateRequest.getName())
                .price(bonoCreateRequest.getPrice())
                .interestRate(bonoCreateRequest.getInterestRate())
                .build();
    }

    public static BonoResponse bonoModelToBonoResponse(Bono bono) {
        return BonoResponse.builder()
                .name(bono.getName())
                .price(bono.getPrice())
                .interestRate(bono.getInterestRate())
                .build();
    }

    public static List<BonoResponse> bonoModelsToBonoResponses(List<Bono> bonos){
        return bonos.stream()
                .map(BonoWebMapper::bonoModelToBonoResponse)
                .collect(Collectors.toList());
    }

}
