package org.acme.pedido_service.repository;

import org.acme.pedido_service.model.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<Pedido, String> {
}
