package org.acme.cerveja_service.repository;

import org.acme.cerveja_service.model.Cerveja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //Nao precisa mais
public interface CervejaRepository extends JpaRepository<Cerveja, Long> {
}
