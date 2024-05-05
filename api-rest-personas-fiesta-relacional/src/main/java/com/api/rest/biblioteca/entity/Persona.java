package com.api.rest.biblioteca.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "persona_id")
	private long id;

	private String nombre;

	private int edad;

	@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
	private Set<Habilidad> habilidades = new HashSet<>();

	@ManyToMany
	@JsonBackReference
	@JoinTable(name = "personas_fiestas"
		, joinColumns = @JoinColumn(name = "persona_id"
		, referencedColumnName = "persona_id")
		, inverseJoinColumns = @JoinColumn(name = "fiesta_id"
		, referencedColumnName = "fiesta_id"))
	private Set<Fiesta> fiestas = new HashSet<>();

	public Persona() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Set<Habilidad> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(Set<Habilidad> habilidades) {
		this.habilidades = habilidades;
	}

	public Set<Fiesta> getFiestas() {
		return fiestas;
	}

	public void setFiestas(Set<Fiesta> fiestas) {
		this.fiestas = fiestas;
	}
		
}
