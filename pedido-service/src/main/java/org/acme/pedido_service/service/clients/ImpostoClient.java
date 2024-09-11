package org.acme.pedido_service.service.clients;

import org.acme.pedido_service.model.Pedido;
import org.acme.pedido_service.service.ImpostoResponsePayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("IMPOSTO-SERVICE")
public interface ImpostoClient {
    @PostMapping("/")
    ImpostoResponsePayload getImposto(@RequestBody Pedido pedido);
}
