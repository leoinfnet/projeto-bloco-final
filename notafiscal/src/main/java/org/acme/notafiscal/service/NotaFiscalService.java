package org.acme.notafiscal.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.acme.notafiscal.model.Pedido;
import org.acme.notafiscal.rabbitmq.NotaFiscalProducer;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotaFiscalService {
    private final NotaFiscalProducer producer;
    public void emitirNotaFiscal(Pedido pedido) throws JsonProcessingException {
        producer.send(pedido);
    }
}
