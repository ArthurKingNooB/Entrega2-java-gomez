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

import com.example.entrega2.models.competidor;
import com.example.entrega2.repositories.CompeticionRepository;
import com.example.entrega2.repositories.CompetidorRepository;

@RestController
@RequestMapping("/api/competidor")
public class CompetidorController {

    private final CompeticionRepository competicionRepository;
	
	
	@Autowired
	private CompetidorRepository competidorRepository;

    CompetidorController(CompeticionRepository competicionRepository) {
        this.competicionRepository = competicionRepository;
    }

	@GetMapping
	public ResponseEntity<List<competidor>> getAllCompetidor(){
		try {
			
			List<competidor> competidor = competidorRepository.findAll();
			return ResponseEntity.ok(competidor);
			
		}catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	
		
	
	}
	
	@GetMapping("/{CompetidorId}")
	public ResponseEntity<competidor> getCompetidorById(@PathVariable Long CompetidorId){
	
		
		try {
			
		if(competicionRepository.existsById(CompetidorId)) {
			competidor competidor = competidorRepository.findById(CompetidorId).get();
			return ResponseEntity.ok(competidor);
		}else {
			return ResponseEntity.notFound().build();
		}
			
		}catch(Exception e) {
			return ResponseEntity.internalServerError().build();
		}
		
		
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<competidor> createCompetidor(@RequestBody competidor competidor){
		
		try {
			
			
			competidor competidorCreado = competidorRepository.save(competidor);
			return ResponseEntity.status(HttpStatus.CREATED).body(competidorCreado);
			}catch(Exception e) {
				return ResponseEntity.internalServerError().build();
			}
			
			
		}
		
		
		
		
	}
	

