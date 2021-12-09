package br.com.istorage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.istorage.model.RegistrosRetiradas;
import br.com.istorage.repository.RegistrosRepository;

@Service
public class RegistrosService {

	@Autowired
	public RegistrosRepository repository;
	
	public RegistrosRetiradas salvarRegistro (RegistrosRetiradas registro) {
		RegistrosRetiradas newRegistro = registro.toEntity();
		return this.repository.save(newRegistro);
	}
	
	public List<RegistrosRetiradas> consultarTodosRegistros() {
		return this.repository.findAll();
	}
}
