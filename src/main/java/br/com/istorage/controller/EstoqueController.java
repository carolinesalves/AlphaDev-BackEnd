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

import br.com.istorage.model.Estoque;
import br.com.istorage.service.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

	@Autowired
	private EstoqueService estoqueService;

	@GetMapping
	public ResponseEntity<List<Estoque>> consultarTodosProdutos() {
		List<Estoque> list = this.estoqueService.consultarTodosProdutosDoEstoque();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Estoque> consultarEstoquePorIdProduto(@PathVariable int id) {
		Estoque estoque = this.estoqueService.consultarProdutoId(id);
		return ResponseEntity.ok().body(estoque);
	}

	@PostMapping
	public ResponseEntity<Estoque> salvarProduto(@RequestBody Estoque estoque) {
		Estoque estoqueSave = this.estoqueService.adicionarProduto(estoque);
		return ResponseEntity.ok().body(estoqueSave);
	}

	@PatchMapping(value = "{id}")
	public ResponseEntity<Estoque> atualizarEstoque(@PathVariable int id, @RequestBody Estoque estoque) {
		Estoque estoqueAtt = this.estoqueService.atualizarProdutos(id, estoque);
		return ResponseEntity.ok().body(estoqueAtt);
	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable int id) {
		this.estoqueService.deletarProdutoDoEstoque(id);
	}
}
