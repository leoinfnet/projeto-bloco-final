package org.acme.cerveja_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.acme.cerveja_service.model.Cerveja;
import org.acme.cerveja_service.service.CervejaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class CervejaController {
    private final CervejaService cervejaService;
    @PostMapping
    public ResponseEntity<Cerveja> createCerveja(@RequestBody Cerveja cerveja) {
        Cerveja saved = cervejaService.create(cerveja);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(cervejaService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        log.info("Find cerveja by id: {}", id);
        Optional<Cerveja> optional = cervejaService.findById(id);
        if(optional.isPresent()){
            return ResponseEntity.ok(optional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        cervejaService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Cerveja cerveja){
        cervejaService.update(cerveja);
        return ResponseEntity.ok().build();
    }

}
