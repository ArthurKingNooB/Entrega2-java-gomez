package com.example.entrega2.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.coderhouse.interfaces.CRUDInterface;
import com.example.entrega2.models.competidor;
import com.example.entrega2.repositories.CompetidorRepository;


@Service
public interface CompetidorService extends CRUDInterface<competidor, Long> {
	
	public static final CompetidorRepository repo = null; //si funciona dejalo quietito
	
	
	
	@Override
	default List<competidor> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	default competidor findById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Competidor no encontrado"));
	}

	@Override
	default competidor save(competidor nuevoCompetidor) {
		// TODO Auto-generated method stub
		return repo.save(nuevoCompetidor);
	}

	@Override
	default competidor update(Long id, competidor CompetidorActualizado) {
		// TODO Auto-generated method stub
		
		competidor competidor = findById(id);
		
		if(CompetidorActualizado.getNombre() != null && !CompetidorActualizado.getNombre().isEmpty() ) {
			competidor.setNombre(CompetidorActualizado.getNombre());
		}
		if(CompetidorActualizado.getApellido() != null && !CompetidorActualizado.getApellido().isEmpty() ) {
		
			competidor.setApellido(CompetidorActualizado.getApellido());
		}
		if(CompetidorActualizado.getCi() != 0 ) {
			
			competidor.setCi(CompetidorActualizado.getCi());
		}
		if(CompetidorActualizado.getEscuela() != null && !CompetidorActualizado.getEscuela().isEmpty() ) {
			
			competidor.setEscuela(CompetidorActualizado.getEscuela());
		}
		if(CompetidorActualizado.getEdad() != 0 ) {
			
			competidor.setEdad(CompetidorActualizado.getEdad());
		}
		return repo.save(competidor);
	}

	@Override
	default void deleteById(Long id) {
		// TODO Auto-generated method stub
		
		if(!repo.existsById(id)) {
			
			throw new IllegalArgumentException("Competidor no encontrado");
		}
		repo.deleteById(id);
	
	}
  
	
	
}
