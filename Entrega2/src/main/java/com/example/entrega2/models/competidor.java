package com.example.entrega2.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="competidor")
public class competidor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="Nombre", nullable = false)
	private String nombre;
	
	@Column(name ="Apellido", nullable = false)
	private String Apellido;
	
	@Column(name ="Cedula", nullable = false, unique = true)
	private int ci;
	
	@Column(name ="Edad")
	private int edad;
	
	@Column(name ="Escuela")
	private String Escuela;
	
	private LocalDateTime createAt;
	
	@ManyToMany(mappedBy = "competidor", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<competicion> competicion = new ArrayList<>();

	public competidor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public competidor(String nombre, String apellido, int ci, int edad, String escuela) {
		super();
		this.nombre = nombre;
		Apellido = apellido;
		this.ci = ci;
		this.edad = edad;
		Escuela = escuela;
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

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public int getCi() {
		return ci;
	}

	public void setCi(int ci) {
		this.ci = ci;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEscuela() {
		return Escuela;
	}

	public void setEscuela(String escuela) {
		Escuela = escuela;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public List<competicion> getCompeticion() {
		return competicion;
	}

	public void setCompeticion(List<competicion> competicion) {
		this.competicion = competicion;
	}

	@Override
	public String toString() {
		return "competidor [id=" + id + ", nombre=" + nombre + ", Apellido=" + Apellido + ", ci=" + ci + ", edad="
				+ edad + ", Escuela=" + Escuela + ", createAt=" + createAt + "]";
	}
	
	
	
}
