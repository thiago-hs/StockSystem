package org.fatec.trabLabEng.stockSystem.repository;

import org.fatec.trabLabEng.stockSystem.models.Saida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaidaRepository extends JpaRepository<Saida, Long>{

	Saida findByCodSaida(long codSaida);
	
}
