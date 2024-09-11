package org.acme.pedido_service.service;

import lombok.RequiredArgsConstructor;
import org.acme.pedido_service.model.Cerveja;
import org.acme.pedido_service.service.clients.CervejaClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class CervejaService {
    private final CervejaClient cervejaClient;
    public Cerveja getById(Long id){
         return cervejaClient.getById(id);
//        RestClient restClient = RestClient.create();
//        var serverUrl = String.format("http://localhost:8081/%d", id);
//        return restClient.get().uri(serverUrl).retrieve().toEntity(Cerveja.class).getBody();
    }

}
// Client Side Load Balancer <> Server Side LoadBalancer