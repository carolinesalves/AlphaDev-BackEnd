package br.com.istorage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.istorage.model.Fornecedor;
import br.com.istorage.service.FornecedorService;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;

	
	@GetMapping
	public ResponseEntity<List<Fornecedor>> findAll(){
		List<Fornecedor> list = this.fornecedorService.consultarTodosFornecedores();
	
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Fornecedor> consultarFornecedor(@PathVariable int id) {
		Fornecedor fornecedor = this.fornecedorService.consultarFornecedorId(id);
		return ResponseEntity.ok().body(fornecedor);
	}

	
	@PostMapping
	public ResponseEntity<Fornecedor> salvarFornecedor(@RequestBody Fornecedor fornecedor) {
		Fornecedor fornecedorSave = this.fornecedorService.salvarFornecedor(fornecedor);
		return ResponseEntity.ok().body(fornecedorSave);
	}

	@PatchMapping(value = "{id}")
	public ResponseEntity<Fornecedor> atualizarFornecedor(@PathVariable int id, @RequestBody Fornecedor fornecedor) {
		Fornecedor fornecedorAtt = this.fornecedorService.atualizarFornecedor(id, fornecedor);
		return ResponseEntity.ok().body(fornecedorAtt);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable int id) {
		this.fornecedorService.deletarFornecedor(id);
	}
}
