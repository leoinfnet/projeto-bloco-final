package org.acme.imposto_service.model;

import java.util.List;

public record PedidoPayload(List<ItemPedido> items){}

