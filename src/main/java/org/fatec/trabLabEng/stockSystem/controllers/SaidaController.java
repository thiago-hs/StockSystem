package org.fatec.trabLabEng.stockSystem.controllers;

import org.fatec.trabLabEng.stockSystem.models.Loja;
import org.fatec.trabLabEng.stockSystem.models.Saida;
import org.fatec.trabLabEng.stockSystem.models.Transportadora;
import org.fatec.trabLabEng.stockSystem.repository.LojaRepository;
import org.fatec.trabLabEng.stockSystem.repository.SaidaRepository;
import org.fatec.trabLabEng.stockSystem.repository.TransportadoraRepository;
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
@RequestMapping("/api/saida")
@CrossOrigin(origins="*")
public class SaidaController {

	@Autowired
	private SaidaRepository saidaRepository;
	
	@Autowired
	private LojaRepository lojaRepository;
	
	@Autowired
	private TransportadoraRepository transportadoraRepository;
	
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
		Loja loja = lojaRepository.findByCodLoja(saida.getCodLoja());
		Transportadora transportadora = transportadoraRepository.findByCodTransportadora(saida.getCodTransportadora());

		saida.setLoja(loja);
		saida.setTransportadora(transportadora);
		
		saidaRepository.save(saida);
		return saida;
	}
	
	@PutMapping(value="/{codSaida}", produces="application/json")
	public Saida atualizaSaida(@PathVariable(value="codSaida") long codSaida, @RequestBody Saida saida){
		
		Saida saidaBD = saidaRepository.findByCodSaida(codSaida);
		
		Loja loja = lojaRepository.findByCodLoja(saida.getCodLoja());
		Transportadora transportadora = transportadoraRepository.findByCodTransportadora(saida.getCodTransportadora());

		saidaBD.setLoja(loja);
		saidaBD.setTransportadora(transportadora);
		saidaBD.setTotal(saida.getTotal());

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
