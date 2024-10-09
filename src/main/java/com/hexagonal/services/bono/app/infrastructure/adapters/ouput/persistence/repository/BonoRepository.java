package com.hexagonal.services.bono.app.infrastructure.adapters.ouput.persistence.repository;

import com.hexagonal.services.bono.app.infrastructure.adapters.ouput.persistence.entity.BonoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BonoRepository extends JpaRepository<BonoEntity, Long> {
}
