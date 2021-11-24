package br.com.istorage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.istorage.model.Produto;
import br.com.istorage.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	public ProdutoRepository produtoRepository;
	
	public Produto salvarProduto(Produto produto) {
		Produto newProduto = produto.toEntity();
		return this.produtoRepository.save(newProduto);
	}

	public Produto consultarProdutoId(int id) {
		return this.produtoRepository.findById(id).orElse(null);
	}
	
	public List<Produto> consultarTodosProdutos() {
		return this.produtoRepository.findAll();
	}
	
	public void deletarProdutos(int id) {
		this.produtoRepository.deleteById(id);
	}
	
	public Produto atualizarProdutos(int id, Produto produto) {
		Produto produtoAtt = produto.toEntity();
		Optional<Produto> obj = this.produtoRepository.findById(id);
		Produto update = null;

		if (obj.isPresent()) {
			update = obj.get();

			update.setNome(produtoAtt.getNome());
			update.setQuantidade(produtoAtt.getQuantidade());
			update.setDescricao(produtoAtt.getDescricao());
		
			update = this.produtoRepository.save(update);
		}
		return update;

	}
}
