package org.fatec.poo.stockSystem.repository;

import org.fatec.poo.stockSystem.models.ItemEntrada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemEntradaRepository extends JpaRepository<ItemEntrada, Long>{
	
	ItemEntrada findByCodItemEntrada(long codItemEntrada);
	
}
