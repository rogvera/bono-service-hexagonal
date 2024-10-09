package com.hexagonal.services.bono.app.application.ports.ouput;

import com.hexagonal.services.bono.app.domain.model.Bono;

import java.util.List;
import java.util.Optional;

public interface BonoPersistencePort {

    Optional<Bono> findById(Long id);
    List<Bono> getALl();
    Bono create(Bono bono);
    void deleteById(Long id);

}
