package com.api.rest.biblioteca.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.biblioteca.entity.Persona;

@Repository
public interface RepoPersona extends CrudRepository<Persona, Long>
{
	Collection<Persona> findAll();
}
