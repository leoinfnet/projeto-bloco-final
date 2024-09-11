package org.acme.fabricante_service.service;

import lombok.RequiredArgsConstructor;
import org.acme.fabricante_service.model.Fabricante;
import org.acme.fabricante_service.repository.FabricanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FabricanteService {
    private final FabricanteRepository fabricanteRepository;
    public Optional<Fabricante> getById(long id) {
        return fabricanteRepository.findById(id);
    }
    public List<Fabricante> getAll() {return fabricanteRepository.findAll();}
}
