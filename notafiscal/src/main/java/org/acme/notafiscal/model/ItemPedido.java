package org.acme.notafiscal.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class ItemPedido {
    private Long quantidade;
    private Long cervejaId;
}
