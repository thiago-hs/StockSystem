package org.fatec.trabLabEng.stockSystem.controllers;

import org.fatec.trabLabEng.stockSystem.models.Entrada;
import org.fatec.trabLabEng.stockSystem.models.ItemEntrada;
import org.fatec.trabLabEng.stockSystem.models.Produto;
import org.fatec.trabLabEng.stockSystem.repository.EntradaRepository;
import org.fatec.trabLabEng.stockSystem.repository.ItemEntradaRepository;
import org.fatec.trabLabEng.stockSystem.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/itementrada")
@CrossOrigin(origins="*")
public class ItemEntradaController {
	
	@Autowired
	private ItemEntradaRepository itemEntradaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EntradaRepository entradaRepository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody  Iterable<ItemEntrada> listaItemEntrada(){
		
		Iterable<ItemEntrada> lista = itemEntradaRepository.findAll();

		return lista;
	}
	
	@GetMapping(value="/{codItemEntrada}", produces="application/json")
	public @ResponseBody ItemEntrada itemEntrada(@PathVariable(value="codItemEntrada") long codItemEntrada){
		ItemEntrada itemEntrada = itemEntradaRepository.findByCodItemEntrada(codItemEntrada);
		return itemEntrada;
	}
	
	@PostMapping()
	public ItemEntrada cadastraItemEntrada(@RequestBody ItemEntrada itemEntrada){
		Entrada entrada = entradaRepository.findByCodEntrada(itemEntrada.getCodEntrada());
		Produto produto = produtoRepository.findByCodProduto(itemEntrada.getCodProduto());

		itemEntrada.setEntrada(entrada);
		itemEntrada.setProduto(produto);
		
		itemEntradaRepository.save(itemEntrada);
		return itemEntrada;
	}
	
	@PutMapping(value="/{codItemEntrada}", produces="application/json")
	public ItemEntrada atualizaItemEntrada(@PathVariable(value="codItemEntrada") long codItemEntrada, @RequestBody ItemEntrada itemEntrada){
		
		ItemEntrada itemEntradaBD = itemEntradaRepository.findByCodItemEntrada(codItemEntrada);

		Entrada entrada = entradaRepository.findByCodEntrada(itemEntrada.getCodEntrada());
		Produto produto = produtoRepository.findByCodProduto(itemEntrada.getCodProduto());

		itemEntradaBD.setEntrada(entrada);
		itemEntradaBD.setProduto(produto);
		itemEntradaBD.setQuantidade(itemEntrada.getQuantidade());
		itemEntradaBD.setValor(itemEntrada.getValor());
		
		itemEntradaRepository.save(itemEntradaBD);
		
		return itemEntradaBD;
	}
	
	@DeleteMapping(value="/{codItemEntrada}", produces="application/json")
	public ResponseEntity<Void> deletaFornecedor(@PathVariable(value="codItemEntrada") long codItemEntrada){
		
		ItemEntrada itemEntradaBD = itemEntradaRepository.findByCodItemEntrada(codItemEntrada);
		itemEntradaRepository.delete(itemEntradaBD);
		
		return ResponseEntity.noContent().build();
	}
	
}
