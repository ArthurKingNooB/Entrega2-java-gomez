package com.example.entrega2.models;

import java.util.ArrayList;
import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="competiciones")
public class competicion {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="Nombre", nullable = false)
	private String nombre;
	
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "competicion_competidor", 
		joinColumns = @JoinColumn(name = "competicion_id"), 
		inverseJoinColumns = @JoinColumn(name = "competidor_id"))
	private List<competidor> competidor = new ArrayList<>();
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Categoria categoria;


	public competicion() {
		super();
		// TODO Auto-generated constructor stub
	}


	public competicion(String nombre) {
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


	public List<competidor> getCompetidor() {
		return competidor;
	}


	public void setCompetidor(List<competidor> competidor) {
		this.competidor = competidor;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	@Override
	public String toString() {
		return "competicion [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
	
	
}
