package com.example.entrega2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.models.Categoria;
import com.coderhouse.repositories.CategoriaRepository;



@RestController
@RequestMapping("/api/Categoria")
public class CategoriaControllers {

	@Autowired
	private CategoriaRepository catRepository;
	
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAllCategorias(){
		try {
			
			List<Categoria> Categorias = catRepository.findAll();
			return ResponseEntity.ok(Categorias);
			
		}catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	



@GetMapping("/{CompetidorId}")
public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long CategoriaId){

	
	try {
		
	if(!catRepository.existsById(CategoriaId)) {
		
		return ResponseEntity.notFound().build();
	}
	Categoria categoria = catRepository.findById(CategoriaId).get();
	return ResponseEntity.ok(categoria);
	}catch(Exception e) {
		return ResponseEntity.internalServerError().build();
	}


}




@PostMapping("/create")
public ResponseEntity<Categoria> createcategoria(@RequestBody Categoria categoria){
	
	try {
		
		
		Categoria categoriaCreado = catRepository.save(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaCreado);
		}catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
		
	}
	
}
	
	


