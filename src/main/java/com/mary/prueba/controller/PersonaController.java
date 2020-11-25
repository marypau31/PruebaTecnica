package com.mary.prueba.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mary.prueba.entity.Persona;
import com.mary.prueba.service.IPersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	
	@Autowired
	private IPersonaService service;

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Persona persona) {
		persona.setFechaCreacion(LocalDateTime.now());
		service.save(persona);
		return ResponseEntity.status(201).build();
	}
	
	@GetMapping
	public ResponseEntity<?> listar() {
		List<Persona> personaList = service.list();
		return ResponseEntity.status(201).body(personaList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> detalle(@PathVariable long id) {
		Persona persona = service.detail(id);
		return ResponseEntity.status(201).body(persona);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Persona persona, @PathVariable long id) {
		if(id == persona.getId()) {
			service.save(persona);
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(409).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> borrar(@PathVariable long id) {
		service.delete(id);
		return ResponseEntity.status(204).build();
	}
}
