package org.fatec.trabLabEng.stockSystem.repository;


import org.fatec.trabLabEng.stockSystem.models.ItemSaida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemSaidaRepository extends JpaRepository<ItemSaida, Long>{
	
	ItemSaida findByCodItemSaida(long codItemSaida);
	
}
