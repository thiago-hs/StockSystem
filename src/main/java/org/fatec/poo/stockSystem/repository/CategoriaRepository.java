package org.fatec.poo.stockSystem.repository;

import org.fatec.poo.stockSystem.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long>{
	
	Categoria findByCodCategoria(long codCategoria);
	
}
