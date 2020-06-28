package org.fatec.trabLabEng.stockSystem.repository;

import org.fatec.trabLabEng.stockSystem.models.ItemEntrada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemEntradaRepository extends JpaRepository<ItemEntrada, Long>{
	
	ItemEntrada findByCodItemEntrada(long codItemEntrada);
	
}
