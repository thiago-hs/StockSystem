package org.fatec.poo.stockSystem.repository;

import org.fatec.poo.stockSystem.models.Saida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaidaRepository extends JpaRepository<Saida, Long>{

	Saida findByCodSaida(long codSaida);
	
}
