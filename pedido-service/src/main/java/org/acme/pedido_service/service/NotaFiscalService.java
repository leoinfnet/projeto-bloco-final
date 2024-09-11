package org.acme.pedido_service.service;

import lombok.RequiredArgsConstructor;
import org.acme.pedido_service.model.NotaFiscalPayload;
import org.acme.pedido_service.model.Pedido;
import org.acme.pedido_service.service.clients.NotaFiscalClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotaFiscalService {
    private final NotaFiscalClient client;
    public NotaFiscalPayload emitirNotaFiscal(Pedido pedido) {
        return client.emitirNotaFiscal(pedido);
    }

}
