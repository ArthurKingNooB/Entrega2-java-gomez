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

import com.example.entrega2.models.competicion;
import com.example.entrega2.models.competidor;
import com.example.entrega2.repositories.CompeticionRepository;

@RestController
@RequestMapping("/api/competicion")
public class CompeticionController {

	
	@Autowired
	private CompeticionRepository competicionRepository;
	
	
	
	@GetMapping
	public ResponseEntity<List<competicion>> getAllCompetidor(){
	try {
		
		List<competicion> competicion = competicionRepository.findAll();
		return ResponseEntity.ok(competicion);
		
	}catch(Exception e) {
		return ResponseEntity.internalServerError().build();
	}
	}
	
	
	@GetMapping("/{CompetidorId}")
	public ResponseEntity<competicion> getCompeticionById(@PathVariable Long CompeticionId){
	
		
		try {
			
		if(competicionRepository.existsById(CompeticionId)) {
			competicion competicion = competicionRepository.findById(CompeticionId).get();
			return ResponseEntity.ok(competicion);
		}else {
			return ResponseEntity.notFound().build();
		}
			
		}catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<competicion> createCompeticion(@RequestBody competidor competicion){
		
		try {
			
			
			competicion competicionCreado = competicionRepository.save(competicion);
			return ResponseEntity.status(HttpStatus.CREATED).body(competicionCreado);
			}catch(Exception e) {
				return ResponseEntity.internalServerError().build();
			}
			
			
		}
	
	
}
