package org.fatec.trabLabEng.stockSystem.controllers;

import org.fatec.trabLabEng.stockSystem.models.Cidade;
import org.fatec.trabLabEng.stockSystem.repository.CidadeRepository;
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
@RequestMapping("/cidade")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody  Iterable<Cidade> listaCidades(){
		Iterable<Cidade> listaCidade = cidadeRepository.findAll();
		return listaCidade;
	}
	
	@GetMapping(value="/{codCidade}", produces="application/json")
	public @ResponseBody Cidade cidade(@PathVariable(value="codCidade") long codCidade){
		Cidade cidade = cidadeRepository.findByCodCidade(codCidade);
		return cidade;
	}
	
	@PostMapping()
	public Cidade cadastraCidade(@RequestBody Cidade cidade){
		cidadeRepository.save(cidade);
		//long codCidade = cidade.getCodCidade();
		return cidade;
	}
	
	@PutMapping(value="/{codCidade}", produces="application/json")
	public Cidade atualizaCidade(@PathVariable(value="codCidade") long codCidade, @RequestBody Cidade cidade){
		
		Cidade cidadeDB = cidadeRepository.findByCodCidade(codCidade);

		cidadeDB.setCidade(cidade.getCidade());
		cidadeDB.setUf(cidade.getUf());
		
		cidadeRepository.save(cidadeDB);
		
		return cidadeDB;
	}
	
	@DeleteMapping(value="/{codCidade}", produces="application/json")
	public ResponseEntity<Void> deletaCategoria(@PathVariable(value="codCidade") long codCidade){
		
		Cidade cidadeDB = cidadeRepository.findByCodCidade(codCidade);
		
		cidadeRepository.delete(cidadeDB);
		
		return ResponseEntity.noContent().build();
	}
}
