package com.mary.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mary.prueba.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
