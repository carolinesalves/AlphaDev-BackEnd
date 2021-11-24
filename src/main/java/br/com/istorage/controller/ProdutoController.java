package br.com.istorage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.istorage.model.Produto;
import br.com.istorage.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> list = this.produtoService.consultarTodosProdutos();
	
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> consultarProduto(@PathVariable int id) {
		Produto produto = this.produtoService.consultarProdutoId(id);
		return ResponseEntity.ok().body(produto);
	}
	
	@PostMapping
	public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
		Produto produtoSave = this.produtoService.salvarProduto(produto);
		return ResponseEntity.ok().body(produtoSave);
	}
	
	@PatchMapping(value = "{id}")
	public ResponseEntity<Produto> atualizarProduto(@PathVariable int id, @RequestBody Produto produto) {
		Produto produtoAtt = this.produtoService.atualizarProdutos(id, produto);
		return ResponseEntity.ok().body(produtoAtt);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable int id) {
		this.produtoService.deletarProdutos(id);
	}
}