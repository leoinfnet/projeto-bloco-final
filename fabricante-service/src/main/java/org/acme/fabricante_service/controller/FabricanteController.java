package org.acme.fabricante_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.acme.fabricante_service.model.Fabricante;
import org.acme.fabricante_service.service.FabricanteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class FabricanteController {
    private final FabricanteService fabricanteService;
    @GetMapping
    public ResponseEntity<?> getAllFabricantes() {
        return ResponseEntity.ok(fabricanteService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getFabricanteById(@PathVariable Long id) {
        log.info("Get Fabricante by id: {}", id);
        System.out.println("Fabricante");
        Optional<Fabricante> fabricanteOptional = fabricanteService.getById(id);
        if(fabricanteOptional.isPresent()) {
            return ResponseEntity.ok(fabricanteOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
