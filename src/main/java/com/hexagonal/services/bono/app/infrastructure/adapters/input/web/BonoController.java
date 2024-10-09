package com.hexagonal.services.bono.app.infrastructure.adapters.input.web;

import com.hexagonal.services.bono.app.application.ports.input.BonoServicePort;
import com.hexagonal.services.bono.app.infrastructure.adapters.input.web.mapper.BonoWebMapper;
import com.hexagonal.services.bono.app.infrastructure.adapters.input.web.model.request.BonoCreateRequest;
import com.hexagonal.services.bono.app.infrastructure.adapters.input.web.model.response.BonoResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bonos")
public class BonoController {

    private final BonoServicePort bonoServicePort;

    @PostMapping()
    public ResponseEntity<BonoResponse> create(@Valid @RequestBody BonoCreateRequest bonoCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BonoWebMapper.bonoModelToBonoResponse(
                        bonoServicePort.create(BonoWebMapper.bonoRequestToBonoModel(bonoCreateRequest))));
    }

    @GetMapping()
    public List<BonoResponse> getAll() {
        return BonoWebMapper.bonoModelsToBonoResponses(bonoServicePort.getALl());
    }

    @GetMapping("/{id}")
    public BonoResponse findById(@PathVariable Long id) throws Exception {
        return BonoWebMapper.bonoModelToBonoResponse(bonoServicePort.findById(id));
    }

    @PutMapping("/{id}")
    public BonoResponse update(@PathVariable Long id, @Valid @RequestBody BonoCreateRequest bonoCreateRequest) throws Exception {
        return BonoWebMapper.bonoModelToBonoResponse(
                bonoServicePort.update(id, BonoWebMapper.bonoRequestToBonoModel(bonoCreateRequest)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        bonoServicePort.deleteById(id);
    }

}
