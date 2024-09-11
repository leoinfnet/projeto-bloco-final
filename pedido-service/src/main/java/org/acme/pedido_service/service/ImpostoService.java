package org.acme.pedido_service.service;

import lombok.RequiredArgsConstructor;
import org.acme.pedido_service.model.Pedido;
import org.acme.pedido_service.service.clients.ImpostoClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class ImpostoService {
    //Ribbon
    private final ImpostoClient impostoClient;
    public ImpostoResponsePayload getTotalImposto(Pedido pedido){
        return impostoClient.getImposto(pedido);
//        var serverUrl = "http://localhost:8084";
//        RestClient client = RestClient.create();
//        return client.post()
//                .uri(serverUrl)
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(pedido)
//                .retrieve()
//                .toEntity(ImpostoResponsePayload.class).getBody();
    }
}
