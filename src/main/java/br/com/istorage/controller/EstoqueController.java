package br.com.istorage.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.istorage.model.Estoque;
import br.com.istorage.model.Pedido;
import br.com.istorage.model.RegistrosRetiradas;
import br.com.istorage.service.EstoqueService;
import br.com.istorage.service.PedidoService;
import br.com.istorage.service.RegistrosService;

@Controller
@CrossOrigin
@RequestMapping("/estoque")
public class EstoqueController {

	@Autowired
	private EstoqueService estoqueService;
	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private RegistrosService registroService;
	

	@GetMapping
	public ResponseEntity<List<Estoque>> consultarTodosProdutos() {
		List<Estoque> list = this.estoqueService.consultarTodosProdutosDoEstoque();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Estoque> buscarEstoqueId(@PathVariable int id) {
		Estoque estoque = this.estoqueService.consultarProdutoId(id);
		return ResponseEntity.ok().body(estoque);
	}


	@PatchMapping(value = "/adicionar/{id}")
	public ResponseEntity<Estoque> adicionarNoEstoque(@PathVariable int id, @RequestBody Pedido pedido) {
		
		int idProdutoEstoque = id;
		
		//1- Busca o produto no estoque
		Estoque estoque = this.estoqueService.consultarProdutoId(pedido.getProduto().getId());
		
		//2- Adiciona os produtos no estoque
		estoque.setQuantidade(estoque.getQuantidade() + pedido.getQuantidade());
		estoque.setUnidadeMedida(pedido.getUnidadeMedida());
		
		this.estoqueService.atualizarProdutosInclusao(idProdutoEstoque, estoque);
		
		//3- Deleta o pedido
		this.pedidoService.deletarPedido(idProdutoEstoque);
		
		return ResponseEntity.ok().body(estoque);
	}
	
	@PatchMapping(value = "/retirar/{id}")
	public ResponseEntity<Estoque> removerDoEstoque(@PathVariable int id, @RequestBody Estoque estoque) {
		Estoque estoqueAtt = this.estoqueService.atualizarProdutos(id, estoque);
		
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		
		RegistrosRetiradas registro = new RegistrosRetiradas();
		registro.setDataRetirada(timeStamp);
		registro.setNome(estoque.getNomeProduto());
		registro.setQuantidade(estoque.getQuantidade());
		this.registroService.salvarRegistro(registro);
		
		return ResponseEntity.ok().body(estoqueAtt);
	}

}
