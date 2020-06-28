package org.fatec.trabLabEng.stockSystem.repository;

import org.fatec.trabLabEng.stockSystem.models.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportadoraRepository extends JpaRepository<Transportadora,Long>{
	
	Transportadora findByCodTransportadora(long codTransportadora);

}
