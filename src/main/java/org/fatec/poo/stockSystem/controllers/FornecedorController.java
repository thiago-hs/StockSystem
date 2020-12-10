package org.fatec.poo.stockSystem.controllers;

import org.fatec.poo.stockSystem.models.Cidade;
import org.fatec.poo.stockSystem.models.Fornecedor;
import org.fatec.poo.stockSystem.repository.CidadeRepository;
import org.fatec.poo.stockSystem.repository.FornecedorRepository;
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
@RequestMapping("/api/fornecedor")
@CrossOrigin(origins="*")
public class FornecedorController {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@GetMapping(produces="application/json")
	public @ResponseBody  Iterable<Fornecedor> listaFornecedor(){
		Iterable<Fornecedor> lista = fornecedorRepository.findAll();
		return lista;
	}
	
	@GetMapping(value="/{codFornecedor}", produces="application/json")
	public @ResponseBody Fornecedor fornecedor(@PathVariable(value="codFornecedor") long codFornecedor){
		Fornecedor fornecedor = fornecedorRepository.findByCodFornecedor(codFornecedor);
		return fornecedor;
	}
	
	@PostMapping()
	public Fornecedor cadastraFornecedor(@RequestBody Fornecedor fornecedor){
		
		Cidade cidade = cidadeRepository.findByCodCidade(fornecedor.getCodCidade());
		
		fornecedor.setCidade(cidade);
		
		fornecedorRepository.save(fornecedor);
		return fornecedor;
	}
	
	@PutMapping(value="/{codFornecedor}", produces="application/json")
	public Fornecedor atualizaFornecedor(@PathVariable(value="codFornecedor") long codFornecedor, @RequestBody Fornecedor fornecedor){
		
		Fornecedor fornecedorBD = fornecedorRepository.findByCodFornecedor(codFornecedor);
		
		Cidade cidade = cidadeRepository.findByCodCidade(fornecedor.getCodCidade());

		fornecedorBD.setNome(fornecedor.getNome());
		fornecedorBD.setEndereco(fornecedor.getEndereco());
		fornecedorBD.setBairro(fornecedor.getBairro());
		fornecedorBD.setCep(fornecedor.getCep());
		fornecedorBD.setEmail(fornecedor.getEmail());
		fornecedorBD.setCnpj(fornecedor.getCnpj());
		fornecedorBD.setTel(fornecedor.getTel());
		fornecedorBD.setCidade(cidade);
		
		fornecedorRepository.save(fornecedorBD);
		
		return fornecedorBD;
	}
	
	@DeleteMapping(value="/{codFornecedor}", produces="application/json")
	public ResponseEntity<Void> deletaFornecedor(@PathVariable(value="codFornecedor") long codFornecedor){
		
		Fornecedor fornecedorBD = fornecedorRepository.findByCodFornecedor(codFornecedor);
		fornecedorRepository.delete(fornecedorBD);
		
		return ResponseEntity.noContent().build();
	}
}
