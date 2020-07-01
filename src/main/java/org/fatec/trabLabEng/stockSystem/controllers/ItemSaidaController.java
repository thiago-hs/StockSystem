package org.fatec.trabLabEng.stockSystem.controllers;

import org.fatec.trabLabEng.stockSystem.models.Entrada;
import org.fatec.trabLabEng.stockSystem.models.ItemSaida;
import org.fatec.trabLabEng.stockSystem.models.Produto;
import org.fatec.trabLabEng.stockSystem.models.Saida;
import org.fatec.trabLabEng.stockSystem.repository.EntradaRepository;
import org.fatec.trabLabEng.stockSystem.repository.ItemSaidaRepository;
import org.fatec.trabLabEng.stockSystem.repository.ProdutoRepository;
import org.fatec.trabLabEng.stockSystem.repository.SaidaRepository;
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
@RequestMapping("/api/itemsaida")
@CrossOrigin(origins="*")
public class ItemSaidaController {

	@Autowired
	private ItemSaidaRepository itemSaidaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private SaidaRepository saidaRepository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<ItemSaida> listaItemSaida(){
		
		Iterable<ItemSaida> lista = itemSaidaRepository.findAll();

		return lista;
	}
	
	@GetMapping(value="/{codItemSaida}", produces="application/json")
	public @ResponseBody ItemSaida itemSaida(@PathVariable(value="codItemSaida") long codItemSaida){
		ItemSaida itemSaida = itemSaidaRepository.findByCodItemSaida(codItemSaida);
		return itemSaida;
	}
	
	@PostMapping()
	public ItemSaida cadastraItemSaida(@RequestBody ItemSaida itemSaida){
		Saida saida = saidaRepository.findByCodSaida(itemSaida.getCodSaida());
		Produto produto = produtoRepository.findByCodProduto(itemSaida.getCodProduto());

		itemSaida.setSaida(saida);
		itemSaida.setProduto(produto);
		
		itemSaidaRepository.save(itemSaida);
		return itemSaida;
	}
	
	@PutMapping(value="/{codItemSaida}", produces="application/json")
	public ItemSaida atualizaItemSaida(@PathVariable(value="codItemSaida") long codItemSaida, @RequestBody ItemSaida itemSaida){
		
		ItemSaida itemSaidaBD = itemSaidaRepository.findByCodItemSaida(codItemSaida);

		Saida saida = saidaRepository.findByCodSaida(itemSaida.getCodSaida());
		Produto produto = produtoRepository.findByCodProduto(itemSaida.getCodProduto());

		itemSaidaBD.setSaida(saida);
		itemSaidaBD.setProduto(produto);
		itemSaidaBD.setQuantidade(itemSaida.getQuantidade());
		itemSaidaBD.setValor(itemSaida.getValor());
		
		itemSaidaRepository.save(itemSaidaBD);
		
		return itemSaidaBD;
	}
	
	@DeleteMapping(value="/{codItemSaida}", produces="application/json")
	public ResponseEntity<Void> deletaFornecedor(@PathVariable(value="codItemSaida") long codItemSaida){
		
		ItemSaida itemSaidaBD = itemSaidaRepository.findByCodItemSaida(codItemSaida);
		itemSaidaRepository.delete(itemSaidaBD);
		
		return ResponseEntity.noContent().build();
	}
}
