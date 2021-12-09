package br.com.istorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.istorage.model.RegistrosRetiradas;

@Repository
public interface RegistrosRepository extends JpaRepository<RegistrosRetiradas, Integer> {
	
}
