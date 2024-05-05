package com.api.rest.biblioteca.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.biblioteca.entity.Fiesta;
import com.api.rest.biblioteca.entity.Persona;
import com.api.rest.biblioteca.repository.RepoPersona;

@RestController
@RequestMapping("/api/personas")
public class CtrlPersona
{
	@Autowired
	private RepoPersona repoPersona;
	
	@GetMapping
	public ResponseEntity<Collection<Persona>> listarPersonas()
	{
		return new ResponseEntity<>(repoPersona.findAll(),HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable long id)
	{
		Persona persona = repoPersona.findById(id).orElseThrow();

		if (persona != null)
		{
			return new ResponseEntity<>(repoPersona.findById(id).orElseThrow(),HttpStatus.OK);	
		}
		else
		{
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<?> guardarPersona(@RequestBody Persona persona)
	{
		return new ResponseEntity<>(repoPersona.save(persona),HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarPersona(@PathVariable long id)
	{
		repoPersona.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/{id}/fiestas")
	public ResponseEntity<Collection<Fiesta>> listarFiestasDePersona(@PathVariable long id)
	{
		Persona persona = repoPersona.findById(id).orElseThrow();
		if (persona != null)
		{
			return new ResponseEntity<>(persona.getFiestas(),HttpStatus.OK);	
		}
		else
		{
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}
}
