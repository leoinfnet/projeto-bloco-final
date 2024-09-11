package org.acme.pedido_service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.acme.pedido_service.model.Pedido;
import org.acme.pedido_service.service.ImpostoResponsePayload;
import org.acme.pedido_service.service.ImpostoService;
import org.acme.pedido_service.service.NotaFiscalService;
import org.acme.pedido_service.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/")
@Slf4j@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;
    private final ImpostoService impostoService;
    private final NotaFiscalService notaFiscalService;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Pedido pedido){
        log.info("Creating Pedido");
        log.info("Pedido: {}", pedido);
        BigDecimal totalImposto = impostoService.getTotalImposto(pedido).totalImposto();
        BigDecimal valorTotalSemImposto = pedidoService.calcularValorTotal(pedido);
        pedido.setTotalImposto(totalImposto);
        pedido.setValorTotalSemImposto(valorTotalSemImposto);
        pedido.setValorTotalComImposto(valorTotalSemImposto.add(totalImposto));
        Pedido saved = pedidoService.salvar(pedido);
        //notaFiscalService.emitirNotaFiscal(saved);
        return ResponseEntity.ok(saved);
    }

}
