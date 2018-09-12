package br.com.escola.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.escola.model.Professor;
import br.com.escola.service.ProfessorService;
import br.com.escola.service.exception.MaxDisponibilidadeException;

@RestController
@RequestMapping("/api/")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	@GetMapping(value = "professor")
	public ResponseEntity listarProfessores() {
		List<Professor> all = professorService.getAll();
		return ResponseEntity.ok(all);
	}

	@PostMapping(value = "professor")
	public ResponseEntity criarProfessor(@RequestBody Professor professorDTO) {
		
		try {
			professorDTO = professorService.save(professorDTO);
		} catch (MaxDisponibilidadeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(e.getMessage());
		}

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(professorDTO.getProfessorId()).toUri();

		return ResponseEntity.created(uri).build();
		
	}
}
