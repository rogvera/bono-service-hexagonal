package com.hexagonal.services.bono.app.application.ports.input;

import com.hexagonal.services.bono.app.domain.model.Bono;

import java.util.List;

public interface BonoServicePort {

    Bono findById(Long id) throws Exception;
    List<Bono> getALl();
    Bono create(Bono bono);
    Bono update(Long id, Bono bono) throws Exception;
    void deleteById(Long id) throws Exception;

}
