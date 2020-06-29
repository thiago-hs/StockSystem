package org.fatec.trabLabEng.stockSystem.controllers;

import org.fatec.trabLabEng.stockSystem.models.Transportadora;
import org.fatec.trabLabEng.stockSystem.repository.TransportadoraRepository;
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
@RequestMapping("/api/transportadora")
public class TransportadoraController {

	@Autowired
	private TransportadoraRepository transportadoraRepository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Transportadora> listaTransportadora(){
		
		Iterable<Transportadora> lista = transportadoraRepository.findAll();

		return lista;
	}
	
	@GetMapping(value="/{codTransportadora}", produces="application/json")
	public @ResponseBody Transportadora transportadora(@PathVariable(value="codSaida") long codTransportadora){
		Transportadora transportadora = transportadoraRepository.findByCodTransportadora(codTransportadora);
		return transportadora;
	}
	
	@PostMapping()
	public Transportadora cadastraTransportadora(@RequestBody Transportadora transportadora){
		transportadoraRepository.save(transportadora);
		return transportadora;
	}
	
	@PutMapping(value="/{codTransportadora}", produces="application/json")
	public Transportadora atualizaTransportadora(@PathVariable(value="codTransportadora") long codTransportadora, @RequestBody Transportadora transportadora){
		
		Transportadora transportadoraBD = transportadoraRepository.findByCodTransportadora(codTransportadora);

		transportadoraBD.setNome(transportadora.getNome());
		transportadoraBD.setEndereco(transportadora.getEndereco());
		transportadoraBD.setContato(transportadora.getContato());
		transportadoraBD.setTel(transportadora.getTel());
		transportadoraBD.setCodCidade(transportadora.getCodCidade());

		transportadoraRepository.save(transportadoraBD);
		
		return transportadoraBD;
	}
	
	@DeleteMapping(value="/{codTransportadora}", produces="application/json")
	public ResponseEntity<Void> deletaTransportadora(@PathVariable(value="codTransportadora") long codTransportadora){
		
		Transportadora transportadoraBD = transportadoraRepository.findByCodTransportadora(codTransportadora);
		transportadoraRepository.delete(transportadoraBD);
		
		return ResponseEntity.noContent().build();
	}
}
