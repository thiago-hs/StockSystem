package org.fatec.trabLabEng.stockSystem.controllers;

import org.fatec.trabLabEng.stockSystem.models.Saida;
import org.fatec.trabLabEng.stockSystem.repository.SaidaRepository;
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
@RequestMapping("/api/saida")
public class SaidaController {

	@Autowired
	private SaidaRepository saidaRepository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Saida> listaSaida(){
		
		Iterable<Saida> lista = saidaRepository.findAll();

		return lista;
	}
	
	@GetMapping(value="/{codSaida}", produces="application/json")
	public @ResponseBody Saida saida(@PathVariable(value="codSaida") long codSaida){
		Saida saida = saidaRepository.findByCodSaida(codSaida);
		return saida;
	}
	
	@PostMapping()
	public Saida cadastraSaida(@RequestBody Saida saida){
		saidaRepository.save(saida);
		return saida;
	}
	
	@PutMapping(value="/{codSaida}", produces="application/json")
	public Saida atualizaSaida(@PathVariable(value="codSaida") long codSaida, @RequestBody Saida saida){
		
		Saida saidaBD = saidaRepository.findByCodSaida(codSaida);

		saidaBD.setTotal(saida.getTotal());
		saidaBD.setCodLoja(saida.getCodLoja());
		saidaBD.setCodTransportadora(saida.getCodTransportadora());

		saidaRepository.save(saidaBD);
		
		return saidaBD;
	}
	
	@DeleteMapping(value="/{codSaida}", produces="application/json")
	public ResponseEntity<Void> deletaSaida(@PathVariable(value="codSaida") long codSaida){
		
		Saida saidaBD = saidaRepository.findByCodSaida(codSaida);
		saidaRepository.delete(saidaBD);
		
		return ResponseEntity.noContent().build();
	}
}
