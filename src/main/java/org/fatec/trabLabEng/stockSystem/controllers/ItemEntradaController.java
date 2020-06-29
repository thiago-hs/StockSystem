package org.fatec.trabLabEng.stockSystem.controllers;

import org.fatec.trabLabEng.stockSystem.models.ItemEntrada;
import org.fatec.trabLabEng.stockSystem.repository.ItemEntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class ItemEntradaController {
	
	@Autowired
	private ItemEntradaRepository itemEntradaRepository;
	
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
		itemEntradaRepository.save(itemEntrada);
		return itemEntrada;
	}
	
	@PutMapping(value="/{codItemEntrada}", produces="application/json")
	public ItemEntrada atualizaItemEntrada(@PathVariable(value="codItemEntrada") long codItemEntrada, @RequestBody ItemEntrada itemEntrada){
		
		ItemEntrada itemEntradaBD = itemEntradaRepository.findByCodItemEntrada(codItemEntrada);

		itemEntradaBD.setQuantidade(itemEntrada.getQuantidade());
		itemEntradaBD.setValor(itemEntrada.getValor());
		itemEntradaBD.setCodProduto(itemEntrada.getCodProduto());
		itemEntradaBD.setCodEntrada(itemEntrada.getCodEntrada());
		
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
