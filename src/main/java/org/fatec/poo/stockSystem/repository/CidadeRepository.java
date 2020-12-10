package org.fatec.poo.stockSystem.repository;

import org.fatec.poo.stockSystem.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade,Long>{
	
	Cidade findByCodCidade(long codCidade);
	
}
