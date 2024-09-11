package org.acme.pedido_service.service;

import java.math.BigDecimal;

public record ImpostoResponsePayload(BigDecimal totalImposto) {
}
