package com.mary.prueba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mary.prueba.entity.Persona;
import com.mary.prueba.repository.PersonaRepository;
import com.mary.prueba.service.IPersonaService;

@Service
@Transactional
public class PersonaServiceImpl implements IPersonaService {
	
	@Autowired
	private PersonaRepository repository;

	@Override
	public void save(Persona persona) {
		repository.save(persona);		
	}

	@Override
	public List<Persona> list() {
		return repository.findAll();
	}

	@Override
	public Persona detail(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void delete(long id) {
		repository.deleteById(id);		
	}

}
