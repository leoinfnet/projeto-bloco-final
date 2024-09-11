package org.acme.imposto_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.acme.imposto_service.model.Cerveja;
import org.acme.imposto_service.model.Fabricante;
import org.acme.imposto_service.model.PedidoPayload;
import org.acme.imposto_service.service.CervejaService;
import org.acme.imposto_service.service.FabricanteService;
import org.acme.imposto_service.service.ImpostoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class ImpostoController {
    private final ImpostoService impostoService;
    @PostMapping
    public ResponseEntity<?> calcularImposto(@RequestBody PedidoPayload pedidoPayload){
        log.info("Calculando imposto");
        log.info("Imposto: {}", pedidoPayload);
        BigDecimal impostoTotal = impostoService.calcularImpostoTotal(pedidoPayload);
        return ResponseEntity.ok(Map.of("totalImposto", impostoTotal));
    }
}
