package com.api.rest.biblioteca.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.biblioteca.entity.Fiesta;

@Repository
public interface RepoFiesta extends CrudRepository<Fiesta, Long>
{
	Collection<Fiesta> findAll();

}
