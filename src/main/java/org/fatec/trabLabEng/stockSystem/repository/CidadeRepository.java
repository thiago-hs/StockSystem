package org.fatec.trabLabEng.stockSystem.repository;

import org.fatec.trabLabEng.stockSystem.models.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade,String>{
	
	Cidade findByCodCidade(long codCidade);
	
}
