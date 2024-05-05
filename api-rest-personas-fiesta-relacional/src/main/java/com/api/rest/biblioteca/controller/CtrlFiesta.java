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
import com.api.rest.biblioteca.repository.RepoFiesta;

@RestController
@RequestMapping("/api/fiestas")
public class CtrlFiesta
{
	@Autowired
	private RepoFiesta repoFiesta;
	
	@GetMapping
	public ResponseEntity<Collection<Fiesta>> listarFiestas()
	{
		return new ResponseEntity<>(repoFiesta.findAll(),HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Fiesta> obtenerFiestaPorId(@PathVariable long id)
	{
		Fiesta fiesta = repoFiesta.findById(id).orElseThrow();

		if (fiesta != null)
		{
			return new ResponseEntity<>(repoFiesta.findById(id).orElseThrow(),HttpStatus.OK);	
		}
		else
		{
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<?> guardarFiesta(@RequestBody Fiesta fiesta)
	{
		return new ResponseEntity<>(repoFiesta.save(fiesta),HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarFiesta(@PathVariable long id)
	{
		repoFiesta.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
