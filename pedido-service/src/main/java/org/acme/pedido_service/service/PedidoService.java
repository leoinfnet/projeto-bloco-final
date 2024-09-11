package org.acme.pedido_service.service;

import lombok.AllArgsConstructor;
import org.acme.pedido_service.model.Cerveja;
import org.acme.pedido_service.model.ItemPedido;
import org.acme.pedido_service.model.Pedido;
import org.acme.pedido_service.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final CervejaService cervejaService;
    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    public BigDecimal calcularValorTotal(Pedido pedido) {
        return pedido.getItems().stream().map(this::calcularValorDeItem)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    private BigDecimal calcularValorDeItem(ItemPedido itemPedido) {
        Cerveja cerveja = cervejaService.getById(itemPedido.getCervejaId());
        return cerveja.getPreco().multiply(BigDecimal.valueOf(itemPedido.getQuantidade()));
    }
}
