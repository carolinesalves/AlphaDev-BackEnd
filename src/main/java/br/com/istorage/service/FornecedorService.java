package br.com.istorage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.istorage.model.Fornecedor;
import br.com.istorage.repository.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	public FornecedorRepository fornecedorRepository;

	public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
		Fornecedor newFornecedor = fornecedor.toEntity();
		return this.fornecedorRepository.save(newFornecedor);
	}

	public Fornecedor consultarFornecedorId(int id) {
		return this.fornecedorRepository.findById(id).orElse(null);
	}

	public List<Fornecedor> consultarTodosFornecedores() {
		return this.fornecedorRepository.findAll();
	}

	public void deletarFornecedor(int id) {
		this.fornecedorRepository.deleteById(id);
	}

	public Fornecedor atualizarFornecedor(int id, Fornecedor fornecedor) {
		Fornecedor fornecedorAtt = fornecedor.toEntity();
		Optional<Fornecedor> obj = this.fornecedorRepository.findById(id);
		Fornecedor update = null;

		if (obj.isPresent()) {
			update = obj.get();

			update.setNomeFornecedor(fornecedorAtt.getNomeFornecedor());
			update.setCnpj(fornecedorAtt.getCnpj());
			update.setObservacao(fornecedorAtt.getObservacao());
			update.setInscricaoEsdadual(fornecedorAtt.getInscricaoEsdadual());

			update = this.fornecedorRepository.save(update);
		}
		return update;

	}
}
