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

import br.com.istorage.model.Pedido;
import br.com.istorage.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll(){
		List<Pedido> list = this.pedidoService.consultarTodosPedidos();
	
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> consultarPedido(@PathVariable int id) {
		Pedido pedido = this.pedidoService.consultarPedidoId(id);
		return ResponseEntity.ok().body(pedido);
	}

	
	@PostMapping
	public ResponseEntity<Pedido> salvarFornecedor(@RequestBody Pedido pedido) {
		Pedido pedidoSave = this.pedidoService.salvarPedido(pedido);
		return ResponseEntity.ok().body(pedidoSave);
	}

	@PatchMapping(value = "{id}")
	public ResponseEntity<Pedido> atualizarFornecedor(@PathVariable int id, @RequestBody Pedido pedido) {
		Pedido pedidoAtt = this.pedidoService.atualizarPedido(id, pedido);
		return ResponseEntity.ok().body(pedidoAtt);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable int id) {
		this.pedidoService.deletarPedido(id);
	}
	
}
