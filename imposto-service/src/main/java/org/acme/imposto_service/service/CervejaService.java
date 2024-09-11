package org.acme.imposto_service.service;

import lombok.RequiredArgsConstructor;
import org.acme.imposto_service.model.Cerveja;
import org.acme.imposto_service.service.client.CervejaClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CervejaService {
    private final CervejaClient cervejaClient;
    public Cerveja getById(Long id){
        return cervejaClient.getById(id);
        /*
        Interface antiga (Spring < 6.0)
         */
        //RestTemplate restTemplate = new RestTemplate();
//        RestClient restClient = RestClient.create();
//        var serverUrl = String.format("http://localhost:8081/%d", id);
//        Cerveja cerveja = restClient.get()
//                .uri(serverUrl)
//                .retrieve()
//                .toEntity(Cerveja.class).getBody();
//        return cerveja;
    }

}
