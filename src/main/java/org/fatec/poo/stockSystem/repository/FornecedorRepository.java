package org.fatec.poo.stockSystem.repository;

import org.fatec.poo.stockSystem.models.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

	Fornecedor findByCodFornecedor(long codFornecedor);
}
