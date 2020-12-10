package org.fatec.poo.stockSystem.repository;

import org.fatec.poo.stockSystem.models.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportadoraRepository extends JpaRepository<Transportadora,Long>{
	
	Transportadora findByCodTransportadora(long codTransportadora);

}
