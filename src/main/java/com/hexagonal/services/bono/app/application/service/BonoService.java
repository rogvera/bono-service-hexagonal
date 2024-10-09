package com.hexagonal.services.bono.app.application.service;

import com.hexagonal.services.bono.app.application.ports.input.BonoServicePort;
import com.hexagonal.services.bono.app.application.ports.ouput.BonoPersistencePort;
import com.hexagonal.services.bono.app.domain.exception.DuplicateBonoException;
import com.hexagonal.services.bono.app.domain.model.Bono;
import com.hexagonal.services.bono.app.domain.exception.BonoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BonoService implements BonoServicePort {

    private final BonoPersistencePort bonoPersistencePort;

    @Override
    public Bono findById(Long id) throws Exception {
        return bonoPersistencePort.findById(id)
                .orElseThrow(BonoNotFoundException::new);
    }

    @Override
    public List<Bono> getALl() {
        return bonoPersistencePort.getALl();
    }

    @Override
    public Bono create(Bono bono) {
        return bonoPersistencePort.create(bono);
    }

    @Override
    public Bono update(Long id, Bono bono) throws Exception {
        return bonoPersistencePort.findById(id)
                .map(savedBono -> {
                    savedBono.setName(bono.getName());
                    savedBono.setPrice(bono.getPrice());
                    savedBono.setInterestRate(bono.getInterestRate());
                    return bonoPersistencePort.create(savedBono);
                })
                .orElseThrow(BonoNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        if (bonoPersistencePort.findById(id).isEmpty()) {
            throw new BonoNotFoundException();
        }
        bonoPersistencePort.deleteById(id);
    }
}
