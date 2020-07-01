package org.fatec.trabLabEng.stockSystem.controllers;

import org.fatec.trabLabEng.stockSystem.models.Entrada;
import org.fatec.trabLabEng.stockSystem.models.Transportadora;
import org.fatec.trabLabEng.stockSystem.repository.EntradaRepository;
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
@RequestMapping("/api/entrada")
@CrossOrigin(origins="*")
public class EntradaController {

	@Autowired
	private EntradaRepository entradaRepository;
	
	@Autowired
	private TransportadoraRepository transportadoraRepository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody  Iterable<Entrada> listaEstradas(){
		Iterable<Entrada> lista = entradaRepository.findAll();
		return lista;
	}
	
	@GetMapping(value="/{codEntrada}", produces="application/json")
	public @ResponseBody Entrada entrada(@PathVariable(value="codEntrada") long codEntrada){
		Entrada entrada = entradaRepository.findByCodEntrada(codEntrada);
		return entrada;
	}
	
	@PostMapping()
	public Entrada cadastraEntrada(@RequestBody Entrada entrada){
		Transportadora transportadora = transportadoraRepository.findByCodTransportadora(entrada.getCodTransportadora());
		entrada.setTransportadora(transportadora);
		entradaRepository.save(entrada);
		return entrada;
	}
	
	@PutMapping(value="/{codEntrada}", produces="application/json")
	public Entrada atualizaEntrada(@PathVariable(value="codEntrada") long codEntrada, @RequestBody Entrada entrada){
		
		Entrada entradaBD = entradaRepository.findByCodEntrada(codEntrada);

		Transportadora transportadora = transportadoraRepository.findByCodTransportadora(entrada.getCodTransportadora());
		
		entradaBD.setTransportadora(transportadora);
		entradaBD.setDataPedido(entrada.getDataPedido());
		entradaBD.setDataEntrada(entrada.getDataEntrada());
		entradaBD.setTotal(entrada.getTotal());
		entradaBD.setNumNota(entrada.getNumNota());
		
		entradaRepository.save(entradaBD);
		
		return entradaBD;
	}
	
	@DeleteMapping(value="/{codEntrada}", produces="application/json")
	public ResponseEntity<Void> deletaCategoria(@PathVariable(value="codEntrada") long codEntrada){
		
		Entrada entradaBD = entradaRepository.findByCodEntrada(codEntrada);
		entradaRepository.delete(entradaBD);
		
		return ResponseEntity.noContent().build();
	}
	
}