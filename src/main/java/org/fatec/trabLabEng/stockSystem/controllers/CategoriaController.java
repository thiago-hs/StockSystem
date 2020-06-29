package org.fatec.trabLabEng.stockSystem.controllers;

import org.fatec.trabLabEng.stockSystem.models.Categoria;
import org.fatec.trabLabEng.stockSystem.repository.CategoriaRepository;
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
@RequestMapping("/api/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Categoria> listaCategorias(){
		Iterable<Categoria> listaCategoria = categoriaRepository.findAll();
		return listaCategoria;
	}
	
	@GetMapping(value="/{codCategoria}", produces="application/json")
	public @ResponseBody Categoria categoria(@PathVariable(value="codCategoria") long codCategoria){
		Categoria categoria = categoriaRepository.findByCodCategoria(codCategoria);
		return categoria;
	}
	
	@PostMapping()
	public Categoria cadastraCategoria(@RequestBody Categoria categoria){
		categoriaRepository.save(categoria);
		return categoria;
	}
	
	@PutMapping(value="/{codCategoria}", produces="application/json")
	public Categoria atualizaCategoria(@PathVariable(value="codCategoria") long codCategoria, @RequestBody Categoria categoria){
		
		Categoria categoriaBD = categoriaRepository.findByCodCategoria(codCategoria);

		categoriaBD.setNome(categoria.getNome());
		
		categoriaRepository.save(categoriaBD);
		
		return categoriaBD;
	}
	
	@DeleteMapping(value="/{codCategoria}", produces="application/json")
	public ResponseEntity<Void> deletaCategoria(@PathVariable(value="codCategoria") long codCategoria){
		
		Categoria categoriaBD = categoriaRepository.findByCodCategoria(codCategoria);
		categoriaRepository.delete(categoriaBD);
		
		return ResponseEntity.noContent().build();
	}
	
}