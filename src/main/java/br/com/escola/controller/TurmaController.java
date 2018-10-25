package br.com.escola.controller;

import java.net.URI;
import java.util.Objects;

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

import br.com.escola.model.Professor;
import br.com.escola.model.Turma;
import br.com.escola.service.MateriaService;
import br.com.escola.service.TurmaService;
import br.com.escola.service.exception.MaxDisponibilidadeException;
import br.com.escola.service.exception.MinDisponibilidadeException;

@RestController
@RequestMapping("/api/")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private MateriaService materia;
	
	@GetMapping(value = "turma")
	public ResponseEntity listarTurmas() {
		return ResponseEntity.status(HttpStatus.OK).body(turmaService.getAll());
	}
	
	@GetMapping(value = "turma/{codigo}")
	public ResponseEntity buscarTurmaCodigo(@PathVariable("codigo") String codigo) {
		try {
			Turma turma = turmaService.findByCodigo(codigo);
			if(Objects.isNull(turma)) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turma inexistente");
			}
			return ResponseEntity.ok(turma);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(e.getMessage());
		}
	}
	
	@PostMapping(value = "turma")
	public ResponseEntity criarProfessor(@RequestBody Turma turma) {
		
		try {
			turma = turmaService.save(turma);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(e.getMessage());
		}

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(turma.getTurmaId()).toUri();

		return ResponseEntity.created(uri).build();
		
	}
	
}
