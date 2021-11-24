package br.com.istorage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.istorage.model.Pedido;
import br.com.istorage.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	public PedidoRepository pedidoRepository;
	
	public Pedido salvarPedido (Pedido pedido) {
		Pedido newPedido = pedido.toEntity();
		return this.pedidoRepository.save(newPedido);
	}

	public Pedido consultarPedidoId(int id) {
		return this.pedidoRepository.findById(id).orElse(null);
	}

	public List<Pedido> consultarTodosPedidos() {
		return this.pedidoRepository.findAll();
	}

	public void deletarPedido(int id) {
		this.pedidoRepository.deleteById(id);
	}

	public Pedido atualizarPedido (int id, Pedido pedido) {
		Pedido pedidoAtt = pedido.toEntity();
		Optional<Pedido> obj = this.pedidoRepository.findById(id);
		Pedido update = null;

		if (obj.isPresent()) {
			update = obj.get();

			update.setFornecedor(pedidoAtt.getFornecedor());
			update.setProduto(pedidoAtt.getProduto());
			update.setQuantidade(pedidoAtt.getQuantidade());
			update.setUnidadeMedida(pedidoAtt.getUnidadeMedida());

			update = this.pedidoRepository.save(update);
		}
		return update;

	}
}
