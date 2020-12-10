package org.fatec.poo.stockSystem.repository;

import org.fatec.poo.stockSystem.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Produto findByCodProduto(long codProduto);
	
}
