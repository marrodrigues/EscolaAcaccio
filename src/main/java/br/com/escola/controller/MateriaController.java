package br.com.escola.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.escola.model.Materia;
import br.com.escola.model.Professor;
import br.com.escola.service.MateriaService;
import br.com.escola.service.ProfessorService;
import br.com.escola.service.exception.MaxDisponibilidadeException;

@RestController
@RequestMapping("/api/")
public class MateriaController {

	@Autowired
	private MateriaService materiaService;

	@GetMapping(value = "materia")
	public ResponseEntity listarMaterias() {
		List<Materia> all = materiaService.getAll();
		return ResponseEntity.ok(all);
	}
	
	@GetMapping(value = "materia/{materiaId}")
	public ResponseEntity buscarMateria(@PathVariable("materiaId") Integer materiaId) {
		Materia materia = materiaService.findById(materiaId);
		return ResponseEntity.ok(materia);
	}

	@PostMapping(value = "materia")
	public ResponseEntity criarMateria(@RequestBody Materia materia) {
		
		try {
			materia = materiaService.save(materia);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(e.getMessage());
		}

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(materia.getMateriaId()).toUri();

		return ResponseEntity.created(uri).build();
		
	}
	
}
