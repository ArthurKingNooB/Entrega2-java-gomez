package com.example.entrega2.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="Categorias")
public class Categoria {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="Nombre", nullable = false)
	private String nombre;
	
	@ManyToMany(mappedBy = "Categoria", fetch = FetchType.EAGER)
	private List<competicion> competicion = new ArrayList<>();

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<competicion> getCompeticion() {
		return competicion;
	}

	public void setCompeticion(List<competicion> competicion) {
		this.competicion = competicion;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre  + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
