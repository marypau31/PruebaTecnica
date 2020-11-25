package com.mary.prueba.service;

import java.util.List;

import com.mary.prueba.entity.Persona;

public interface IPersonaService {

	public void save(Persona persona);
	
	public List<Persona> list();
	
	public Persona detail(long id);
	
	public void delete(long id);
}
