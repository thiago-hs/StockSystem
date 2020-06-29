package org.fatec.trabLabEng.stockSystem.controllers;

import org.fatec.trabLabEng.stockSystem.models.ItemSaida;
import org.fatec.trabLabEng.stockSystem.repository.ItemSaidaRepository;
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
@RequestMapping("/api/itemsaida")
public class ItemSaidaController {

	@Autowired
	private ItemSaidaRepository itemSaidaRepository;
	
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
		itemSaidaRepository.save(itemSaida);
		return itemSaida;
	}
	
	@PutMapping(value="/{codItemSaida}", produces="application/json")
	public ItemSaida atualizaItemSaida(@PathVariable(value="codItemSaida") long codItemSaida, @RequestBody ItemSaida itemSaida){
		
		ItemSaida itemSaidaBD = itemSaidaRepository.findByCodItemSaida(codItemSaida);

		itemSaidaBD.setQuantidade(itemSaida.getQuantidade());
		itemSaidaBD.setValor(itemSaida.getValor());
		itemSaidaBD.setCodProduto(itemSaida.getCodProduto());
		itemSaidaBD.setCodSaida(itemSaida.getCodSaida());
		
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
