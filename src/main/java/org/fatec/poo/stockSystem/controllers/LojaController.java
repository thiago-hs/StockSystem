package org.fatec.poo.stockSystem.controllers;

import java.util.ArrayList;

import org.fatec.poo.stockSystem.models.Cidade;
import org.fatec.poo.stockSystem.models.Loja;
import org.fatec.poo.stockSystem.repository.CidadeRepository;
import org.fatec.poo.stockSystem.repository.LojaRepository;
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
@RequestMapping("/api/loja")
@CrossOrigin(origins="*")
public class LojaController {

	@Autowired
	private LojaRepository lojaRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
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
		
		Cidade cidade = cidadeRepository.findByCodCidade(loja.getCodCidade());
		
		loja.setCidade(cidade);
		lojaRepository.save(loja);
		return loja;
	}
	
	@PutMapping(value="/{codLoja}", produces="application/json")
	public Loja atualizaLoja(@PathVariable(value="codLoja") long codLoja, @RequestBody Loja loja){
		
		Loja lojaBD = lojaRepository.findByCodLoja(codLoja);
		
		Cidade cidade = cidadeRepository.findByCodCidade(loja.getCodCidade());
		
		loja.setCidade(cidade);
		lojaBD.setCodLoja(loja.getCodLoja());
		lojaBD.setNome(loja.getNome());
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
