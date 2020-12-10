package org.fatec.poo.stockSystem.controllers;

import org.fatec.poo.stockSystem.models.Categoria;
import org.fatec.poo.stockSystem.models.Entrada;
import org.fatec.poo.stockSystem.models.Fornecedor;
import org.fatec.poo.stockSystem.models.Produto;
import org.fatec.poo.stockSystem.repository.CategoriaRepository;
import org.fatec.poo.stockSystem.repository.FornecedorRepository;
import org.fatec.poo.stockSystem.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/api/produto")
@CrossOrigin(origins="*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
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
		Categoria categoria = categoriaRepository.findByCodCategoria(produto.getCodCategoria());
		Fornecedor fornecedor = fornecedorRepository.findByCodFornecedor(produto.getCodFornecedor());
		
		produto.setCategoria(categoria);
		produto.setFornecedor(fornecedor);
		
		produtoRepository.save(produto);
		return produto;
	}
	
	@PutMapping(value="/{codProduto}", produces="application/json")
	public Produto atualizaProduto(@PathVariable(value="codProduto") long codProduto, @RequestBody Produto produto){
		
		Produto produtoBD = produtoRepository.findByCodProduto(codProduto);

		Categoria categoria = categoriaRepository.findByCodCategoria(produto.getCodCategoria());
		Fornecedor fornecedor = fornecedorRepository.findByCodFornecedor(produto.getCodFornecedor());
		
		produtoBD.setCategoria(categoria);
		produtoBD.setFornecedor(fornecedor);
		produtoBD.setDescricao(produto.getDescricao());
		produtoBD.setPeso(produto.getPeso());
		produtoBD.setQntMin(produto.getQntMin());

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
