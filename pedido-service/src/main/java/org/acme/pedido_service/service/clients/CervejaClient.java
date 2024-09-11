package org.acme.pedido_service.service.clients;

import org.acme.pedido_service.model.Cerveja;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("CERVEJA-SERVICE")
public interface CervejaClient {
    @GetMapping("/{id}")
    Cerveja getById(@PathVariable Long id);
    @PutMapping("/{id}")
    void update(@PathVariable Long id, @RequestBody Cerveja cerveja);
}
