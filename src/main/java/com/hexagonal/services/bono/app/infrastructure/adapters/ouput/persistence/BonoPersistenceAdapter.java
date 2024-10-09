package com.hexagonal.services.bono.app.infrastructure.adapters.ouput.persistence;

import com.hexagonal.services.bono.app.application.ports.ouput.BonoPersistencePort;
import com.hexagonal.services.bono.app.domain.model.Bono;
import com.hexagonal.services.bono.app.infrastructure.adapters.ouput.persistence.mapper.BonoPersistenceMapper;
import com.hexagonal.services.bono.app.infrastructure.adapters.ouput.persistence.repository.BonoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BonoPersistenceAdapter implements BonoPersistencePort {

    private final BonoRepository bonoRepository;

    @Override
    public Optional<Bono> findById(Long id) {
        return bonoRepository.findById(id)
                .map(BonoPersistenceMapper::bonoEntityToBonoModel);
    }

    @Override
    public List<Bono> getALl() {
        return BonoPersistenceMapper.bonoEntitiesToBonoModels(bonoRepository.findAll());
    }

    @Override
    public Bono create(Bono bono) {
        return BonoPersistenceMapper.bonoEntityToBonoModel(bonoRepository.save(BonoPersistenceMapper.bonoModelToBonoEntity(bono)));
    }

    @Override
    public void deleteById(Long id) {
        bonoRepository.deleteById(id);
    }
}
