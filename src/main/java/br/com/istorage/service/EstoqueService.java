package br.com.istorage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.istorage.model.Estoque;
import br.com.istorage.repository.EstoqueRepository;

@Service
public class EstoqueService {

	@Autowired
	public EstoqueRepository estoqueRepository;

	public Estoque adicionarProduto(Estoque estoque) {
		Estoque newProduto = estoque.toEntity();
		return this.estoqueRepository.save(newProduto);
	}

	public Estoque consultarProdutoId(int id) {
		return this.estoqueRepository.findById(id).orElse(null);
	}

	public List<Estoque> consultarTodosProdutosDoEstoque() {
		return this.estoqueRepository.findAll();
	}
	
	public void deletarProdutoDoEstoque(int id) {
		this.estoqueRepository.deleteById(id);
	}
	
	public Estoque atualizarProdutos(int id, Estoque estoque) {
		Estoque estoqueAtt = estoque.toEntity();
		Optional<Estoque> obj = this.estoqueRepository.findById(id);
		Estoque update = null;
		
		if (obj.isPresent() ) {
			update = obj.get();
			
			update.setFornecedor(estoqueAtt.getFornecedor());
			update.setProduto(estoqueAtt.getProduto());
			update.setQuantidade(estoqueAtt.getQuantidade());
			update.setUnidade(estoqueAtt.getUnidade());
			
			update = this.estoqueRepository.save(update);
			
		}
		return update;
	}

}
