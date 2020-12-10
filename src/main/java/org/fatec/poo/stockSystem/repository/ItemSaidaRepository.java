package org.fatec.poo.stockSystem.repository;


import org.fatec.poo.stockSystem.models.ItemSaida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemSaidaRepository extends JpaRepository<ItemSaida, Long>{
	
	ItemSaida findByCodItemSaida(long codItemSaida);
	
}
