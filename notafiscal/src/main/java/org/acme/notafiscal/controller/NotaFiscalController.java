package org.acme.notafiscal.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.acme.notafiscal.model.Pedido;
import org.acme.notafiscal.service.NotaFiscalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class NotaFiscalController {
    private final NotaFiscalService notaFiscalService;
    @PostMapping
    public ResponseEntity<Map<String, String>> gerarNotaFiscal(@RequestBody Pedido pedido){
        try {
            notaFiscalService.emitirNotaFiscal(pedido);
        } catch (JsonProcessingException e) {
            ResponseEntity.internalServerError().build();
            throw new RuntimeException(e);
        }
//        int i = new Random().nextInt(100);
//        log.info("Random: " + i );
//        if(i > 60){
//            try {
//                Thread.sleep(10_000);
//                log.info("Gerando nota Fiscal do pedido: " +  pedido);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
        return ResponseEntity.ok(Map.of("message:", "Nota Fiscal Gerada Com sucesso!"));
    }
}
