package org.acme.pedido_service.service.clients;

import org.acme.pedido_service.model.NotaFiscalPayload;
import org.acme.pedido_service.model.Pedido;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("NOTAFISCAL-SERVICE")
public interface NotaFiscalClient {
    @PostMapping("/")
    NotaFiscalPayload emitirNotaFiscal(@RequestBody Pedido pedido);
}
