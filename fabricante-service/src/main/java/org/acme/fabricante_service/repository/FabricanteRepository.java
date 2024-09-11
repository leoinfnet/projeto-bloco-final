package org.acme.fabricante_service.repository;

import org.acme.fabricante_service.model.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {
}
