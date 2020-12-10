package org.fatec.poo.stockSystem.repository;

import org.fatec.poo.stockSystem.models.Loja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LojaRepository extends JpaRepository<Loja, Long>{

	Loja findByCodLoja(long codLoja);
}
