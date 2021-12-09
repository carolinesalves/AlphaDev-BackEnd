package br.com.istorage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.istorage.model.RegistrosRetiradas;
import br.com.istorage.service.RegistrosService;

@Controller
@CrossOrigin
@RequestMapping("/registro")
public class RegistroController {

	@Autowired
	private RegistrosService service;

	@GetMapping
	public ResponseEntity<List<RegistrosRetiradas>> consultarTodosRegistros() {
		List<RegistrosRetiradas> list = this.service.consultarTodosRegistros();

		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<RegistrosRetiradas> salvarRegistrosRetiradas(
			@RequestBody RegistrosRetiradas registrosRetiradas) {
		RegistrosRetiradas registroSave = this.service.salvarRegistro(registrosRetiradas);
		return ResponseEntity.ok().body(registroSave);
	}

}
