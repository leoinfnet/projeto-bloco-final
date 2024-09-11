package org.acme.imposto_service.service;

import lombok.RequiredArgsConstructor;
import org.acme.imposto_service.model.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ImpostoService {
    private final CervejaService cervejaService;
    private final FabricanteService fabricanteService;
    public BigDecimal calcularImpostoTotal(PedidoPayload payload){
       return  payload.items().stream()
                .map(this::calcularImposto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    private BigDecimal calcularImposto(ItemPedido itemPedido){
        Cerveja cerveja = cervejaService.getById(itemPedido.getCervejaId());
        Fabricante fabricante = fabricanteService.getById((long)cerveja.getFabricanteId());
        BigDecimal taxa = getTaxas(fabricante.getPais());
        var impostoDoItem = cerveja.getPreco().multiply(taxa).multiply(new BigDecimal(itemPedido.getQuantidade()));
        return impostoDoItem;
    }

    private BigDecimal getTaxas(Pais pais){
        return switch (pais){
            case USA -> new BigDecimal("0.45");
            case BRASIL -> new BigDecimal("0.05");
            case EUROPA -> new BigDecimal("0.31");
        };
    }
}
