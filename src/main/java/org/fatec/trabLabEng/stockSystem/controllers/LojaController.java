package org.fatec.trabLabEng.stockSystem.controllers;

import java.util.ArrayList;

import org.fatec.trabLabEng.stockSystem.models.Loja;
import org.fatec.trabLabEng.stockSystem.repository.LojaRepository;
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
@RequestMapping("/loja")
public class LojaController {

	@Autowired
	private LojaRepository lojaRepository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Loja> listaLoja(){
		
		Iterable<Loja> lista = lojaRepository.findAll();

		return lista;
	}
	
	@GetMapping(value="/{codLoja}", produces="application/json")
	public @ResponseBody Loja loja(@PathVariable(value="codLoja") long codLoja){
		Loja loja = lojaRepository.findByCodLoja(codLoja);
		return loja;
	}
	
	@PostMapping()
	public Loja cadastraLoja(@RequestBody Loja loja){
		lojaRepository.save(loja);
		return loja;
	}
	
	@PutMapping(value="/{codLoja}", produces="application/json")
	public Loja atualizaLoja(@PathVariable(value="codLoja") long codLoja, @RequestBody Loja loja){
		
		Loja lojaBD = lojaRepository.findByCodLoja(codLoja);

		lojaBD.setCodLoja(loja.getCodLoja());
		lojaBD.setNomeLoja(loja.getNomeLoja());
		lojaBD.setEndereco(loja.getEndereco());
		lojaBD.setTel(loja.getTel());
		
		lojaRepository.save(lojaBD);
		
		return lojaBD;
	}
	
	@DeleteMapping(value="/{codLoja}", produces="application/json")
	public ResponseEntity<Void> deletaLoja(@PathVariable(value="codLoja") long codLoja){
		
		Loja lojaBD = lojaRepository.findByCodLoja(codLoja);
		lojaRepository.delete(lojaBD);
		
		return ResponseEntity.noContent().build();
	}
}
