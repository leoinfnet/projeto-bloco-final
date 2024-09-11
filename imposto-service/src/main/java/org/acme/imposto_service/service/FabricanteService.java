package org.acme.imposto_service.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.acme.imposto_service.model.Fabricante;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class FabricanteService {
    public Fabricante getById(Long id){
        var serverUrl = String.format("http://localhost:8082/%d", id);
        RestClient client  = RestClient.create();
        Fabricante fabricante = client.get().uri(serverUrl)
                .retrieve()
                .toEntity(Fabricante.class).getBody();
        return fabricante;
    }
}
