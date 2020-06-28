package org.fatec.trabLabEng.stockSystem.controllers;

import org.fatec.trabLabEng.stockSystem.models.Produto;
import org.fatec.trabLabEng.stockSystem.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Produto> listaProduto(){
		
		Iterable<Produto> lista = produtoRepository.findAll();

		return lista;
	}
	
	@GetMapping(value="/{codProduto}", produces="application/json")
	public @ResponseBody Produto produto(@PathVariable(value="codProduto") long codProduto){
		Produto produto = produtoRepository.findByCodProduto(codProduto);
		return produto;
	}
	
	@PostMapping()
	public Produto cadastraproduto(@RequestBody Produto produto){
		produtoRepository.save(produto);
		return produto;
	}
	
	@PutMapping(value="/{codProduto}", produces="application/json")
	public Produto atualizaProduto(@PathVariable(value="codProduto") long codProduto, @RequestBody Produto produto){
		
		Produto produtoBD = produtoRepository.findByCodProduto(codProduto);

		produtoBD.setDescricao(produto.getDescricao());
		produtoBD.setPeso(produto.getPeso());
		produtoBD.setQntMin(produto.getQntMin());
		produtoBD.setCodFornecedor(produto.getCodFornecedor());
		produtoBD.setCodCategoria(produto.getCodCategoria());

		produtoRepository.save(produtoBD);
		
		return produtoBD;
	}
	
	@DeleteMapping(value="/{codProduto}", produces="application/json")
	public ResponseEntity<Void> deletaProduto(@PathVariable(value="codProduto") long codProduto){
		
		Produto produtoBD = produtoRepository.findByCodProduto(codProduto);
		produtoRepository.delete(produtoBD);
		
		return ResponseEntity.noContent().build();
	}
}
