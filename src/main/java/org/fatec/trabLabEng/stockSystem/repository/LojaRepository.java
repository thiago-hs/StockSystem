package org.fatec.trabLabEng.stockSystem.repository;

import org.fatec.trabLabEng.stockSystem.models.Loja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LojaRepository extends JpaRepository<Loja, Long>{

	Loja findByCodLoja(long codLoja);
}
